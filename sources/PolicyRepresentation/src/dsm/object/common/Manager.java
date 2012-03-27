/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

import dsm.common.DSMManifest;
import java.util.UUID;

/**
 * Manager abstract class provides basic operations and attributes to all
 * manager classes.
 * 
 * This class must be inherited by all manager classes in order to use 
 * standardized operations and attributes for them.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class Manager extends DSMManifest implements DSMObject {

    /**
     * DSM object name
     */
    protected String dsmObjectName = "No name specified yet!!!";

    /**
     * DSM object type
     */
    protected DSMObjectType dsmObjectType = DSMObjectType.Manager;

    /**
     * DSM manager type
     */
    protected ManagerType dsmManagerType;

    /**
     * Manager Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szDSMObjectName DSM object name
     */
    public Manager(String szUniqueId, String szFriendlyName, String szDSMObjectName, ManagerType nDSMManagerType) {
        super(szUniqueId, szFriendlyName);

        dsmObjectName = szDSMObjectName;
        dsmManagerType = nDSMManagerType;
    }

    /**
     * Returns DSM object name.
     * 
     * @return DSM object name
     */
    @Override
    public String getDSMObjectName() {
        return dsmObjectName;
    }

    /**
     * Returns DSM object type.
     * 
     * @return DSM object type
     */
    @Override
    public DSMObjectType getDSMObjectType() {
        return dsmObjectType;
    }

    /**
     * Returns DSM manager type.
     * 
     * @return DSM manager type
     */
    public ManagerType getDSMManagerType() {
        return dsmManagerType;
    }
}
