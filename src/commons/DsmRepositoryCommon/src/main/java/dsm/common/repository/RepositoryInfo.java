/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;
import java.util.LinkedList;
import java.util.List;

/**
* RepositoryInfo class is an entity class represent a repository of any defined
* type.
 *
* @version 0.1, April 15, 2012
  * @author Morteza Alizadeh
 */
public class RepositoryInfo extends DsmManifest {

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
    private final transient List<DaemonStartupInfo> daemonList = new LinkedList<DaemonStartupInfo>();

    /**
     * Action manager list.
     */
    private final transient List<ActionManagerStartupInfo> actionManagerList = new LinkedList<ActionManagerStartupInfo>();

    /**
     * Action list.
     */
    private final transient List<ActionStartupInfo> actionList = new LinkedList<ActionStartupInfo>();

    /**
     * RepositoryInfo constructor.
     */
    public RepositoryInfo() {
        super("3400bc81-d2c1-4a9f-9ca8-97cedcbe515b", "Repository Info");
    }

    /**
     * Returns repository unique identifier.
     *
     * @return Repository unique identifier
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Set repository name.
     *
     * @param newName New repository name to set
     */
    public final void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns repository unique identifier.
     *
     * @return Repository unique identifier
     */
    public final String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set repository unique identifier.
     *
     * @param newUniqueIdentifier New repository unique identifier to set
     */
    public final void setUniqueIdentifier(final String newUniqueIdentifier) {
        this.uniqueIdentifier = newUniqueIdentifier;
    }

    /**
     * Returns repository include in startup flag.
     *
     * @return Repository include in startup flag
     */
    public final boolean isIncludeInStartup() {
        return this.includeInStartup;
    }

    /**
     * Set repository include in startup flag.
     *
     * @param bIncludeInStartup New repository include in startup flag to set
     */
    public final void setIncludeInStartup(final boolean bIncludeInStartup) {
        this.includeInStartup = bIncludeInStartup;
    }

    /**
     * Adds new daemon to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup info
     */
    public final void addDaemon(final DaemonStartupInfo daemonStartupInfo) {
        this.daemonList.add(daemonStartupInfo);
    }

    /**
     * Adds new action manager to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup info
     */
    public final void addActionManager(final ActionManagerStartupInfo actionManagerStartupInfo) {
        this.actionManagerList.add(actionManagerStartupInfo);
    }

    /**
     * Adds new action to list of daemons.
     *
     * @param actionStartupInfo Action startup info
     */
    public final void addAction(final ActionStartupInfo actionStartupInfo) {
        this.actionList.add(actionStartupInfo);
    }
}
