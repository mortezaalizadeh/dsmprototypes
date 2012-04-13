/**
 * @author Morteza Alizadeh
 */
package dsm.common;

/**
 * DSMManifest class defines basic operations and attributes for all DSM
 * classes.
 * 
 * This class must be inherited by all DSM classes.
 * 
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public class DSMManifest extends Object {

    /**
     * DSM object unique ID
     */
    protected String uniqueId = "00000000-0000-0000-0000-000000000000";

    /**
     * DSM object friendly name
     */
    protected String friendlyName = "No name specified yet!!!";

    /**
     * DSMManifest Constructor
     */
    public DSMManifest() {
    }
    
    /**
     * DSMManifest Constructor
     * 
     * @param nUniqueId DSM object unique identifier
     */
    public DSMManifest(String szUniqueId) {
        uniqueId = szUniqueId;
    }

    /**
     * DSMManifest Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     */
    public DSMManifest(String szUniqueId, String szFriendlyName) {
        uniqueId = szUniqueId;
        friendlyName = szFriendlyName;
    }

    /**
     * Returns DSM object unique identifier.
     * 
     * @return Returns DSM object unique identifier
     */
    public String getDSMUniqueIdentifier() {
        return uniqueId;
    }

    /**
     * Sets DSM object unique identifier.
     * 
     * @param szUniqueId Refers to DSM object unique identifier to be set
     */
    protected void setDSMUniqueIdentifier(String szUniqueId) {
        uniqueId = szUniqueId;
    }

    /**
     * Returns DSM object friendly name.
     * 
     * @return Returns DSM object friendly name
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets DSM object friendly name.
     * 
     * @param szFriendlyName Refers to DSM object friendly name to be set
     */
    protected void setFriendlyName(String szFriendlyName) {
        friendlyName = szFriendlyName;
    }
}
