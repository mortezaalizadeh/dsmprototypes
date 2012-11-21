/**
 * @author Morteza Alizadeh
 */
package dsm.common.configuration;

import dsm.common.DsmException;

/**
 * ConfigurationParserException class defines exception occurs during reading
 * configurations.
 *
 * @version 0.1, November 21, 2012
 * @author Morteza Alizadeh
 */
public class ConfigurationParserException extends DsmException {

    /**
     * ConfigurationParserException constructor.
     */
    public ConfigurationParserException() {
        super();
    }

    /**
     * ConfigurationParserException constructor.
     *
     * @param message the detail message
     */
    public ConfigurationParserException(final String message) {
        super(message);
    }

    /**
     * ConfigurationParserException constructor.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public ConfigurationParserException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * ConfigurationParserException constructor.
     *
     * @param cause the cause
     */
    public ConfigurationParserException(final Throwable cause) {
        super(cause);
    }
}
