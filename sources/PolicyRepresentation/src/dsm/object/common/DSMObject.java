/**
 * @author Morteza Alizadeh
 */
package dsm.object.common;

/**
 * DSMObject interface defines general operations and attributes for a DSM
 * object.
 * 
 * This interface must be implemented by all different type of DSM object
 * classes.
 * 
  * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface DSMObject {

    /**
     * Returns DSM object name.
     * @return DSM object name
     */
    String getDSMObjectName();
}
