/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;

/**
* Repository class is an entity class represent a repository of any defined
* type.
 * 
* @version 0.1, April 15, 2012
  * @author Morteza Alizadeh
 */
public class Repository extends DSMManifest {

    /**
     * Repository type.
     */
    protected RepositoryType repositoryType;
    
    /**
     * Repository constructor.
     * 
     * @param nRepositoryType Repository type
     */
    public Repository(RepositoryType nRepositoryType) {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository");
        
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
     * @param nRepositoryType 
     */
    public void setRepositoryType(RepositoryType nRepositoryType) {
        repositoryType = nRepositoryType;
    }
}
