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
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public class DSMManifest extends Object {

    protected String uniqueId = "00000000-0000-0000-0000-000000000000";
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
     * @return DSM object unique identifier
     */
    public String getDSMUniqueIdentifier() {
        return uniqueId;
    }

    /**
     * Returns DSM object friendly name.
     * 
     * @return DSM object friendly name
     */
    public String getFriendlyName() {
        return friendlyName;
    }
}
