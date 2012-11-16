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
     * @param dui Dsm unique identifier
     * @param dfn Dsm friendly name
     */
    public DsmManifest(final String dui, final String dfn) {
        this();

        setDsmUniqueIdentifier(dui);
        setDsmFriendlyName(dfn);
    }

    /**
     * Returns Dsm unique identifier.
     *
     * @return Returns Dsm unique identifier
     */
    public final String getDsmUniqueIdentifier() {
        return this.dsmUniqueIdentifier;
    }

    /**
     * Sets Dsm unique identifier.
     *
     * @param dui New Dsm unique identifier
     */
    public final void setDsmUniqueIdentifier(final String dui) {
        if (dui == null) {
            throw new IllegalArgumentException("dui");
        }

        if (dui.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("dui");
        }

        this.dsmUniqueIdentifier = dui;
    }

    /**
     * Returns Dsm friendly name.
     *
     * @return Returns Dsm friendly name.
     */
    public final String getDsmFriendlyName() {
        return this.dsmFriendlyName;
    }

    /**
     * Sets Dsm friendly name.
     *
     * @param dfn New Dsm friendly name
     */
    public final void setDsmFriendlyName(final String dfn) {
        if (dfn == null) {
            throw new IllegalArgumentException("dfn");
        }

        if (dfn.trim().compareTo("") == 0) {
            throw new IllegalArgumentException("dfn");
        }

        this.dsmFriendlyName = dfn;
    }
}
