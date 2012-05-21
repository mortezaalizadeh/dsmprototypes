/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DSMManifest;
import dsm.daemon.common.DaemonStartupInfo;
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
    private LinkedList<DaemonStartupInfo> daemonList = null;

    /**
     * Action manager list
     */
    private LinkedList<ActionManagerStartupInfo> actionManagerList = null;

    /**
     * Action list
     */
    private LinkedList<ActionStartupInfo> actionList = null;

    /**
     * RepositoryInfo constructor.
     */
    public RepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository Info");
        
        this.name = "";
        this.uniqueIdentifier = "";
        this.daemonList = null;
        this.actionManagerList = null;
        this.actionList = null;
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
    public void addDaemon(DaemonStartupInfo daemonInfo) {
        if(this.daemonList == null)
            this.daemonList = new LinkedList<DaemonStartupInfo>();
        
        this.daemonList.add(daemonInfo);
    }

    /**
     * Adds new action manager to list of daemons.
     * 
     * @param actionManagerInfo New action manager to add
     */
    public void addActionManager(ActionManagerStartupInfo actionManagerInfo) {
        if(this.actionManagerList == null)
            this.actionManagerList = new LinkedList<ActionManagerStartupInfo>();
        
        this.actionManagerList.add(actionManagerInfo);
    }

    /**
     * Adds new action to list of daemons.
     * 
     * @param actionManagerInfo New action manager to add
     */
    public void addAction(ActionStartupInfo actionInfo) {
        if(this.actionList == null)
            this.actionList = new LinkedList<ActionStartupInfo>();
        
        this.actionList.add(actionInfo);
    }
}