/**
 * @author Morteza Alizadeh
 */
package dsm.common.repositoryparser;

import dsm.common.repositoryparser.exceptions.RepositoryFileParsingException;
import org.xml.sax.InputSource;

/**
 * RepositoryParser interface defines general operations and attributes for a
 * repository parser.
 *
 * This interface must be implemented by all repository parser classes.
 *
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public interface RepositoryParser {

    /**
     * Loads repository information from an repository file.
     *
     * @param repositoryFilePath Repository file path
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     * @throws RepositoryFileParsingException In case an error occurs
     */
    void loadRepositoryFromFile(final String repositoryFilePath,
                                final boolean loadStartupRepositories,
                                final boolean loadNoneStartupRepositories) throws RepositoryFileParsingException;

    /**
     * Loads repository information from passed string content.
     *
     * @param content Content
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     * @throws RepositoryFileParsingException In case an error occurs
     */
    void loadRepository(final String content,
                        final boolean loadStartupRepositories,
                        final boolean loadNoneStartupRepositories) throws RepositoryFileParsingException;

    /**
     * Loads repository information from passed string content.
     *
     * @param inputSource Input source contains XML message
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     * @throws RepositoryFileParsingException In case an exception occurs
     */
    void loadRepository(final InputSource inputSource,
                        final boolean loadStartupRepositories,
                        final boolean loadNoneStartupRepositories) throws RepositoryFileParsingException;
}
