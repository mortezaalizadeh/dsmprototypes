/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

/**
 * Modality Interface defines general operations and attributes for a policy
 * modality.
 * This interface must be implemented by all Policy Modality classes.
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface Modality {
    /**
     * Returns policy modality friendly name.
     * @return Policy modality name
     */
    String getModalityName();

    /**
     * Returns policy modality type.
     * @return Policy modality type
     */
    ModalityType getModalityType();
}
