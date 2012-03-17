/**
 * @author Morteza Alizadeh
 */
package dsm.common;

import java.util.UUID;

/**
 * DMSObject class defines basic operations and attributes for DSM classes.
 * 
 * This class must be inherited by all DSM classes.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public class DSMObject extends Object {

    protected UUID uniqueId = null;

    /**
     * DSMObject Constructor
     */
    public DSMObject() {
        uniqueId = UUID.fromString("00000000-0000-0000-0000-000000000000");
    }
    
    /**
     * DSMObject Constructor
     * @param  nUniqueId DSM object unique identifier
     */
    public DSMObject(UUID nUniqueId) {
        uniqueId = nUniqueId;
    }

    /**
     * DSMObject Constructor
     * @param  szUniqueId DSM object unique identifier
     */
    public DSMObject(String szUniqueId) {
        uniqueId = UUID.fromString(szUniqueId);
    }

    /**
     * Returns DSM object unique identifier.
     * @return DSM object unique identifier
     */
    UUID getUniqueId() {
        return uniqueId;
    }
}
