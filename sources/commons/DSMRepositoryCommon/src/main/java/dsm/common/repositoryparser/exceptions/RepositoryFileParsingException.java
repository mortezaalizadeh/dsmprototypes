/**
 * @author Morteza Alizadeh
 */
package dsm.common.repositoryparser.exceptions;

import dsm.common.DSMException;

/**
 * RepositoryFileParsingException class defines exception will be thrown on
 * repository file parsing failure.
 * 
 * @version 0.1, May 14, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryFileParsingException extends DSMException {
    
    /**
     * RepositoryFileParsingException constructor
     */
    public RepositoryFileParsingException() {
        super();
    }

    /**
     * RepositoryFileParsingException constructor
     * 
     * @param message the detail message
     */
    public RepositoryFileParsingException(String message) {
        super(message);
    }

    /**
     * RepositoryFileParsingException constructor
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public RepositoryFileParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * RepositoryFileParsingException constructor
     * 
     * @param cause the cause
     */
    public RepositoryFileParsingException(Throwable cause) {
        super(cause);
    }
}
