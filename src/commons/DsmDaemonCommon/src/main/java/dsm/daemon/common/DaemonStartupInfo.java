/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.common;

/**
* DaemonInfo class is an entity class represent a daemon.
*
* @version 0.1, April 16, 2012
  * @author Morteza Alizadeh
 */
public interface DaemonStartupInfo {

    /**
     * Returns daemon name.
     *
     * @return Daemon name
     */
    String getName();

    /**
     * Set daemon name.
     *
     * @param newName New daemon name
     */
    void setName(final String newName);

    /**
     * Returns daemon library.
     *
     * @return Daemon library
     */
    String getLibrary();

    /**
     * Set daemon library.
     *
     * @param newLibrary New daemon library
     */
    void setLibrary(final String newLibrary);

    /**
     * Returns daemon package name.
     *
     * @return Daemon package name
     */
    String getPackageName();

    /**
     * Set daemon package name.
     *
     * @param newPackageName New daemon package name
     */
    void setPackageName(final String newPackageName);

    /**
     * Returns daemon class name.
     *
     * @return Daemon class name
     */
    String getClassName();

    /**
     * Set daemon class name.
     *
     * @param newClassName New daemon class name
     */
    void setClassName(final String newClassName);

    /**
     * Returns daemon configuration file full path.
     *
     * @return Daemon configuration file full path
     */
    String getConfigurationFileFullPath();

    /**
     * Set daemon configuration file full path.
     *
     * @param newConfigurationFileFullPath New daemon configuration file full path
     */
    void setConfigurationFileFullPath(final String newConfigurationFileFullPath);
}
