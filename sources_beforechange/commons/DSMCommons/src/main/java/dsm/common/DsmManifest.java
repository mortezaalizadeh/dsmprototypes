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
    protected String dsmUniqueIdentifier = "00000000-0000-0000-0000-000000000000";

    /**
     * Dsm object friendly name.
     */
    protected String dsmFriendlyName = "No name specified yet!!!";

    /**
     * DsmManifest Constructor.
     */
    public DsmManifest() {
        super();
    }

    /**
     * DsmManifest Constructor.
     *
     * @param dsmUniqueIdentifier Dsm object unique identifier.
     */
    public DsmManifest(final String dsmUniqueIdentifier) {
        this();
        
        this.dsmUniqueIdentifier = dsmUniqueIdentifier;
    }

    /**
     * DsmManifest Constructor.
     *
     * @param dsmUniqueIdentifier Dsm object unique identifier.
     * @param friendlyName Dsm object friendly name.
     */
    public DsmManifest(final String dsmUniqueIdentifier, final String dsmFriendlyName) {
        this(dsmUniqueIdentifier);

        this.dsmFriendlyName = dsmFriendlyName;
    }

    /**
     * Returns Dsm object unique identifier.
     *
     * @return Returns Dsm object unique identifier.
     */
    public String getDsmUniqueIdentifier() {
        return this.dsmUniqueIdentifier;
    }

    /**
     * Sets Dsm object unique identifier.
     *
     * @param dsmUniqueIdentifier Refers to Dsm object unique identifier to be set.
     */
    protected void setDsmUniqueIdentifier(final String dsmUniqueIdentifier) {
        this.dsmUniqueIdentifier = dsmUniqueIdentifier;
    }

    /**
     * Returns Dsm object friendly name.
     *
     * @return Returns Dsm object friendly name.
     */
    public String getDsmFriendlyName() {
        return this.dsmFriendlyName;
    }

    /**
     * Sets Dsm object friendly name.
     *
     * @param dsmFriendlyName Refers to Dsm object friendly name to be set.
     */
    protected void setDsmFriendlyName(final String dsmFriendlyName) {
        this.dsmFriendlyName = dsmFriendlyName;
    }
}
