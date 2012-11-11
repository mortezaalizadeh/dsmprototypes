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
    private String dsmUniqueIdentifier = "00000000-0000-0000-0000-000000000000";

    /**
     * Dsm object friendly name.
     */
    private String dsmFriendlyName = "No friendly name specified yet!!!";

    /**
     * DsmManifest Constructor.
     */
    public DsmManifest() {
        super();
    }

    /**
     * DsmManifest Constructor.
     *
     * @param newDsmUniqueIdentifier Dsm object unique identifier
     * @param newDsmFriendlyName Dsm object friendly name
     */
    public DsmManifest(final String newDsmUniqueIdentifier, final String newDsmFriendlyName) {
        this();

        setDsmUniqueIdentifier(newDsmUniqueIdentifier);
        setDsmFriendlyName(newDsmFriendlyName);
    }

    /**
     * Returns Dsm object unique identifier.
     *
     * @return Returns Dsm object unique identifier
     */
    public final String getDsmUniqueIdentifier() {
        return this.dsmUniqueIdentifier;
    }

    /**
     * Sets Dsm object unique identifier.
     *
     * @param newDsmUniqueIdentifier New Dsm object unique identifier
     */
    public final void setDsmUniqueIdentifier(final String newDsmUniqueIdentifier) {
        if (newDsmUniqueIdentifier == null) {
            throw new IllegalArgumentException("newDsmUniqueIdentifier");
        }

        if (newDsmUniqueIdentifier.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("newDsmUniqueIdentifier");
        }

        this.dsmUniqueIdentifier = newDsmUniqueIdentifier;
    }

    /**
     * Returns Dsm object friendly name.
     *
     * @return Returns Dsm object friendly name.
     */
    public final String getDsmFriendlyName() {
        return this.dsmFriendlyName;
    }

    /**
     * Sets Dsm object friendly name.
     *
     * @param newDsmFriendlyName New Dsm object friendly name
     */
    public final void setDsmFriendlyName(final String newDsmFriendlyName) {
        if (newDsmFriendlyName == null) {
            throw new IllegalArgumentException("newDsmFriendlyName");
        }

        if (newDsmFriendlyName.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("newDsmFriendlyName");
        }

        this.dsmFriendlyName = newDsmFriendlyName;
    }
}
