/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.common.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
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
     * BasicConfigurationParser Constructor.
     */
    public BasicConfigurationParser() {
        super("a4abe9b5-f3f8-48cc-ae9a-91d8ebd3b245", "Basic Configuration Parser");
    }

    /**
     * Reads configurations from the file.
     *
     * @param configurationFilePath Path to configuration file
     */
    public void readConfigurationsFromFile(final String configurationFilePath) {
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
     * @param xpath Reference to document object
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
            String nodeName = node.getNodeName();

            if (nodeName == null) {
                continue;
            }

            nodeName = nodeName.trim();

            if (nodeName.compareToIgnoreCase("daemon") == 0) {
                final NamedNodeMap attributes = node.getAttributes();
                final DaemonStartupInfo daemonStartupInfo =
                        dependecyInjector.getInstance(DaemonStartupInfo.class);
                Node attr;
                String attrValue;

                if (attributes == null) {
                    continue;
                }

                /****************************************************/
                attr = attributes.getNamedItem("unique_identifier");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    continue;
                }

                daemonStartupInfo.setUniqueIdentifier(attrValue);
                /****************************************************/

                /****************************************************/
                attr = attributes.getNamedItem("name");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    daemonStartupInfo.setName("");
                } else {
                    daemonStartupInfo.setName(attrValue);
                }
                /****************************************************/

                /****************************************************/
                attr = attributes.getNamedItem("library");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    continue;
                }

                daemonStartupInfo.setLibrary(attrValue);
                /****************************************************/

                /****************************************************/
                attr = attributes.getNamedItem("package_name");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    continue;
                }

                daemonStartupInfo.setPackageName(attrValue);
                /****************************************************/

                /****************************************************/
                attr = attributes.getNamedItem("class_name");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    continue;
                }

                daemonStartupInfo.setClassName(attrValue);
                /****************************************************/

                /****************************************************/
                attr = attributes.getNamedItem("configuration_file_full_path");

                if (attr == null) {
                    continue;
                }

                attrValue = attr.getNodeValue();

                if (attrValue == null) {
                    daemonStartupInfo.setConfigurationFileFullPath("");
                } else {
                    daemonStartupInfo.setConfigurationFileFullPath(attrValue);
                }
                /****************************************************/

                tmpDaemonStartupInfoList.put(daemonStartupInfo.getUniqueIdentifier(), daemonStartupInfo);
            }
        }

        return tmpDaemonStartupInfoList;
    }

    /**
     * Reads all startup daemons from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to document object
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

            if (nodeName.compareToIgnoreCase("daemon") == 0
                    && !nodeValue.isEmpty()
                    && daemonList.containsKey(nodeValue)) {
                startupDaemonList.add(nodeValue);
            }
        }

        return startupDaemonList;
    }
}
