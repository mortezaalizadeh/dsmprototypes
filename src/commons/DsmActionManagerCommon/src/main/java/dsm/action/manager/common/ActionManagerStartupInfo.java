/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager.common;

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
     * Returns action manager name.
     *
     * @return Action manager name
     */
    String getName();

    /**
     * Set action manager name.
     *
     * @param newName New action manager name to set
     */
    void setName(final String newName);

    /**
     * Returns action manager library.
     *
     * @return Action manager library
     */
    String getLibrary();

    /**
     * Set action manager library.
     *
     * @param newLibrary New action manager library to set
     */
    void setLibrary(final String newLibrary);

    /**
     * Returns action manager package name.
     *
     * @return Action manager package name
     */
    String getPackageName();

    /**
     * Set action manager package name.
     *
     * @param newPackageName New action manager package name to set
     */
    void setPackageName(final String newPackageName);

    /**
     * Returns action manager class name.
     *
     * @return Action manager class name
     */
    String getClassName();

    /**
     * Set action manager class name.
     *
     * @param newClassName New action manager class name to set
     */
    void setClassName(final String newClassName);

    /**
     * Returns action manager configuration file full path.
     *
     * @return Action manager configuration file full path
     */
    String getConfigurationFileFullPath();

    /**
     * Set action manager configuration file full path.
     *
     * @param newConfigurationFileFullPath New action manager configuration file full path to set
     */
    void setConfigurationFileFullPath(final String newConfigurationFileFullPath);
}
