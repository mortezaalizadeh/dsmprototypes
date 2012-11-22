/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.common.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.basicimplementations.BasicGuiceInjectorModule;
import dsm.common.DsmManifest;
import dsm.common.configuration.ConfigurationParser;
import dsm.common.configuration.ConfigurationParserException;
import dsm.daemon.common.DaemonStartupInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * BasicConfigurationParser is a basic implementation for ConfigurationParser.
 *
 * @version 0.1, November 21, 2012
 * @author Morteza Alizadeh
 */
public class BasicConfigurationParser  extends DsmManifest implements ConfigurationParser {

    /**
     * Reference to dependency injector.
     */
    private static Injector dependecyInjector = Guice.createInjector(
            new BasicGuiceInjectorModule());

    /**
     * Daemon tag.
     */
    private static final String DAEMON_TAG = "daemon";

    /**
     * Unique identifier tag.
     */
    private static final String UNIQUE_IDENTIFIER_TAG = "unique_identifier";

    /**
     * Library tag.
     */
    private static final String LIBRARY_TAG = "library";

    /**
     * Package name tag.
     */
    private static final String PACKAGE_NAME_TAG = "package_name";

    /**
     * Class name tag.
     */
    private static final String CLASS_NAME_TAG = "class_name";

    /**
     * Configuration file full path tag.
     */
    private static final String CONFIGURATION_FILE_FULL_PATH_TAG = "configuration_file_full_path";

    /**
     * BasicConfigurationParser Constructor.
     */
    public BasicConfigurationParser() {
        super("a4abe9b5-f3f8-48cc-ae9a-91d8ebd3b245", "Basic Configuration Parser");
    }

    /**
     * Loads configurations from the file.
     *
     * @param configurationFilePath Path to configuration file
     */
    public void loadConfigurationsFromFile(final String configurationFilePath) {
        if (configurationFilePath == null) {
            throw new IllegalArgumentException("configurationFilePath");
        }

        if (configurationFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException("configurationFilePath");
        }

        try {
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            documentBuilderFactory.setNamespaceAware(true);

            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(configurationFilePath);
            final XPath xpath = XPathFactory.newInstance().newXPath();

            /* Reading the list of startup daemon unique identifiers... */
            final Set<String> startupDaemonList = readStartupDaemon(document, xpath, readAllDaemonsStartupInfo(document, xpath));
        } catch (ParserConfigurationException ex) {
            throw new ConfigurationParserException(ex);
        } catch (SAXException ex) {
            throw new ConfigurationParserException(ex);
        } catch (IOException ex) {
            throw new ConfigurationParserException(ex);
        } catch (XPathExpressionException ex) {
            throw new ConfigurationParserException(ex);
        } catch (Exception ex) {
            throw new ConfigurationParserException(ex);
        }
    }

    /**
     * Reads all daemons startup information from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @throws XPathExpressionException Throws in case exception occurs
     * @return Returns the list of read daemon startup information
     */
    private Map<String, DaemonStartupInfo> readAllDaemonsStartupInfo(
            final Document document,
            final XPath xpath)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        final Map<String, DaemonStartupInfo> tmpDaemonStartupInfoList = new HashMap<String, DaemonStartupInfo>();
        final XPathExpression xpathExpression = xpath.compile("configuration//daemons/*");
        final Object result = xpathExpression.evaluate(document, XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            final Node node = nodes.item(idx);
            final DaemonStartupInfo daemonStartupInfo = validateAndReadDaemonStartupInfo(xpath, node);

            if (daemonStartupInfo != null) {
                tmpDaemonStartupInfoList.put(daemonStartupInfo.getUniqueIdentifier(), daemonStartupInfo);
                
                validateAndReadAllActionManagerStartupInfo(xpath, node, daemonStartupInfo);
            }
        }

        return tmpDaemonStartupInfoList;
    }

    /**
     * Validates and makes sure DaemonStartupInfo is valid, reads them and returns
     * it.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for daemon startup information
     * @return Reference to DaemonStartupInfo or null as failure
     */
    private DaemonStartupInfo validateAndReadDaemonStartupInfo(
            final XPath xpath,
            final Node node) {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }

        DaemonStartupInfo result = null;

        do {
            String nodeName = node.getNodeName();

            if (nodeName == null) {
                break;
            }

            nodeName = nodeName.trim();

            if (nodeName.compareToIgnoreCase(BasicConfigurationParser.DAEMON_TAG) != 0) {
                break;
            }

            final NamedNodeMap attributes = node.getAttributes();
            final DaemonStartupInfo daemonStartupInfo =
                    dependecyInjector.getInstance(DaemonStartupInfo.class);

            Node attr;
            String attrValue;

            if (attributes == null) {
                break;
            }

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.UNIQUE_IDENTIFIER_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                break;
            }

            daemonStartupInfo.setUniqueIdentifier(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.LIBRARY_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                break;
            }

            daemonStartupInfo.setLibrary(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.PACKAGE_NAME_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                break;
            }

            daemonStartupInfo.setPackageName(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.CLASS_NAME_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                break;
            }

            daemonStartupInfo.setClassName(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.CONFIGURATION_FILE_FULL_PATH_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                daemonStartupInfo.setConfigurationFileFullPath("");
            } else {
                daemonStartupInfo.setConfigurationFileFullPath(attrValue);
            }
            /****************************************************/

            result = daemonStartupInfo;
        } while (false);

        return result;
    }

    /**
     * Reads all startup daemons from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @param daemonList List of all daemon startup information exist in the
     * passed document
     * @throws XPathExpressionException Throws in case exception occurs
     * @return Returns the list of read startup daemon unique identifiers
     */
    private Set<String> readStartupDaemon(
            final Document document,
            final XPath xpath,
            final Map<String, DaemonStartupInfo> daemonList)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (daemonList == null) {
            throw new IllegalArgumentException("daemonList");
        }

        /* Using HashSet to remove duplicate unique identifiers */
        final Set<String> startupDaemonList = new HashSet<String>();
        final XPathExpression xpathExpression = xpath.compile("configuration/startup//daemon_list/*/@unique_identifier");
        final Object result = xpathExpression.evaluate(document, XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            final Node node = nodes.item(idx);
            String nodeName = node.getNodeName();
            String nodeValue = node.getNodeValue();

            if (nodeName == null
                    || nodeValue == null) {
                continue;
            }

            nodeName = nodeName.trim();
            nodeValue = nodeValue.trim();

            if (nodeName.compareToIgnoreCase(BasicConfigurationParser.DAEMON_TAG) == 0
                    && !nodeValue.isEmpty()
                    && daemonList.containsKey(nodeValue)) {
                startupDaemonList.add(nodeValue);
            }
        }

        return startupDaemonList;
    }

    /**
     * Validates and reads all action manager startup information listed under
     * a daemon.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for action manager startup
     * information
     * @param daemonStartupInfo Reference to DaemonStartupInfo to add read action
     * manager startup information to
     */
    private void validateAndReadAllActionManagerStartupInfo(
            final XPath xpath,
            final Node node,
            final DaemonStartupInfo daemonStartupInfo) {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (daemonStartupInfo == null) {
            throw new IllegalArgumentException("daemonStartupInfo");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }
    }
}
