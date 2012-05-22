/**
 * @author Morteza Alizadeh
 */
package dsm.test.exception;

import dsm.common.DSMException;

/**
 * ConfigurationFileParsingException class defines exception will be thrown on
 * DSM tester configuration file parsing failure.
 * 
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public class ConfigurationFileParsingException extends DSMException {
    
    /**
     * ConfigurationFileParsingException constructor
     */
    public ConfigurationFileParsingException() {
        super();
    }

    /**
     * ConfigurationFileParsingException constructor
     * 
     * @param message the detail message
     */
    public ConfigurationFileParsingException(String message) {
        super(message);
    }

    /**
     * ConfigurationFileParsingException constructor
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public ConfigurationFileParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * ConfigurationFileParsingException constructor
     * 
     * @param cause the cause
     */
    public ConfigurationFileParsingException(Throwable cause) {
        super(cause);
    }
}
