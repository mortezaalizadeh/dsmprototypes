/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMObject;
import java.util.UUID;

/**
 * ImperativalModality abstract class provides basic operations and
 * attributes to Imperatival Modality classes.
 * 
 * This class must be inherited by all Imperatival Modality classes in order to
 * use standardized operations and attributes for it.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class ImperativalModality extends DSMObject implements Modality{
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
     * Returns policy modality friendly name.
     * @return Policy modality name
     */
    @Override
    public String getModalityName() {
        throw new UnsupportedOperationException("getModalityName method is not defined in Imperatival Modality definition level.");
    }

    /**
     * Returns policy modality type.
     * @return Policy modality type
     */
    @Override
    public ModalityType getModalityType() {
        return ModalityType.Imperatival;
    }
}
