/**
 * @author Morteza Alizadeh
 */
package dsm.repositoryparser;

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
     * Reference to simple repository parser object
     */
    private SimpleRepositoryParser simpleRepositoryParser;
    
    /**
     * RepositoryParserSAXErrorHandler constructor
     * 
     * @param refRepositoryParser reference to simple repository parser object
     */
    public RepositoryParserSAXErrorHandler(SimpleRepositoryParser refSimpleRepositoryParser) {
        if (refSimpleRepositoryParser == null)
            throw new NullPointerException("Error: Passed refSimpleRepositoryParser reference is null.");

        this.simpleRepositoryParser = refSimpleRepositoryParser;
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
