/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

import dsm.common.DSMManifest;

/**
 * ManagedObject abstract class provides basic operations and attributes to all
 * managed object classes.
 * 
 * This class must be inherited by all managed object classes in order to use
 * standardized operations and attributes for them.
 * 
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public abstract class ManagedObject extends DSMManifest implements DSMObject {

    /**
     * DSM object name
     */
    protected String dsmObjectName = "No name specified yet!!!";

    /**
     * DSM object type
     */
    protected DSMObjectType dsmObjectType = DSMObjectType.ManagedObject;

    /**
     * ManagedObject Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szDSMObjectName DSM object name
     */
    public ManagedObject(String szUniqueId, String szFriendlyName, String szDSMObjectName) {
        super(szUniqueId, szFriendlyName);

        this.dsmObjectName = szDSMObjectName;
    }

    /**
     * Returns DSM object name.
     * 
     * @return DSM object name
     */
    @Override
    public String getDSMObjectName() {
        return this.dsmObjectName;
    }

    /**
     * Returns DSM object type.
     * 
     * @return DSM object type
     */
    @Override
    public DSMObjectType getDSMObjectType() {
        return this.dsmObjectType;
    }
}
