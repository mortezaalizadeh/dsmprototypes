/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager.common;

import dsm.action.common.ActionStartupInfo;
import java.util.Set;

/**
 * ActionManagerStartupInfo interface represents Action Manager Startup
 * Information.
 *
 * It must be implemented by all action manager startup information classes
 * implementation.
 *
 * @version 0.1, May 20, 2012
 * @author Morteza Alizadeh
 */
public interface ActionManagerStartupInfo {

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
     * Adds new action startup information.
     *
     * @param actionStartupInfo Reference to action  startup
     * information to add
     */
    void addActionStartupInfo(final ActionStartupInfo actionStartupInfo);

    /**
     * Removes already added action startup information.
     *
     * @param actionStartupInfo Reference to action startup
     * information to remove
     */
    void removeActionStartupInfo(final ActionStartupInfo actionStartupInfo);

    /**
     * Returns the number of added action startup information.
     *
     * @return Returns the number of added action startup information
     */
    Integer getActionStartupInfoCount();

    /**
     * Returns the list of action startup information.
     *
     * @return List of action startup information
     */
    Set<ActionStartupInfo> getActionStartupInfoList();

    /**
     * Set configuration file full path.
     *
     * @param newConfigurationFileFullPath New configuration file full path
     */
    void setConfigurationFileFullPath(final String newConfigurationFileFullPath);
}
