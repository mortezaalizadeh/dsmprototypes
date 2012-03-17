/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMManifest;
import java.util.UUID;

/**
 * ImperativalModality abstract class provides basic operations and
 * attributes to imperatival modality classes.
 * 
 * This class must be inherited by all imperatival modality classes in order to
 * use standardized operations and attributes for it.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class ImperativalModality extends DSMManifest implements Modality {

    /**
     * ImperativalModality Constructor
     * @param  nUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     */
    public ImperativalModality(UUID nUniqueId, String szFriendlyName) {
        super(nUniqueId, szFriendlyName);
    }

    /**
     * ImperativalModality Constructor
     * @param  szUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     */
    public ImperativalModality(String szUniqueId, String szFriendlyName) {
        super(szUniqueId, szFriendlyName);
    }

    /**
     * Returns policy modality name.
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
