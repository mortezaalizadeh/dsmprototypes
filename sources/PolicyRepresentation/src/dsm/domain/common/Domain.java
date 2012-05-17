/**
 * @author Morteza Alizadeh
 */
package dsm.domain.common;

import dsm.common.DSMManifest;
import dsm.object.common.DSMObject;
import dsm.object.common.DSMObjectType;
import java.util.List;

/**
 * Domain abstract class provides basic operations and attributes to all domain
 * classes.
 * 
 * This class must be inherited by all domain classes in order to use
 * standardized operations and attributes for them.
 * 
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public abstract class Domain extends DSMManifest implements DSMObject {

    /**
     * DSM object name
     */
    protected String dsmObjectName = "No name specified yet!!!";

    /**
     * DSM object type
     */
    protected DSMObjectType dsmObjectType = DSMObjectType.Domain;

    /**
     * Domain name
     */
    protected String domainName = "No name specified yet!!!";

    /**
     * Domain Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szDSMObjectName DSM object name
     * @param szDomainName Domain name
     */
    public Domain(String szUniqueId, String szFriendlyName, String szDSMObjectName, String szDomainName) {
        super(szUniqueId, szFriendlyName);

        this.dsmObjectName = szDSMObjectName;
        this.domainName = szDomainName;
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
    
    /**
     * Returns domain name.
     * 
     * @return Domain name
     */
    public String getDomainName() {
        return this.domainName;
    }
    
    /**
     * This creates an object in a domain from a specified template, and sets
     * its attributes according to specified parameters or default values.
     * 
     * @param dsmObject DSM object to create
     */
    public void createDSMObject(DSMObject dsmObject) {
        throw new UnsupportedOperationException("createDSMObject method is not implemented in abstract class level definition.");
    }

    /**
     * This removes the object from the system and recovers any resources
     * allocated.
     * 
     * There may be constraints in that an object can only be destroyed when in
     * a passive or stopped state.
     * 
     * @param dsmObject DSM object to destroy
     */
    public void destroyDSMObject(DSMObject dsmObject) {
        throw new UnsupportedOperationException("destroyDSMObject method is not implemented in abstract class level definition.");
    }

    /**
     * This includes an object into a domain by adding its identity to the
     * object set of the domain.
     * 
     * It does not affect its membership of other domains. The effect is to
     * make an existing object a member of an additional domain without creating
     * a new instance of the object.
     * 
     * @param dsmObject DSM object to include
     */
    public void includeDSMObjectInDomain(DSMObject dsmObject) {
        throw new UnsupportedOperationException("includeDSMObjectInDomain method is not implemented in abstract class level definition.");
    }

    /**
     * This removes an object from a domain without affecting the state of the
     * object.
     * 
     * Removal of an object from a domain is carried out by removing its
     * identity from the object set.
     * 
     * @param dsmObject DSM object to remove
     */
    public void removeDSMObjectFromDomain(DSMObject dsmObject) {
        throw new UnsupportedOperationException("removeDSMObjectFromDomain method is not implemented in abstract class level definition.");
    }
    
    /**
     * This returns list of DSM domain objects.
     * 
     * @return List of DSM domain objects.
     */
    public List<DSMObject> getDomainDSMObjectList(){
        throw new UnsupportedOperationException("getDomainDSMObjectList method is not implemented in abstract class level definition.");
    }
}
