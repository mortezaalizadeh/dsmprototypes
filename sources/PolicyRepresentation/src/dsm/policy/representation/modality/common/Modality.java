/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

/**
 * Modality interface defines general operations and attributes for a policy
 * modality.
 * 
 * This interface must be implemented by all policy modality classes.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface Modality {
    
    /**
     * Returns modality name.
     * 
     * @return Modality name
     */
    String getModalityName();

    /**
     * Returns modality type.
     * 
     * @return Modality type
     */
    ModalityType getModalityType();
}
