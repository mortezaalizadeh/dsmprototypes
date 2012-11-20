/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repositoryparser;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * BasicRepositoryParserSAXErrorHandler class implements required method to
 * handle errors occur during parsing repository XML file.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class BasicRepositoryParserSAXErrorHandler implements ErrorHandler {

    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        throw exception;
    }

    @Override
    public void error(final SAXParseException exception) throws SAXException {
        throw exception;
    }

    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        throw exception;
    }
}
