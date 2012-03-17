/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMManifest;
import java.util.UUID;

/**
 * AuthorityModality abstract class provides basic operations and
 * attributes to authority modality classes.
 * 
 * This class must be inherited by all authority modality classes in order to
 * use standardized operations and attributes for it.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class AuthorityModality extends DSMManifest implements Modality {

    /**
     * AuthorityModality Constructor
     * @param  nUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     */
    public AuthorityModality(UUID nUniqueId, String szFriendlyName) {
        super(nUniqueId, szFriendlyName);
    }

    /**
     * AuthorityModality Constructor
     * @param  szUniqueId DSM object unique identifier
     * @param  szFriendlyName DSM object friendly name
     */
    public AuthorityModality(String szUniqueId, String szFriendlyName) {
        super(szUniqueId, szFriendlyName);
    }

    /**
     * Returns policy modality friendly name.
     * @return Policy modality friendly name
     */
    @Override
    public String getModalityName() {
        throw new UnsupportedOperationException("getModalityName method is not defined in Authority Modality definition level.");
    }

    /**
     * Returns policy modality type.
     * @return Policy modality type
     */
    @Override
    public ModalityType getModalityType() {
        return ModalityType.Authority;
    }
}
