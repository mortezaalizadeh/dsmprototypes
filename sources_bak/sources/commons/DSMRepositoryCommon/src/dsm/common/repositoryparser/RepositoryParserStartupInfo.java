/**
 * @author Morteza Alizadeh
 */
package dsm.common.repositoryparser;

import dsm.common.DSMManifest;

/**
* RepositoryParserStartupInfo class is an entity class represent a repository
* parser startup info.
* 
* @version 0.1, May 22, 2012
  * @author Morteza Alizadeh
 */
public class RepositoryParserStartupInfo extends DSMManifest {

    /**
     * Repository parser name
     */
    private String name;

    /**
     * Repository parser library
     */
    private String library;

    /**
     * Repository parser package name
     */
    private String packageName;

    /**
     * Repository parser class name
     */
    private String className;

    /**
     * RepositoryParserStartupInfo constructor.
     */
    public RepositoryParserStartupInfo() {
        super("2314398d-758a-412e-8d21-515c90b87667", "Repository Parser Startup Info");
        
        this.name = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
    }

    /**
     * Returns daemon name.
     * 
     * @return Repository parser name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set repository parser name.
     * 
     * @param szName New daemon name to set
     */
    public void setName(String szName) {
        this.name = szName;
    }

    /**
     * Returns repository parser library.
     * 
     * @return Repository parser library
     */
    public String getLibrary() {
        return this.library;
    }

    /**
     * Set repository parser library.
     * 
     * @param szLibrary New repository parser library to set
     */
    public void setLibrary(String szLibrary) {
        this.library = szLibrary;
    }

    /**
     * Returns repository parser package name.
     * 
     * @return Repository parser package name
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * Set repository parser package name.
     * 
     * @param szPackageName New repository parser package name to set
     */
    public void setPackageName(String szPackageName) {
        this.packageName = szPackageName;
    }

    /**
     * Returns repository parser class name.
     * 
     * @return Repository parser class name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Set repository parser class name.
     * 
     * @param szClassName New repository parser class name to set
     */
    public void setClassName(String szClassName) {
        this.className = szClassName;
    }
}
