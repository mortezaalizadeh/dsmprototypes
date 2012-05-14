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
     * Reference to repository parser object
     */
    private RepositoryParser repositoryParser;
    
    /**
     * RepositoryParserSAXErrorHandler constructor
     * 
     * @param refRepositoryParser reference to repository parser object
     */
    public RepositoryParserSAXErrorHandler(RepositoryParser refRepositoryParser) {
        if (refRepositoryParser == null)
            throw new NullPointerException("Error: Passed refRepositoryParser reference is null.");
        
        repositoryParser = refRepositoryParser;
    }
    
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        throw(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        throw(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        throw(exception);
    }
}
