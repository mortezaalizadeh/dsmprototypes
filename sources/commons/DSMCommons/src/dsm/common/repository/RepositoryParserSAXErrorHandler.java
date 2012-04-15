/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * RepositoryParserSAXErrorHandler class implements required method to handle
 * errors occur during parsing repository XML file.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryParserSAXErrorHandler implements ErrorHandler {

    /**
     * RepositoryParserSAXErrorHandler constructor
     */
    public RepositoryParserSAXErrorHandler() {
    }
    
    @Override
    public void warning(SAXParseException saxpe) throws SAXException {
        throw(saxpe);
    }

    @Override
    public void error(SAXParseException saxpe) throws SAXException {
        throw(saxpe);
    }

    @Override
    public void fatalError(SAXParseException saxpe) throws SAXException {
        throw(saxpe);
    }
}
