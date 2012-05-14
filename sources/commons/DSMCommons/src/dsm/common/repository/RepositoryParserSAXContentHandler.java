/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

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
    
    private int repositoryTagHitCount;
    private int repositoryTypeTagHitCount;
    private int repositoryNameTagHitCount;
    private int repositoryUniqueIdentifierTagHitCount;
    private int repositoryLinkTagHitCount;

    private Locator saxLocator = null;
    
    /**
     * RepositoryParserSAXContentHandler constructor
     * 
     * @param refRepositoryParser reference to repository parser object
     */
    public RepositoryParserSAXContentHandler(RepositoryParser refRepositoryParser) {
        if (refRepositoryParser == null)
            throw new NullPointerException("Error: Passed refRepositoryParser reference is null.");

        repositoryParser = refRepositoryParser;
        cachedRepositoryInfo = null;

        repositoryTagHitCount = 0;
        repositoryTypeTagHitCount = 0;
        repositoryNameTagHitCount = 0;
        repositoryUniqueIdentifierTagHitCount = 0;
        repositoryLinkTagHitCount = 0;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        saxLocator = locator;
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
            repositoryTagHitCount++;
            
            if (repositoryTagHitCount == 1) {
                cachedRepositoryInfo = new RepositoryInfo();
            } else {
                throw new SAXException("Error: Repository XML file contains wrong tags.");
            }
        } else if (qName.equalsIgnoreCase("type")) {
            repositoryTypeTagHitCount++;
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
            repositoryTagHitCount--;

            if (repositoryTagHitCount == 0) {
                if (repositoryParser != null)
                    repositoryParser.addParsedRepositoryInfo(cachedRepositoryInfo);

                cachedRepositoryInfo = null;
            } else {
                throw new SAXException("Error: Repository XML file contains wrong tags.");
            }

        } else if (qName.equalsIgnoreCase("type")) {
            repositoryTypeTagHitCount--;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (ch == null)
            throw new NullPointerException("Error: Passed ch reference is null.");

        String value = new String(ch, start, length);

        value = value.trim();

        if (cachedRepositoryInfo != null) {
            if (repositoryTypeTagHitCount == 1) {
                if (value.equalsIgnoreCase("Daemon")) {
                    cachedRepositoryInfo.setRepositoryType(RepositoryType.Daemon);
                } else if (value.equalsIgnoreCase("ActionsManager")) {
                    cachedRepositoryInfo.setRepositoryType(RepositoryType.ActionsManager);
                } else if (value.equalsIgnoreCase("Actions")) {
                    cachedRepositoryInfo.setRepositoryType(RepositoryType.Actions);
                } else {
                    throw new SAXException(String.format("Error: Repository %s type is not supported", value));
                }
            }
        }
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
