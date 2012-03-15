package dsm.policy.representation.modality.common;

/**
 * IModality Interface to standardize Policy Modality concept
 * @author Morteza Alizadeh
 */
public interface IModality {
    /**
     * Return policy modality friendly name
     * @return Policy modality name
     */
    String getModalityName();

    /**
     * Return policy modality type
     * @return Policy modality type
     */
    ModalityType getModalityType();
}
