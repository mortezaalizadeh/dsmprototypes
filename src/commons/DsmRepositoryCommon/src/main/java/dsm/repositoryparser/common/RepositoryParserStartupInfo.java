/**
 * @author Morteza Alizadeh
 */
package dsm.repositoryparser.common;

/**
 * RepositoryParserStartupInfo interface represents Repository Startup
 * Information.
 *
 * It must be implemented by all repository startup information classes
 * implementation.
 *
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public interface RepositoryParserStartupInfo {

    /**
     * Returns daemon name.
     *
     * @return Repository parser name
     */
    String getName();

    /**
     * Set repository parser name.
     *
     * @param newName New daemon name to set
     */
    void setName(final String newName);

    /**
     * Returns repository parser library.
     *
     * @return Repository parser library
     */
    String getLibrary();

    /**
     * Set repository parser library.
     *
     * @param newLibrary New repository parser library to set
     */
    void setLibrary(final String newLibrary);

    /**
     * Returns repository parser package name.
     *
     * @return Repository parser package name
     */
    String getPackageName();

    /**
     * Set repository parser package name.
     *
     * @param newPackageName New repository parser package name to set
     */
    void setPackageName(final String newPackageName);

    /**
     * Returns repository parser class name.
     *
     * @return Repository parser class name
     */
    String getClassName();

    /**
     * Set repository parser class name.
     *
     * @param newClassName New repository parser class name to set
     */
    void setClassName(final String newClassName);
}
