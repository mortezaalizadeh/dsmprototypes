/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.daemon.DaemonInfo;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * RepositoryParserSAXContentHandler class implements required method to handle
 * read XML file attributes and elements.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryParserSAXContentHandler implements ContentHandler {

    /**
     * Reference to repository parser object
     */
    private RepositoryParser repositoryParser;

    /**
     * Cached repository info
     */
    private RepositoryInfo cachedRepositoryInfo;
    
    /**
     * XML Repository parsing depth
     */
    private int parsedDepth;

    private Locator saxLocator = null;
    
    /**
     * RepositoryParserSAXContentHandler constructor
     * 
     * @param refRepositoryParser reference to repository parser object
     */
    public RepositoryParserSAXContentHandler(RepositoryParser refRepositoryParser) {
        if (refRepositoryParser == null)
            throw new NullPointerException("Error: Passed refRepositoryParser reference is null.");

        this.repositoryParser = refRepositoryParser;
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

        if (qName.equalsIgnoreCase("repository")) {
            if (this.parsedDepth != 0)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.cachedRepositoryInfo = new RepositoryInfo();

            String value;

            if ((value = atts.getValue("name")) == null)
                throw new RepositoryFileParsingException("Error: \"name\" tag is not defined for repository.");
            else
                this.cachedRepositoryInfo.setName(value.trim());

            if ((value = atts.getValue("unique_identifier")) == null)
                throw new RepositoryFileParsingException("Error: \"unique_identifier\" tag is not defined for repository.");
            else
                this.cachedRepositoryInfo.setUniqueIdentifier(value.trim());

            this.parsedDepth++;
        } else if (qName.equalsIgnoreCase("dameon")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            DaemonInfo daemonInfo = new DaemonInfo();
            
            String value;
            
            if ((value = atts.getValue("name")) == null) {
                throw new RepositoryFileParsingException("Error: Name tag is not defined for daemon.");
            } else {
                daemonInfo.setName(value.trim());
            }

            if ((value = atts.getValue("unique_identifier")) == null) {
                throw new RepositoryFileParsingException("Error: \"unique_identifier\" tag is not defined for daemon.");
            } else {
                daemonInfo.setUniqueIdentifier(value.trim());
            }

            if ((value = atts.getValue("library")) == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for daemon.");
            } else {
                daemonInfo.setLibrary(value.trim());
            }

            if ((value = atts.getValue("package_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for daemon.");
            } else {
                daemonInfo.setPackageName(value.trim());
            }

             if ((value = atts.getValue("class_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for daemon.");
            } else {
                daemonInfo.setClassName(value.trim());
            }

            if ((value = atts.getValue("configuration_file_full_path")) == null) {
                throw new RepositoryFileParsingException("Error: \"configuration_file_full_path\" tag is not defined for daemon.");
            } else {
                daemonInfo.setConfigurationFileFullPath(value.trim());
            }
            
            this.cachedRepositoryInfo.addDaemon(daemonInfo);
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
        
        if (qName.equalsIgnoreCase("repository")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;

            if (this.repositoryParser != null)
                this.repositoryParser.addParsedRepositoryInfo(this.cachedRepositoryInfo);

            this.cachedRepositoryInfo = null;
        } else if (qName.equalsIgnoreCase("dameon")) {
            if (this.parsedDepth != 2)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

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
