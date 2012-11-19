/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.common;

/**
 * Daemon interface defines general operations and attributes for a daemon.
 *
 * This interface must be implemented by all daemon classes.
 *
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public interface Daemon {

    /**
     * Returns daemon name.
     *
     * @return Daemon name
     */
    String getDaemonName();

    /**
     * Returns whether daemon is initialized.
     *
     * @return Daemon initialization status
     */
    boolean isInited();

    /**
     * Initializes daemon.
     *
     * @param initializationParams Contains initializations parameters
     */
    void init(final String initializationParams);

    /**
     * Shutdown daemon.
     */
    void shutdown();
}
