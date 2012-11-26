/**
 * @author Morteza Alizadeh
 */
package dsm.repository.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.daemon.common.DaemonStartupInfo;
import java.util.Set;

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
     * Adds new daemon startup information to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup information
     */
    void addDaemonStartupInfo(final DaemonStartupInfo daemonStartupInfo);

    /**
     * Adds new action startup information to list of daemons.
     *
     * @param actionStartupInfo Action startup information
     */
    void addActionStartupInfo(final ActionStartupInfo actionStartupInfo);

    /**
     * Adds new action manager startup information to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup information
     */
    void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo);

    /**
     * Returns the number of added daemon startup information.
     *
     * @return Returns the number of added daemon startup information
     */
    Integer getDaemonStartupInfoCount();

    /**
     * Returns the number of added action startup information.
     *
     * @return Returns the number of added action startup information
     */
    Integer getActionStartupInfoCount();

    /**
     * Returns the number of added action manager startup information.
     *
     * @return Returns the number of added action manager startup information
     */
    Integer getActionManagerStartupInfoCount();

    /**
     * Returns list of daemon startup information.
     *
     * @return Returns list of daemon startup information
     */
    Set<DaemonStartupInfo> getDaemonStartupInfoList();

    /**
     * Returns list of action startup information.
     *
     * @return Returns list of action startup information
     */
    Set<ActionStartupInfo> getActionStartupInfoList();

    /**
     * Returns list of action manager startup information.
     *
     * @return Returns list of action manager startup information
     */
    Set<ActionManagerStartupInfo> getActionManagerStartupInfoList();
}
