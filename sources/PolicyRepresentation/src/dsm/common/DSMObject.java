package dsm.common;

import java.util.UUID;

/**
 * DSM Root Object
 * @author Morteza Alizadeh
 */
public class DSMObject {
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
        uniqueId = uniqueId;
    }

    /**
     * DSMObject Constructor
     * @param  szUniqueId DSM object unique identifier
     */
    public DSMObject(String szUniqueId) {
        uniqueId = UUID.fromString(szUniqueId);
    }

    /**
     * Return policy modality unique identifier
     * @return Policy modality name
     */
    UUID getModalityUniqueId(){
        return uniqueId;
    }
}
