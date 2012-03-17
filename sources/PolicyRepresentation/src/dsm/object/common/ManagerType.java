/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

/**
 * ManagerType defines different DSM manager types.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public enum ManagerType {
    
    /**
     * Human type of manager.
     */
    Human,

    /**
     * A manager which is instructed by a human manager and try to achieve
     * objectives automatically.
     */
    AutomatedManager,
}
