/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repositoryparser;

import dsm.repository.common.RepositoryInfo;

/**
 * RepositoryInfoParserEvent class contains event information when parsing
 * repositories.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryInfoParserEvent extends Object {

    /**
     * Reference to repositoryInfo.
     */
    private final transient RepositoryInfo repositoryInfo;

    /**
     * RepositoryInfoParserEvent constructor.
     *
     * @param initialRepositoryInfo initial reference to repositoryInfo
     */
    public RepositoryInfoParserEvent(final RepositoryInfo initialRepositoryInfo) {
        super();

        this.repositoryInfo = initialRepositoryInfo;
    }

    /**
     * Returns reference of repositoryInfo.
     *
     * @return Returns reference of repositoryInfo
     */
    public RepositoryInfo getRepositoryInfo() {
        return this.repositoryInfo;
    }
}
