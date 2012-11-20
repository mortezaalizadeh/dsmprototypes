/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repositoryparser;

/**
 * RepositoryInfoParserListener interface defines all events may happen during
 * repository parsing process.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public interface RepositoryInfoParserListener {

    /**
     * Raised when new RepositoryInfo is parsed.
     * @param repositoryInfoParserEvent Reference to RepositoryInfoParserEvent
     */
    void addNewRepositoryInfoParsed(final RepositoryInfoParserEvent repositoryInfoParserEvent);
}
