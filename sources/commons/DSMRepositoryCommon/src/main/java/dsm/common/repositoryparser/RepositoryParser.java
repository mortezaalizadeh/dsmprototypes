/**
 * @author Morteza Alizadeh
 */
package dsm.common.repositoryparser;

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
     * @param szRepositoryFilePath Repository file path
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    void loadRepositoryFromFile(String szRepositoryFilePath,
                                boolean bLoadStartupRepositories,
                                boolean bLoadNoneStartupRepositories) throws Exception;

    /**
     * Loads repository information from passed string content.
     * 
     * @param szStringContent String content
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    void loadRepository(String szStringContent,
                        boolean bLoadStartupRepositories,
                        boolean bLoadNoneStartupRepositories) throws Exception;

    /**
     * Loads repository information from passed string content.
     * 
     * @param inputSource Input source contains XML message
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    void loadRepository(InputSource inputSource,
                        boolean bLoadStartupRepositories,
                        boolean bLoadNoneStartupRepositories) throws Exception;
}
