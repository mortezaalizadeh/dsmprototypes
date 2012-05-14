/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;

/**
* RepositoryInfo class is an entity class represent a repository of any defined
* type.
 * 
* @version 0.1, April 15, 2012
  * @author Morteza Alizadeh
 */
public class RepositoryInfo extends DSMManifest {

    /**
     * Repository type
     */
    protected RepositoryType repositoryType;
    
    /**
     * Repository name
     */
    protected String repositoryName = "";

    /**
     * Repository unique identifier
     */
    protected String repositoryUniqueIdentifier = "";

    /**
     * Repository link
     */
    protected String repositoryLink = "";

    /**
     * RepositoryInfo constructor.
     */
    public RepositoryInfo() {
        this(RepositoryType.Unknown);
    }
    
    /**
     * RepositoryInfo constructor.
     * 
     * @param nRepositoryType Repository type
     */
    public RepositoryInfo(RepositoryType nRepositoryType) {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository Info");
        
        repositoryType = nRepositoryType;
    }

    /**
     * Returns repository type.
     * 
     * @return Repository type
     */
    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

    /**
     * Set repository type.
     * 
     * @param nRepositoryType New repository type to set
     */
    public void setRepositoryType(RepositoryType nRepositoryType) {
        repositoryType = nRepositoryType;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * Set repository name.
     * 
     * @param szRepositoryName New repository name to set
     */
    public void setRepositoryName(String szRepositoryName) {
        repositoryName = szRepositoryName;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getRepositoryUniqueIdentifier() {
        return repositoryUniqueIdentifier;
    }

    /**
     * Set repository unique identifier.
     * 
     * @param szRepositoryUniqueIdentifier New repository unique identifier to set
     */
    public void setRepositoryUniqueIdentifier(String szRepositoryUniqueIdentifier) {
        repositoryUniqueIdentifier = szRepositoryUniqueIdentifier;
    }

    /**
     * Returns repository link.
     * 
     * @return Repository link
     */
    public String getRepositoryLink() {
        return repositoryLink;
    }

    /**
     * Set repository link.
     * 
     * @param szRepositoryLink New repository link to set
     */
    public void setRepositoryLink(String szRepositoryLink) {
        repositoryLink = szRepositoryLink;
    }
}
