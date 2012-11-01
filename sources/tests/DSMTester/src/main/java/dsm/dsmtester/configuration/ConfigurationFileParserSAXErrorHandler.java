/**
 * @author Morteza Alizadeh
 */
package dsm.dsmtester.configuration;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * RepositoryParserSAXErrorHandler class implements required method to handle
 * errors occur during parsing repository XML file.
 *
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public final class ConfigurationFileParserSAXErrorHandler implements ErrorHandler {

    /**
     * Reference to DSM tester configuration reader object.
     */
    private transient ConfigurationReader dsmTesterConfigurationReader = null;
    
    /**
     * RepositoryParserSAXErrorHandler constructor.
     *
     * @param dsmTesterConfigurationReader Reference to DSM tester configuration reader object.
     */
    public ConfigurationFileParserSAXErrorHandler(final ConfigurationReader dsmTesterConfigurationReader) {
        if (dsmTesterConfigurationReader == null) {
            throw new IllegalArgumentException("dsmTesterConfigurationReader");
        }

        this.dsmTesterConfigurationReader = dsmTesterConfigurationReader;
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
