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
    private String dsmFriendlyName = "No name specified yet!!!";

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

        this.dsmUniqueIdentifier = newDsmUniqueIdentifier;
        this.dsmFriendlyName = newDsmFriendlyName;
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
     * @param newDsmUniqueIdentifier Refers to Dsm object unique identifier to
     * be set
     */
    public final void setDsmUniqueIdentifier(final String newDsmUniqueIdentifier) {
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
     * @param newDsmFriendlyName Refers to Dsm object friendly name to be set
     */
    public final void setDsmFriendlyName(final String newDsmFriendlyName) {
        this.dsmFriendlyName = newDsmFriendlyName;
    }
}
