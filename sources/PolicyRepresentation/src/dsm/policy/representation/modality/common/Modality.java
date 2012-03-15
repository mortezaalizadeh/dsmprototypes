package dsm.policy.representation.modality.common;

import dsm.common.DSMObject;
import java.util.UUID;

/**
 * Abstract class to define general policy modality behavior
 * @author Morteza Alizadeh
 */
public abstract class Modality extends DSMObject implements IModality{
    /**
     * Modality Constructor
     * @param  nUniqueId DSM object unique identifier
     */
    public Modality(UUID nUniqueId) {
        super(nUniqueId);
    }

    /**
     * Modality Constructor
     * @param  szUniqueId DSM object unique identifier
     */
    public Modality(String szUniqueId) {
        super(szUniqueId);
    }

    /**
     * Return policy modality friendly name
     * @return Policy modality name
     */
    @Override
    public String getModalityName() {
        throw new UnsupportedOperationException("getModalityName method is not defined in Modality definition level.");
    }

    /**
     * Return policy modality type
     * @return Policy modality type
     */
    @Override
    public ModalityType getModalityType() {
        throw new UnsupportedOperationException("getModalityType method is not defined in Modality definition level.");
    }
}
