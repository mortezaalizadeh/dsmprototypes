/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.common;

import dsm.action.manager.common.ActionManagerStartupInfo;
import java.util.Set;

/**
 * DaemonStartupInfo interface represents Daemon Startup Information.
 *
 * It must be implemented by all daemon startup information classes
 * implementation.
 *
 * @version 0.1, April 16, 2012
 * @author Morteza Alizadeh
 */
public interface DaemonStartupInfo {

    /**
     * Returns unique identifier.
     *
     * @return Unique identifier
     */
    String getUniqueIdentifier();

    /**
     * Set unique identifier.
     *
     * @param newUniqueIdentifier New unique identifier
     */
    void setUniqueIdentifier(final String newUniqueIdentifier);

    /**
     * Returns library.
     *
     * @return Library
     */
    String getLibrary();

    /**
     * Set library.
     *
     * @param newLibrary New library
     */
    void setLibrary(final String newLibrary);

    /**
     * Returns package name.
     *
     * @return Package name
     */
    String getPackageName();

    /**
     * Set package name.
     *
     * @param newPackageName New package name
     */
    void setPackageName(final String newPackageName);

    /**
     * Returns class name.
     *
     * @return Class name
     */
    String getClassName();

    /**
     * Set class name.
     *
     * @param newClassName New class name
     */
    void setClassName(final String newClassName);

    /**
     * Returns configuration file full path.
     *
     * @return Configuration file full path
     */
    String getConfigurationFileFullPath();

    /**
     * Set configuration file full path.
     *
     * @param newConfigurationFileFullPath New configuration file full path
     */
    void setConfigurationFileFullPath(final String newConfigurationFileFullPath);

    /**
     * Adds new action manager startup information.
     *
     * @param actionManagerStartupInfo Reference to action manager startup
     * information to add
     */
    void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo);

    /**
     * Removes already added action manager startup information.
     *
     * @param actionManagerStartupInfo Reference to action manager startup
     * information to remove
     */
    void removeActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo);

    /**
     * Returns the number of added action manager startup information.
     *
     * @return Returns the number of added action manager startup information
     */
    Integer getActionManagerStartupInfoCount();

    /**
     * Returns the list of action manager startup information.
     *
     * @return List of action manager startup information
     */
    Set<ActionManagerStartupInfo> getActionManagerStartupInfoList();
}
