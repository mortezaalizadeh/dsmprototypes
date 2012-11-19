/**
 * @author Morteza Alizadeh
 */
package dsm.repository.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.daemon.common.DaemonStartupInfo;

/**
 * RepositoryInfo interface represents Repository Information.
 *
 * It must be implemented by all repository information classes implementation.
 *
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public interface RepositoryInfo {

    /**
     * Returns repository unique identifier.
     *
     * @return Repository unique identifier
     */
    String getName();

    /**
     * Set repository name.
     *
     * @param newName New repository name to set
     */
    void setName(final String newName);

    /**
     * Returns repository unique identifier.
     *
     * @return Repository unique identifier
     */
    String getUniqueIdentifier();

    /**
     * Set repository unique identifier.
     *
     * @param newUniqueIdentifier New repository unique identifier to set
     */
    void setUniqueIdentifier(final String newUniqueIdentifier);

    /**
     * Returns repository include in startup flag.
     *
     * @return Repository include in startup flag
     */
    boolean isIncludeInStartup();

    /**
     * Set repository include in startup flag.
     *
     * @param bIncludeInStartup New repository include in startup flag to set
     */
    void setIncludeInStartup(final boolean bIncludeInStartup);

    /**
     * Adds new daemon to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup info
     */
    void addDaemon(final DaemonStartupInfo daemonStartupInfo);

    /**
     * Adds new action manager to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup info
     */
    void addActionManager(final ActionManagerStartupInfo actionManagerStartupInfo);

    /**
     * Adds new action to list of daemons.
     *
     * @param actionStartupInfo Action startup info
     */
    void addAction(final ActionStartupInfo actionStartupInfo);
}
