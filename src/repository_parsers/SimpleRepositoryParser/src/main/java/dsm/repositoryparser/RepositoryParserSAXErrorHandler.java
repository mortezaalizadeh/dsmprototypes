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
public final class RepositoryParserSAXErrorHandler implements ErrorHandler {

    /**
     * Reference to simple repository parser object.
     */
    private transient SimpleRepositoryParser simpleRepositoryParser;

    /**
     * RepositoryParserSAXErrorHandler constructor.
     *
     * @param repositoryParser Reference to simple repository parser object
     */
    public RepositoryParserSAXErrorHandler(final SimpleRepositoryParser repositoryParser) {
        if (repositoryParser == null) {
            throw new IllegalArgumentException("repositoryParser");
        }

        this.simpleRepositoryParser = repositoryParser;
    }

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
