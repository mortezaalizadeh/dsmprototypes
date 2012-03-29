/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMManifest;

/**
 * ImperativalModality abstract class provides basic operations and attributes
 * to all obligation modality classes.
 * 
 * This class must be inherited by all obligation modality classes in order to
 * use standardized operations and attributes for them.
 * 
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public abstract class ObligationModality extends DSMManifest implements Modality {

    /**
     * Modality name
     */
    protected String modalityName = "No name specified yet!!!";

    /**
     * Modality type
     */
    protected ModalityType modalityType = ModalityType.Obligation;

    /**
     * ImperativalModality Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szModalityName Modality name
     */
    public ObligationModality(String szUniqueId, String szFriendlyName, String szModalityName) {
        super(szUniqueId, szFriendlyName);

        modalityName = szModalityName;
    }

    /**
     * Returns modality name.
     * 
     * @return Modality name
     */
    @Override
    public String getModalityName() {
        return modalityName;
    }

    /**
     * Returns modality type.
     * 
     * @return Modality type
     */
    @Override
    public ModalityType getModalityType() {
        return modalityType;
    }
}
