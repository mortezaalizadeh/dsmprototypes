/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repository.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;
import dsm.repository.common.RepositoryInfo;
import java.util.LinkedList;
import java.util.List;

/**
 * BasicRepositoryInfo is a basic implementation for RepositoryInfo.
 *
 * @version 0.1, November 17, 2012
 * @author Morteza Alizadeh
 */
public class BasicRepositoryInfo extends DsmManifest implements RepositoryInfo {

    /**
     * Repository name.
     */
    private String name = "";

    /**
     * Repository unique identifier.
     */
    private String uniqueIdentifier = "";

    /**
     * Repository include in startup flag.
     */
    private boolean includeInStartup = false;

    /**
     * Daemon list.
     */
    private List<DaemonStartupInfo> daemonList;

    /**
     * Action manager list.
     */
    private List<ActionManagerStartupInfo> actionManagerList;

    /**
     * Action list.
     */
    private List<ActionStartupInfo> actionList;

    /**
     * BasicRepositoryInfo constructor.
     */
    public BasicRepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Basic Repository Info");

        daemonList = new LinkedList<DaemonStartupInfo>();
        actionManagerList = new LinkedList<ActionManagerStartupInfo>();
        actionList = new LinkedList<ActionStartupInfo>();
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
     * @param newName New repository name to set
     */
    public void setName(final String newName) {
        this.name = newName;
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
     * @param newUniqueIdentifier New repository unique identifier to set
     */
    public void setUniqueIdentifier(final String newUniqueIdentifier) {
        this.uniqueIdentifier = newUniqueIdentifier;
    }

    /**
     * Returns repository include in startup flag.
     *
     * @return Repository include in startup flag
     */
    public boolean isIncludeInStartup() {
        return this.includeInStartup;
    }

    /**
     * Set repository include in startup flag.
     *
     * @param bIncludeInStartup New repository include in startup flag to set
     */
    public void setIncludeInStartup(final boolean bIncludeInStartup) {
        this.includeInStartup = bIncludeInStartup;
    }

    /**
     * Adds new daemon to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup info
     */
    public void addDaemon(final DaemonStartupInfo daemonStartupInfo) {
        this.daemonList.add(daemonStartupInfo);
    }

    /**
     * Adds new action manager to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup info
     */
    public void addActionManager(final ActionManagerStartupInfo actionManagerStartupInfo) {
        this.actionManagerList.add(actionManagerStartupInfo);
    }

    /**
     * Adds new action to list of daemons.
     *
     * @param actionStartupInfo Action startup info
     */
    public void addAction(final ActionStartupInfo actionStartupInfo) {
        this.actionList.add(actionStartupInfo);
    }

    /**
     * Returns daemon list.
     *
     * @return Returns daemon list
     */
    public List<DaemonStartupInfo> getDaemonList() {
        return this.daemonList;
    }

    /**
     * Set daemon list.
     *
     * @param newDaemonList New daemon list
     */
    public void setDaemonList(final List<DaemonStartupInfo> newDaemonList) {
        this.daemonList = newDaemonList;
    }

    /**
     * Returns action manager list.
     *
     * @return Returns action manager list
     */
    public List<ActionManagerStartupInfo> getActionManagerList() {
        return this.actionManagerList;
    }

    /**
     * Set action manager list.
     *
     * @param newActionManagerList New action manager list
     */
    public void setActionManagerList(final List<ActionManagerStartupInfo> newActionManagerList) {
        this.actionManagerList = newActionManagerList;
    }

    /**
     * Returns action list.
     *
     * @return Returns action list
     */
    public List<ActionStartupInfo> getActionList() {
        return this.actionList;
    }

    /**
     * Set action list.
     *
     * @param newActionList New action list
     */
    public void setActionList(final List<ActionStartupInfo> newActionList) {
        this.actionList = newActionList;
    }
}
