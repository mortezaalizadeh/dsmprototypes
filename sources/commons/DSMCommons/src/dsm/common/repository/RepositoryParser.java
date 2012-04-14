/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;

/**
 * RepositoryParser class parses repository file and extract information from it.
 * 
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryParser extends DSMManifest {

    /**
     * RepositoryParser Constructor
     */
    public RepositoryParser() {
        super("f239604f-bf65-4d05-9ef1-2a34c8e6411a", "Repository Parser");
    }
    
    /**
     * Loads repository information from an repository file.
     * 
     * @param szRepositoryFilePath Repository file path
     */
    public void loadRepositoryFromFile(String szRepositoryFilePath) {
    }

    /**
     * Loads repository information from passed string content.
     * 
     * @param szStringContent String content
     */
    public void loadRepositoryFromStringContent(String szStringContent) {
    }
}
