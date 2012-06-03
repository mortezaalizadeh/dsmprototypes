/**
 * @author Morteza Alizadeh
 */
package dsm.test.configuration;

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
public class ConfigurationFileParserSAXErrorHandler implements ErrorHandler {

    /**
     * Reference to DSM tester configuration reader object
     */
    private ConfigurationReader dsmTesterConfigurationReader;
    
    /**
     * RepositoryParserSAXErrorHandler constructor
     * 
     * @param refDSMTesterConfigurationReader Reference to DSM tester configuration reader object
     */
    public ConfigurationFileParserSAXErrorHandler(ConfigurationReader refDSMTesterConfigurationReader) {
        if (refDSMTesterConfigurationReader == null)
            throw new NullPointerException("Error: Passed refDSMTesterConfigurationReader reference is null.");

        this.dsmTesterConfigurationReader = refDSMTesterConfigurationReader;
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
