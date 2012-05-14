/**
 * @author Morteza Alizadeh
 */
package dsm.common;

/**
 * DSMException class defines general DSM exception.
 * 
 * @version 0.1, May 14, 2012
 * @author Morteza Alizadeh
 */
public class DSMException extends RuntimeException {

    /**
     * DSMException constructor
     */
    public DSMException() {
        super();
    }

    /**
     * DSMException constructor
     * 
     * @param message the detail message
     */
    public DSMException(String message) {
        super(message);
    }

    /**
     * DSMException constructor
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public DSMException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * DSMException constructor
     * 
     * @param cause the cause
     */
    public DSMException(Throwable cause) {
        super(cause);
    }
}
