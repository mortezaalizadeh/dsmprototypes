/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMManifest;
import java.util.UUID;

/**
 * AuthorityModality abstract class provides basic operations and attributes
 * to all authority modality classes.
 * 
 * This class must be inherited by all authority modality classes in order to
 * use standardized operations and attributes for them.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class AuthorityModality extends DSMManifest implements Modality {

    /**
     * Modality type
     */
    protected ModalityType modalityType = ModalityType.Authority;

    /**
     * Modality name
     */
    protected String modalityName = "No name specified yet!!!";

    /**
     * AuthorityModality Constructor
     * @param  nUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     * @param  szModalityName Modality name
     */
    public AuthorityModality(UUID nUniqueId, String szFriendlyName, String szModalityName) {
        super(nUniqueId, szFriendlyName);

        modalityName = szModalityName;
    }

    /**
     * AuthorityModality Constructor
     * @param  szUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     * @param  szModalityName Modality name
     */
    public AuthorityModality(String szUniqueId, String szFriendlyName, String szModalityName) {
        super(szUniqueId, szFriendlyName);
        
        modalityName = szModalityName;
    }

    /**
     * Returns modality name.
     * @return Modality name
     */
    @Override
    public String getModalityName() {
        return modalityName;
    }

    /**
     * Returns modality type.
     * @return Modality type
     */
    @Override
    public ModalityType getModalityType() {
        return modalityType;
    }
}
