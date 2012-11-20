/**
 * @author Morteza Alizadeh
 */
package dsm.repository.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.daemon.common.DaemonStartupInfo;
import java.util.List;

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
     * Adds new daemon startup info to list of daemons.
     *
     * @param daemonStartupInfo Daemon startup info
     */
    void addDaemonStartupInfo(final DaemonStartupInfo daemonStartupInfo);

    /**
     * Adds new action startup info to list of daemons.
     *
     * @param actionStartupInfo Action startup info
     */
    void addActionStartupInfo(final ActionStartupInfo actionStartupInfo);

    /**
     * Adds new action manager startup info to list of daemons.
     *
     * @param actionManagerStartupInfo Action manager startup info
     */
    void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo);

    /**
     * Returns the number of added daemon startup info.
     *
     * @return Returns the number of added daemon startup info
     */
    Integer getDaemonStartupInfoCount();

    /**
     * Returns the number of added action startup info.
     *
     * @return Returns the number of added action startup info
     */
    Integer getActionStartupInfoCount();

    /**
     * Returns the number of added action manager startup info.
     *
     * @return Returns the number of added action manager startup info
     */
    Integer getActionManagerStartupInfoCount();

    /**
     * Returns daemon startup info list.
     *
     * @return Returns daemon list startup info
     */
    List<DaemonStartupInfo> getDaemonStartupInfoList();

    /**
     * Returns action list startup info.
     *
     * @return Returns action list startup info
     */
    List<ActionStartupInfo> getActionStartupInfoList();

    /**
     * Returns action manager list startup info.
     *
     * @return Returns action manager list startup info
     */
    List<ActionManagerStartupInfo> getActionManagerStartupInfoList();
}
