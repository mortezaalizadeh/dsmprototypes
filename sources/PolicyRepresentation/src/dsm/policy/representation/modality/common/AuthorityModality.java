package dsm.policy.representation.modality.common;

import java.util.UUID;

/**
 * Abstract class to define general authority modality behavior
 * @author Morteza Alizadeh
 */
public abstract class AuthorityModality extends Modality{
    /**
     * AuthorityModality Constructor
     * @param  nUniqueId DSM object unique identifier
     */
    public AuthorityModality(UUID nUniqueId) {
        super(nUniqueId);
    }

    /**
     * AuthorityModality Constructor
     * @param  szUniqueId DSM object unique identifier
     */
    public AuthorityModality(String szUniqueId) {
        super(szUniqueId);
    }

    /**
     * Return policy modality friendly name
     * @return Policy modality name
     */
    @Override
    public String getModalityName() {
        throw new UnsupportedOperationException("getModalityName method is not defined in Authority Modality definition level.");
    }

    /**
     * Return policy modality type
     * @return Policy modality type
     */
    @Override
    public ModalityType getModalityType() {
        return ModalityType.Authority;
    }
}
