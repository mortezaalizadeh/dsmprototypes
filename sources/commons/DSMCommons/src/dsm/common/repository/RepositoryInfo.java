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
     * Repository name
     */
    protected String name = "";

    /**
     * Repository unique identifier
     */
    protected String uniqueIdentifier = "";

    /**
     * Daemon list
     */
    private LinkedList<DaemonInfo> daemonList = null;

    /**
     * RepositoryInfo constructor.
     */
    public RepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository Info");
        
        this.name = "";
        this.uniqueIdentifier = "";
        this.daemonList = null;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set repository name.
     * 
     * @param szName New repository name to set
     */
    public void setName(String szName) {
        this.name = szName;
    }

    /**
     * Returns repository unique identifier.
     * 
     * @return Repository unique identifier
     */
    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set repository unique identifier.
     * 
     * @param szUniqueIdentifier New repository unique identifier to set
     */
    public void setUniqueIdentifier(String szUniqueIdentifier) {
        this.uniqueIdentifier = szUniqueIdentifier;
    }

    /**
     * Adds new daemon to list of daemons.
     * 
     * @param daemonInfo New daemon to add
     */
    public void addDaemon(DaemonInfo daemonInfo) {
        if(this.daemonList == null)
            this.daemonList = new LinkedList<DaemonInfo>();
        
        this.daemonList.add(daemonInfo);
    }
}
