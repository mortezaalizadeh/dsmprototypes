package dsm.policy.representation.modality.common;

import java.util.UUID;

/**
 * Abstract class to define general imperatival modality behavior
 * @author Morteza Alizadeh
 */
public abstract class ImperativalModality extends Modality{
    /**
     * ImperativalModality Constructor
     * @param  nUniqueId DSM object unique identifier
     */
    public ImperativalModality(UUID nUniqueId) {
        super(nUniqueId);
    }

    /**
     * ImperativalModality Constructor
     * @param  szUniqueId DSM object unique identifier
     */
    public ImperativalModality(String szUniqueId) {
        super(szUniqueId);
    }
    
    /**
     * Return policy modality friendly name
     * @return Policy modality name
     */
    @Override
    public String getModalityName() {
        throw new UnsupportedOperationException("getModalityName method is not defined in Imperatival Modality definition level.");
    }

    /**
     * Return policy modality type
     * @return Policy modality type
     */
    @Override
    public ModalityType getModalityType() {
        return ModalityType.Imperatival;
    }
}
