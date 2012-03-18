/**
 * @author Morteza Alizadeh
 */
package dsm.common;

import java.util.UUID;

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

    protected UUID uniqueId = UUID.fromString("00000000-0000-0000-0000-000000000000");
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
    public DSMManifest(UUID nUniqueId) {
        uniqueId = nUniqueId;
    }

    /**
     * DSMManifest Constructor
     * 
     * @param nUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     */
    public DSMManifest(UUID nUniqueId, String szFriendlyName) {
        uniqueId = nUniqueId;
        friendlyName = szFriendlyName;
    }

    /**
     * DSMManifest Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     */
    public DSMManifest(String szUniqueId, String szFriendlyName) {
        uniqueId = UUID.fromString(szUniqueId);
        friendlyName = szFriendlyName;
    }

    /**
     * Returns DSM object unique identifier.
     * 
     * @return DSM object unique identifier
     */
    public UUID getDSMUniqueIdentifier() {
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
