/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

import dsm.common.DSMManifest;
import java.util.UUID;

/**
 * DSMManagedObject abstract class provides basic operations and attributes to
 * all DSM managed object classes.
 * 
 * This class must be inherited by all DSM managed object classes in order to
 * use standardized operations and attributes for them.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class DSMManagedObject extends DSMManifest implements DSMObject {

    /**
     * DSM object name
     */
    protected String dsmObjectName = "No name specified yet!!!";

    /**
     * DSM object type
     */
    protected DSMObjectType dsmObjectType = DSMObjectType.ManagedObject;

    /**
     * DSMManagedObject Constructor
     * @param nUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szDSMObjectName DSM object name
     */
    public DSMManagedObject(UUID nUniqueId, String szFriendlyName, String szDSMObjectName) {
        super(nUniqueId, szFriendlyName);
        
        dsmObjectName = szDSMObjectName;
    }

    /**
     * DSMManagedObject Constructor
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szDSMObjectName DSM object name
     */
    public DSMManagedObject(String szUniqueId, String szFriendlyName, String szDSMObjectName) {
        super(szUniqueId, szFriendlyName);

        dsmObjectName = szDSMObjectName;
    }

    /**
     * Returns DSM object name.
     * @return DSM object name
     */
    @Override
    public String getDSMObjectName() {
        return dsmObjectName;
    }

    /**
     * Returns DSM object type.
     * @return DSM object type
     */
    @Override
    public DSMObjectType getDSMObjectType() {
        return dsmObjectType;
    }
}
