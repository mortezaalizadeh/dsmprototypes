/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

import dsm.common.DSMObject;
import java.util.UUID;

/**
 * AuthorityModality abstract class provides basic operations and
 * attributes to Authority Modality classes.
 * This class must be inherited by all Authority Modality classes in order to
 * use standardized operations and attributes for it.
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public abstract class AuthorityModality extends DSMObject implements Modality{
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
     * Returns policy modality friendly name.
     * @return Policy modality name
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
