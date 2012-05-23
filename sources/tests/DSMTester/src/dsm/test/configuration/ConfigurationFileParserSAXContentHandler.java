/**
 * @author Morteza Alizadeh
 */
package dsm.test.configuration;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.repository.RepositoryInfo;
import dsm.common.repositoryparser.RepositoryParserStartupInfo;
import dsm.common.repositoryparser.exceptions.RepositoryFileParsingException;
import dsm.daemon.common.DaemonStartupInfo;
import dsm.test.exception.ConfigurationFileParsingException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * RepositoryParserSAXContentHandler class implements required method to handle
 * read XML file attributes and elements.
 * 
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public class ConfigurationFileParserSAXContentHandler implements ContentHandler {

    /**
     * Reference to DSM tester configuration reader object
     */
    private DSMTesterConfigurationReader dsmTesterConfigurationReader;

    /**
     * Cached repository info
     */
    private RepositoryInfo cachedRepositoryInfo;
    
    /**
     * XML Repository parsing depth
     */
    private int parsedDepth;

    /**
     * SAX locator
     */
    private Locator saxLocator = null;
    
    /**
     * RepositoryParserSAXContentHandler constructor
     * 
     * @param refDSMTesterConfigurationReader Reference to DSM tester configuration reader object
     */
    public ConfigurationFileParserSAXContentHandler(DSMTesterConfigurationReader refDSMTesterConfigurationReader) {
        if (refDSMTesterConfigurationReader == null)
            throw new NullPointerException("Error: Passed refDSMTesterConfigurationReader reference is null.");

        this.dsmTesterConfigurationReader = refDSMTesterConfigurationReader;
        this.cachedRepositoryInfo = null;

        this.parsedDepth = 0;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        this.saxLocator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (uri == null)
            throw new NullPointerException("Error: Passed uri reference is null.");

        if (localName == null)
            throw new NullPointerException("Error: Passed localName reference is null.");

        if (qName == null)
            throw new NullPointerException("Error: Passed qName reference is null.");

        qName = qName.trim();

        if (qName.equalsIgnoreCase("configuration")) {
            if (this.parsedDepth != 0)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;
        } else if (qName.equalsIgnoreCase("repository_files")) {
            if (this.parsedDepth != 1)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;
        } else if (qName.equalsIgnoreCase("repository_file")) {
            if (this.parsedDepth != 2)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            String value;
            
            if ((value = atts.getValue("repository_file_full_path")) != null) {
                value = value.trim();

                if (!value.isEmpty())
                    this.dsmTesterConfigurationReader.addRepositoryFileFullPath(value);
            }
        } else if (qName.equalsIgnoreCase("repository_parser")) {
            if (this.parsedDepth != 1)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            RepositoryParserStartupInfo repositoryParserStartupInfo = new RepositoryParserStartupInfo();
            
            String value;
            
            if ((value = atts.getValue("name")) == null) {
                repositoryParserStartupInfo.setName("");
            } else {
                repositoryParserStartupInfo.setName(value.trim());
            }
            
            if ((value = atts.getValue("library")) == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setLibrary(value.trim());
            }

            if ((value = atts.getValue("package_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setPackageName(value.trim());
            }

             if ((value = atts.getValue("class_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setClassName(value.trim());
            }
             
            this.dsmTesterConfigurationReader.setRepositoryParserStartupInfo(repositoryParserStartupInfo);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (uri == null)
            throw new NullPointerException("Error: Passed uri reference is null.");
            
        if (localName == null)
            throw new NullPointerException("Error: Passed localName reference is null.");
        
        if (qName == null)
            throw new NullPointerException("Error: Passed qName reference is null.");
        
        qName = qName.trim();
        
        if (qName.equalsIgnoreCase("configuration")) {
            if (this.parsedDepth != 1)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        } else if (qName.equalsIgnoreCase("repository_files")) {
            if (this.parsedDepth != 2)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        } else if (qName.equalsIgnoreCase("repository_file")) {
            if (this.parsedDepth != 3)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        } else if (qName.equalsIgnoreCase("repository_parser")) {
            if (this.parsedDepth != 2)
                throw new ConfigurationFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }
}
