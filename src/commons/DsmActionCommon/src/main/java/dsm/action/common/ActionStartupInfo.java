/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

/**
 * ActionStartupInfo interface represents Action Startup Information.
 *
 * It must be implemented by all action startup information classes
 * implementation.
 *
 * @version 0.1, May 20, 2012
 * @author Morteza Alizadeh
 */
public interface ActionStartupInfo {

    /**
     * Returns action name.
     *
     * @return Action name
     */
    String getName();

    /**
     * Set action name.
     *
     * @param newName New action name
     */
    void setName(final String newName);

    /**
     * Returns action library.
     *
     * @return Action library
     */
    String getLibrary();

    /**
     * Set action library.
     *
     * @param newLibrary New action library
     */
    void setLibrary(final String newLibrary);

    /**
     * Returns action package name.
     *
     * @return Action package name
     */
    String getPackageName();

    /**
     * Set action package name.
     *
     * @param newPackageName New action package name
     */
    void setPackageName(final String newPackageName);

    /**
     * Returns action class name.
     *
     * @return Action class name
     */
    String getClassName();

    /**
     * Set action class name.
     *
     * @param newClassName New action class name
     */
    void setClassName(final String newClassName);

    /**
     * Returns action configuration file full path.
     *
     * @return Action configuration file full path
     */
    String getConfigurationFileFullPath();

    /**
     * Set action configuration file full path.
     *
     * @param newConfigurationFileFullPath New action configuration file full path
     */
    void setConfigurationFileFullPath(final String newConfigurationFileFullPath);
}
