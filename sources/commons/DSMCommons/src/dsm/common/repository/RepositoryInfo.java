/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;
import dsm.common.daemon.DaemonInfo;
import java.util.LinkedList;

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
    protected RepositoryType type;
    
    /**
     * Repository name
     */
    protected String name = "";

    /**
     * Repository unique identifier
     */
    protected String uniqueIdentifier = "";

    /**
     * Repository link
     */
    protected String link = "";

    /**
     * Parsed daemon info list
     */
    private LinkedList<DaemonInfo> parsedDaemonInfoList = null;

    /**
     * RepositoryInfo constructor.
     */
    public RepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository Info");
        
        type = RepositoryType.Unknown;
        name = "";
        uniqueIdentifier = "";
        link = "";
        parsedDaemonInfoList = null;
    }

    /**
     * Returns repository type.
     * 
     * @return Repository type
     */
    public RepositoryType getType() {
        return type;
    }

    /**
     * Set repository type.
     * 
     * @param nType New repository type to set
     */
    public void setType(RepositoryType nType) {
        type = nType;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getName() {
        return name;
    }

    /**
     * Set repository name.
     * 
     * @param szName New repository name to set
     */
    public void setName(String szName) {
        name = szName;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Set repository unique identifier.
     * 
     * @param szUniqueIdentifier New repository unique identifier to set
     */
    public void setUniqueIdentifier(String szUniqueIdentifier) {
        uniqueIdentifier = szUniqueIdentifier;
    }

    /**
     * Returns repository link.
     * 
     * @return Repository link
     */
    public String getLink() {
        return link;
    }

    /**
     * Set repository link.
     * 
     * @param szLink New repository link to set
     */
    public void setLink(String szLink) {
        link = szLink;
    }
}
