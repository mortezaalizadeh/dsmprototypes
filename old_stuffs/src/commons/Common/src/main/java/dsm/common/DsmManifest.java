/**
 * @author Morteza Alizadeh
 */
package dsm.common;

/**
 * DsmManifest class defines basic operations and attributes for all Dsm
 * classes.
 *
 * This class must be inherited by all Dsm classes.
 *
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public class DsmManifest extends Object {

    /**
     * Dsm object unique identifier.
     */
    private String dsmUniqueIdentifier =
            "00000000-0000-0000-0000-000000000000";

    /**
     * Dsm object friendly name.
     */
    private String dsmFriendlyName =
            "No friendly name specified yet!!!";

    /**
     * DsmManifest Constructor.
     */
    public DsmManifest() {
        super();
    }

    /**
     * DsmManifest Constructor.
     *
     * @param newDsmUniqueIdentifier Dsm unique identifier
     * @param newDsmFriendlyName Dsm friendly name
     */
    public DsmManifest(final String newDsmUniqueIdentifier, final String newDsmFriendlyName) {
        this();

        setDsmUniqueIdentifierInternal(newDsmUniqueIdentifier);
        setDsmFriendlyNameInternal(newDsmFriendlyName);
    }

    /**
     * Returns Dsm unique identifier.
     *
     * @return Returns Dsm unique identifier
     */
    public String getDsmUniqueIdentifier() {
        return this.dsmUniqueIdentifier;
    }

    /**
     * Sets Dsm unique identifier.
     *
     * @param newDsmUniqueIdentifier New Dsm unique identifier
     */
    public void setDsmUniqueIdentifier(final String newDsmUniqueIdentifier) {
        setDsmUniqueIdentifierInternal(newDsmUniqueIdentifier);
    }

    /**
     * Internal method to set Dsm unique identifier.
     *
     * @param newDsmUniqueIdentifier New Dsm unique identifier
     */
    private void setDsmUniqueIdentifierInternal(final String newDsmUniqueIdentifier) {
        if (newDsmUniqueIdentifier == null) {
            throw new IllegalArgumentException("newDsmUniqueIdentifier");
        }

        if (newDsmUniqueIdentifier.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("newDsmUniqueIdentifier");
        }

        this.dsmUniqueIdentifier = newDsmUniqueIdentifier;
    }

    /**
     * Returns Dsm friendly name.
     *
     * @return Returns Dsm friendly name.
     */
    public String getDsmFriendlyName() {
        return this.dsmFriendlyName;
    }

    /**
     * Sets Dsm friendly name.
     *
     * @param newDsmFriendlyName New Dsm friendly name
     */
    public void setDsmFriendlyName(final String newDsmFriendlyName) {
        setDsmFriendlyNameInternal(newDsmFriendlyName);
    }

    /**
     * Internal method to set Dsm friendly name.
     *
     * @param newDsmFriendlyName New Dsm friendly name
     */
    private void setDsmFriendlyNameInternal(final String newDsmFriendlyName) {
        if (newDsmFriendlyName == null) {
            throw new IllegalArgumentException("newDsmFriendlyName");
        }

        if (newDsmFriendlyName.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("newDsmFriendlyName");
        }

        this.dsmFriendlyName = newDsmFriendlyName;
    }
}
