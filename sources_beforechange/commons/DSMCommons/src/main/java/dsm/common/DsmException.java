/**
 * @author Morteza Alizadeh
 */
package dsm.common;

/**
 * DsmException class defines general Dsm exception.
 *
 * @version 0.1, May 14, 2012
 * @author Morteza Alizadeh
 */
public class DsmException extends RuntimeException {

    /**
     * DsmException constructor.
     */
    public DsmException() {
        super();
    }

    /**
     * DsmException constructor.
     *
     * @param message the detail message
     */
    public DsmException(final String message) {
        super(message);
    }

    /**
     * DsmException constructor.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public DsmException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * DsmException constructor.
     *
     * @param cause the cause
     */
    public DsmException(final Throwable cause) {
        super(cause);
    }
}
