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

    private Locator locator = null;
    
    /**
     * RepositoryParserSAXContentHandler constructor
     */
    public RepositoryParserSAXContentHandler() {
    }
    
    @Override
    public void setDocumentLocator(Locator lctr) {
        locator = lctr;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String string, String string1) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String string) throws SAXException {
    }

    @Override
    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
    }

    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] chars, int i, int i1) throws SAXException {
    }

    @Override
    public void processingInstruction(String string, String string1) throws SAXException {
    }

    @Override
    public void skippedEntity(String string) throws SAXException {
    }
}
