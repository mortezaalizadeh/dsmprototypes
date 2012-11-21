/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.common.configuration;

import dsm.common.DsmManifest;
import dsm.common.configuration.ConfigurationParser;
import dsm.common.configuration.ConfigurationParserException;
import java.io.IOException;
import java.util.HashSet;
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
            final Set<String> startupDaemonList = readStartupDaemon(document, xpath);
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
     * Reads all startup daemons from the document.
     *
     * @param document Reference to document object
     * @param xpath Reference to document object
     * @throws XPathExpressionException Throws in case exception occurs
     * @return Returns the list of read startup daemon unique identifiers
     */
    private Set<String> readStartupDaemon(final Document document, final XPath xpath)
            throws XPathExpressionException {
        if (document == null) {
            throw new IllegalArgumentException("document");
        }

        if (xpath == null) {
            throw new IllegalArgumentException("xpath");
        }

        /* Using HashSet to remove duplicate unique identifiers */
        final Set<String> startupDaemonList = new HashSet<String>();

        final XPathExpression xpathExpression = xpath.compile("configuration/startup//daemon_list/*/@unique_identifier");
        final Object result = xpathExpression.evaluate(document, XPathConstants.NODESET);
        final NodeList nodes = (NodeList) result;

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            String nodeValue = nodes.item(idx).getNodeValue();

            nodeValue = nodeValue.trim();

            if (!nodeValue.isEmpty()) {
                startupDaemonList.add(nodes.item(idx).getNodeValue());
            }
        }

        return startupDaemonList;
    }
}
