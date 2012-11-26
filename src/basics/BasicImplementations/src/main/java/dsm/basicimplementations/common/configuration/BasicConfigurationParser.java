/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.common.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.basicimplementations.BasicGuiceInjectorModule;
import dsm.common.DsmManifest;
import dsm.common.configuration.ConfigurationParser;
import dsm.common.configuration.ConfigurationParserException;
import dsm.daemon.common.DaemonStartupInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
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
            final Map<String, ActionStartupInfo> actionStartupInfoList =
                    readAllActionStartupInfo(document, xpath);
            final Map<String, ActionManagerStartupInfo> actionManagerStartupInfoList =
                    readAllActionManagerStartupInfo(document, xpath, actionStartupInfoList);
            final Map<String, DaemonStartupInfo> daemonStartupInfoList =
                    readAllDaemonStartupInfo(document, xpath, actionManagerStartupInfoList);
            final Map<String, DaemonStartupInfo> startupDaemonList =
                    readStartupDaemonList(document, xpath, daemonStartupInfoList);
        } catch (ParserConfigurationException ex) {
            throw new ConfigurationParserException(ex);
        } catch (SAXException ex) {
            throw new ConfigurationParserException(ex);
        } catch (IOException ex) {
            throw new ConfigurationParserException(ex);
        } catch (Exception ex) {
            throw new ConfigurationParserException(ex);
        }
    }

    /**
     * Reads all action startup information from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @return Returns the list of read action startup information
     * @throws XPathExpressionException Throws in case exception occurs
     */
    private Map<String, ActionStartupInfo> readAllActionStartupInfo(
            final Document document,
            final XPath xpath)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        final Map<String, ActionStartupInfo> tmpActionStartupInfoList =
                new HashMap<String, ActionStartupInfo>();
        final Object result =
                xpath.evaluate("configuration//actions/action",
                document,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            final Node node = nodes.item(idx);
            final ActionStartupInfo actionStartupInfo = validateAndReadActionStartupInfo(xpath, node);

            if (actionStartupInfo != null) {
                tmpActionStartupInfoList.put(actionStartupInfo.getUniqueIdentifier(), actionStartupInfo);
            }
        }

        return tmpActionStartupInfoList;
    }

    /**
     * Validates and makes sure ActionStartupInfo is valid, reads required
     * information and returns it.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for action startup information
     * @return Reference to ActionStartupInfo or null as failure
     */
    private ActionStartupInfo validateAndReadActionStartupInfo(
            final XPath xpath,
            final Node node) {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }

        ActionStartupInfo result = null;

        do {
            final NamedNodeMap attributes = node.getAttributes();
            final ActionStartupInfo actionStartupInfo =
                    dependecyInjector.getInstance(ActionStartupInfo.class);

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

            actionStartupInfo.setUniqueIdentifier(attrValue);
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

            actionStartupInfo.setLibrary(attrValue);
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

            actionStartupInfo.setPackageName(attrValue);
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

            actionStartupInfo.setClassName(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.CONFIGURATION_FILE_FULL_PATH_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                actionStartupInfo.setConfigurationFileFullPath("");
            } else {
                actionStartupInfo.setConfigurationFileFullPath(attrValue);
            }
            /****************************************************/

            result = actionStartupInfo;
        } while (false);

        return result;
    }

    /**
     * Reads all action manager startup information from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @param actionStartupInfoList Reference to list of registered action startup
     * information
     * @return Returns the list of read action manager startup information
     * @throws XPathExpressionException Throws in case exception occurs
     */
    private Map<String, ActionManagerStartupInfo> readAllActionManagerStartupInfo(
            final Document document,
            final XPath xpath,
            final Map<String, ActionStartupInfo> actionStartupInfoList)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (actionStartupInfoList == null) {
            throw new IllegalArgumentException("actionStartupInfoList");
        }

        final Map<String, ActionManagerStartupInfo> tmpActionManagerStartupInfoList =
                new HashMap<String, ActionManagerStartupInfo>();
        final Object result =
                xpath.evaluate("configuration//action_managers/action_manager",
                document,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            final Node node = nodes.item(idx);
            final ActionManagerStartupInfo actionManagerStartupInfo = validateAndReadActionManagerStartupInfo(xpath, node);

            if (actionManagerStartupInfo != null) {
                validateAndReadAllListedAction(
                        xpath,
                        node,
                        actionManagerStartupInfo,
                        actionStartupInfoList);

                tmpActionManagerStartupInfoList.put(actionManagerStartupInfo.getUniqueIdentifier(), actionManagerStartupInfo);
            }
        }

        return tmpActionManagerStartupInfoList;
    }

    /**
     * Validates and makes sure ActionManagerStartupInfo is valid, reads required
     * information and returns it.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for action manager startup information
     * @return Reference to ActionManagerStartupInfo or null as failure
     */
    private ActionManagerStartupInfo validateAndReadActionManagerStartupInfo(
            final XPath xpath,
            final Node node) {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }

        ActionManagerStartupInfo result = null;

        do {
            final NamedNodeMap attributes = node.getAttributes();
            final ActionManagerStartupInfo actionManagerStartupInfo =
                    dependecyInjector.getInstance(ActionManagerStartupInfo.class);

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

            actionManagerStartupInfo.setUniqueIdentifier(attrValue);
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

            actionManagerStartupInfo.setLibrary(attrValue);
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

            actionManagerStartupInfo.setPackageName(attrValue);
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

            actionManagerStartupInfo.setClassName(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.CONFIGURATION_FILE_FULL_PATH_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                actionManagerStartupInfo.setConfigurationFileFullPath("");
            } else {
                actionManagerStartupInfo.setConfigurationFileFullPath(attrValue);
            }
            /****************************************************/

            result = actionManagerStartupInfo;
        } while (false);

        return result;
    }

    /**
     * Validates and reads all actions listed under a action manager.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for action startup information
     * @param actionManagerStartupInfo Reference to ActionManagerStartupInfo to
     * add action startup information to
     * @param actionStartupInfoList Reference to list of registered action startup
     * information
     * @throws XPathExpressionException Throws in case exception occurs
     */
    private void validateAndReadAllListedAction(
            final XPath xpath,
            final Node node,
            final ActionManagerStartupInfo actionManagerStartupInfo,
            final Map<String, ActionStartupInfo> actionStartupInfoList)
            throws XPathExpressionException {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }

        if (actionManagerStartupInfo == null) {
            throw new IllegalArgumentException("actionManagerStartupInfo");
        }

        if (actionStartupInfoList == null) {
            throw new IllegalArgumentException("actionStartupInfoList");
        }

        final Object result =
                xpath.evaluate("action_list/action/@unique_identifier",
                node,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            String nodeValue = nodes.item(idx).getNodeValue();

            nodeValue = nodeValue.trim();

            if (!nodeValue.isEmpty()
                    && actionStartupInfoList.containsKey(nodeValue)) {
                actionManagerStartupInfo.addActionStartupInfo(actionStartupInfoList.get(nodeValue));
            }
        }
    }

    /**
     * Reads all daemon startup information from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @param actionManagerStartupInfoList Reference to list of registered action
     * manager startup information
     * @return Returns the list of read daemon startup information
     * @throws XPathExpressionException Throws in case exception occurs
     */
    private Map<String, DaemonStartupInfo> readAllDaemonStartupInfo(
            final Document document,
            final XPath xpath,
            final Map<String, ActionManagerStartupInfo> actionManagerStartupInfoList)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (actionManagerStartupInfoList == null) {
            throw new IllegalArgumentException("actionManagerStartupInfoList");
        }

        final Map<String, DaemonStartupInfo> tmpDaemonStartupInfoList =
                new HashMap<String, DaemonStartupInfo>();
        final Object result =
                xpath.evaluate("configuration//daemons/daemon",
                document,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            final Node node = nodes.item(idx);
            final DaemonStartupInfo daemonStartupInfo = validateAndReadDaemonStartupInfo(xpath, node);

            if (daemonStartupInfo != null) {
                validateAndReadAllListedActionManager(
                        xpath,
                        node,
                        daemonStartupInfo,
                        actionManagerStartupInfoList);

                tmpDaemonStartupInfoList.put(daemonStartupInfo.getUniqueIdentifier(), daemonStartupInfo);
            }
        }

        return tmpDaemonStartupInfoList;
    }

    /**
     * Validates and makes sure DaemonStartupInfo is valid, reads required
     * information and returns it.
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
            final NamedNodeMap attributes = node.getAttributes();
            final DaemonStartupInfo DaemonStartupInfo =
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

            DaemonStartupInfo.setUniqueIdentifier(attrValue);
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

            DaemonStartupInfo.setLibrary(attrValue);
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

            DaemonStartupInfo.setPackageName(attrValue);
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

            DaemonStartupInfo.setClassName(attrValue);
            /****************************************************/

            /****************************************************/
            attr = attributes.getNamedItem(BasicConfigurationParser.CONFIGURATION_FILE_FULL_PATH_TAG);

            if (attr == null) {
                break;
            }

            attrValue = attr.getNodeValue();

            if (attrValue == null) {
                DaemonStartupInfo.setConfigurationFileFullPath("");
            } else {
                DaemonStartupInfo.setConfigurationFileFullPath(attrValue);
            }
            /****************************************************/

            result = DaemonStartupInfo;
        } while (false);

        return result;
    }

    /**
     * Validates and reads all actions manager listed under a daemon.
     *
     * @param xpath Reference to XPath object
     * @param node node in XML document to search for action startup information
     * @param daemonStartupInfo Reference to DaemonStartupInfo to
     * add action manager startup information to
     * @param actionManagerStartupInfoList Reference to list of registered action
     * manger startup information
     * @throws XPathExpressionException Throws in case exception occurs
     */
    private void validateAndReadAllListedActionManager(
            final XPath xpath,
            final Node node,
            final DaemonStartupInfo daemonStartupInfo,
            final Map<String, ActionManagerStartupInfo> actionManagerStartupInfoList)
            throws XPathExpressionException {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (node == null) {
            throw new IllegalArgumentException("node");
        }

        if (daemonStartupInfo == null) {
            throw new IllegalArgumentException("daemonStartupInfo");
        }

        if (actionManagerStartupInfoList == null) {
            throw new IllegalArgumentException("actionManagerStartupInfoList");
        }

        final Object result =
                xpath.evaluate("action_manager_list/action_manager/@unique_identifier",
                node,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            String nodeValue = nodes.item(idx).getNodeValue();

            nodeValue = nodeValue.trim();

            if (!nodeValue.isEmpty()
                    && actionManagerStartupInfoList.containsKey(nodeValue)) {
                daemonStartupInfo.addActionManagerStartupInfo(actionManagerStartupInfoList.get(nodeValue));
            }
        }
    }

    /**
     * Reads all startup daemons from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to XPath object
     * @param daemonStartupInfoList Reference to list of registered daemon
     * startup information
     * @throws XPathExpressionException Throws in case exception occurs
     * @return Returns the list of read startup daemon
     */
    private Map<String, DaemonStartupInfo> readStartupDaemonList(
            final Document document,
            final XPath xpath,
            final Map<String, DaemonStartupInfo> daemonStartupInfoList)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        if (daemonStartupInfoList == null) {
            throw new IllegalArgumentException("daemonStartupInfoList");
        }

        final Map<String, DaemonStartupInfo> tmpDaemonStartupInfoList =
                new HashMap<String, DaemonStartupInfo>();
        final Object result =
                xpath.evaluate("configuration/startup//daemon_list/daemon/@unique_identifier",
                document,
                XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            String nodeValue = nodes.item(idx).getNodeValue();

            nodeValue = nodeValue.trim();

            if (!nodeValue.isEmpty()
                    && daemonStartupInfoList.containsKey(nodeValue)) {
                final DaemonStartupInfo daemonStartupInfo = daemonStartupInfoList.get(nodeValue);

                tmpDaemonStartupInfoList.put(daemonStartupInfo.getUniqueIdentifier(), daemonStartupInfo);
            }
        }

        return tmpDaemonStartupInfoList;
    }
}
