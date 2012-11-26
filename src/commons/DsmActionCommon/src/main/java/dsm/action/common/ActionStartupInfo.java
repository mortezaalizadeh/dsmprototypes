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
}
