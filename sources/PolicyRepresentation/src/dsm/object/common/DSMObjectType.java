/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

/**
 * DSMObjectType defines different DSM object types.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public enum DSMObjectType {
    
    /**
     * A managed object is one which supports a management interface.
     * 
     * Management entails obtaining information on the current state of a
     * managed object, making decisions and performing control operations on the
     * object to modify its behavior.
     */
    ManagedObject,

    /**
     * A manager is one which manages managed objects.
     * 
     * A manager itself can be managed by other managers.
     */
    Manager,
    
    /**
     * A domain is one which includes other DMS object.
     * 
     * A domain DSM object type may include objects of any type including
     * itself.
     */
    Domain
}
