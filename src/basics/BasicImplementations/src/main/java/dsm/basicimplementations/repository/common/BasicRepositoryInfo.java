/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repository.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;
import dsm.repository.common.RepositoryInfo;
import java.util.HashSet;
import java.util.Set;

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
    private Set<DaemonStartupInfo> daemonStartupInfoList = null;

    /**
     * Action list.
     */
    private Set<ActionStartupInfo> actionStartupInfoList = null;

    /**
     * Action manager list.
     */
    private Set<ActionManagerStartupInfo> actionManagerStartupInfoList = null;

    /**
     * BasicRepositoryInfo constructor.
     */
    public BasicRepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Basic Repository Information");
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
     * Adds new daemon startup information to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup information
     */
    public void addDaemonStartupInfo(final DaemonStartupInfo daemonStartupInfo) {
        this.getDaemonStartupInfoList().add(daemonStartupInfo);
    }

    /**
     * Adds new action startup information to list of daemons.
     *
     * @param actionStartupInfo Action startup information
     */
    public void addActionStartupInfo(final ActionStartupInfo actionStartupInfo) {
        this.getActionStartupInfoList().add(actionStartupInfo);
    }

    /**
     * Adds new action manager startup information to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup information
     */
    public void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo) {
        this.getActionManagerStartupInfoList().add(actionManagerStartupInfo);
    }

    /**
     * Returns the number of added daemon startup information.
     *
     * @return Returns the number of added daemon startup information
     */
    public Integer getDaemonStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.daemonStartupInfoList != null) {
            count = this.daemonStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the number of added action startup information.
     *
     * @return Returns the number of added action startup information
     */
    public Integer getActionStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionStartupInfoList != null) {
            count = this.actionStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the number of added action manager startup information.
     *
     * @return Returns the number of added action manager startup information
     */
    public Integer getActionManagerStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionManagerStartupInfoList != null) {
            count = this.actionManagerStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns list of daemon startup information.
     *
     * @return Returns list of daemon startup information
     */
    public Set<DaemonStartupInfo> getDaemonStartupInfoList() {
        if (this.daemonStartupInfoList == null) {
            this.daemonStartupInfoList = new HashSet<DaemonStartupInfo>();
        }

        return this.daemonStartupInfoList;
    }

    /**
     * Sets list of daemon startup information.
     *
     * @param newDaemonStartupInfoList New daemon startup information list
     */
    protected void setDaemonStartupInfoList(final Set<DaemonStartupInfo> newDaemonStartupInfoList) {
        this.daemonStartupInfoList = newDaemonStartupInfoList;
    }

    /**
     * Returns list of action startup information.
     *
     * @return Returns list of action startup information
     */
    public Set<ActionStartupInfo> getActionStartupInfoList() {
        if (this.actionStartupInfoList == null) {
            this.actionStartupInfoList = new HashSet<ActionStartupInfo>();
        }

        return this.actionStartupInfoList;
    }

    /**
     * Sets list of action startup information.
     *
     * @param newActionStartupInfoList New action startup information list
     */
    protected void setActionStartupInfoList(final Set<ActionStartupInfo> newActionStartupInfoList) {
        this.actionStartupInfoList = newActionStartupInfoList;
    }

    /**
     * Returns list of action manager startup information.
     *
     * @return Returns list of action manager startup information
     */
    public Set<ActionManagerStartupInfo> getActionManagerStartupInfoList() {
        if (this.actionManagerStartupInfoList == null) {
            this.actionManagerStartupInfoList = new HashSet<ActionManagerStartupInfo>();
        }

        return this.actionManagerStartupInfoList;
    }

    /**
     * Sets list of action manager startup information.
     *
     * @param newActionManagerStartupInfoList New action manager startup information list
     */
    protected void setActionManagerStartupInfoList(final Set<ActionManagerStartupInfo> newActionManagerStartupInfoList) {
        this.actionManagerStartupInfoList = newActionManagerStartupInfoList;
    }
}
