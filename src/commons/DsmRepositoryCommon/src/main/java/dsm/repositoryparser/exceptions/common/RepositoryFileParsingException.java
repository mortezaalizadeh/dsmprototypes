/**
 * @author Morteza Alizadeh
 */
package dsm.repositoryparser.exceptions.common;

import dsm.common.exception.DsmException;

/**
 * RepositoryFileParsingException class defines exception will be thrown on
 * repository file parsing failure.
 *
 * @version 0.1, May 14, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryFileParsingException extends DsmException {

    /**
     * RepositoryFileParsingException constructor.
     */
    public RepositoryFileParsingException() {
        super();
    }

    /**
     * RepositoryFileParsingException constructor.
     *
     * @param message the detail message
     */
    public RepositoryFileParsingException(final String message) {
        super(message);
    }

    /**
     * RepositoryFileParsingException constructor.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public RepositoryFileParsingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * RepositoryFileParsingException constructor.
     *
     * @param cause the cause
     */
    public RepositoryFileParsingException(final Throwable cause) {
        super(cause);
    }
}
