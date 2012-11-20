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
    private List<DaemonStartupInfo> daemonStartupInfoList = null;

    /**
     * Action list.
     */
    private List<ActionStartupInfo> actionStartupInfoList = null;

    /**
     * Action manager list.
     */
    private List<ActionManagerStartupInfo> actionManagerStartupInfoList = null;

    /**
     * BasicRepositoryInfo constructor.
     */
    public BasicRepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Basic Repository Info");
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
     * Adds new daemon startup info to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup info
     */
    public void addDaemonStartupInfo(final DaemonStartupInfo daemonStartupInfo) {
        this.getDaemonStartupInfoList().add(daemonStartupInfo);
    }

    /**
     * Adds new action startup info to list of daemons.
     *
     * @param actionStartupInfo Action startup info
     */
    public void addActionStartupInfo(final ActionStartupInfo actionStartupInfo) {
        this.getActionStartupInfoList().add(actionStartupInfo);
    }

    /**
     * Adds new action manager startup info to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup info
     */
    public void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo) {
        this.getActionManagerStartupInfoList().add(actionManagerStartupInfo);
    }

    /**
     * Returns the number of added daemon startup info.
     *
     * @return Returns the number of added daemon startup info
     */
    public Integer getDaemonStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.daemonStartupInfoList != null) {
            count = this.daemonStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the number of added action startup info.
     *
     * @return Returns the number of added action startup info
     */
    public Integer getActionStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionStartupInfoList != null) {
            count = this.actionStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the number of added action manager startup info.
     *
     * @return Returns the number of added action manager startup info
     */
    public Integer getActionManagerStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionManagerStartupInfoList != null) {
            count = this.actionManagerStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns daemon startup info list.
     *
     * @return Returns daemon list startup info
     */
    public List<DaemonStartupInfo> getDaemonStartupInfoList() {
        if (this.daemonStartupInfoList == null) {
            this.daemonStartupInfoList = new LinkedList<DaemonStartupInfo>();
        }

        return this.daemonStartupInfoList;
    }

    /**
     * Set daemon list startup info.
     *
     * @param newDaemonStartupInfoList New daemon list startup info
     */
    protected void setDaemonStartupInfoList(final List<DaemonStartupInfo> newDaemonStartupInfoList) {
        this.daemonStartupInfoList = newDaemonStartupInfoList;
    }

    /**
     * Returns action list startup info.
     *
     * @return Returns action list startup info
     */
    public List<ActionStartupInfo> getActionStartupInfoList() {
        if (this.actionStartupInfoList == null) {
            this.actionStartupInfoList = new LinkedList<ActionStartupInfo>();
        }

        return this.actionStartupInfoList;
    }

    /**
     * Set action list startup info.
     *
     * @param newActionStartupInfoList New action list startup info
     */
    protected void setActionStartupInfoList(final List<ActionStartupInfo> newActionStartupInfoList) {
        this.actionStartupInfoList = newActionStartupInfoList;
    }

    /**
     * Returns action manager list startup info.
     *
     * @return Returns action manager list startup info
     */
    public List<ActionManagerStartupInfo> getActionManagerStartupInfoList() {
        if (this.actionManagerStartupInfoList == null) {
            this.actionManagerStartupInfoList = new LinkedList<ActionManagerStartupInfo>();
        }

        return this.actionManagerStartupInfoList;
    }

    /**
     * Set action manager list startup info.
     *
     * @param newActionManagerStartupInfoList New action manager list startup info
     */
    protected void setActionManagerStartupInfoList(final List<ActionManagerStartupInfo> newActionManagerStartupInfoList) {
        this.actionManagerStartupInfoList = newActionManagerStartupInfoList;
    }
}
