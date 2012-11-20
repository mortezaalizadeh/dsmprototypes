/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.dsmdaemon;

import dsm.common.DsmManifest;
import dsm.common.argument.ArgumentContainer;
import dsm.daemon.common.Daemon;

/**
 * DsmDaemon is a test daemon bringing up test modules during tests.
 *
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public class DsmDaemon extends DsmManifest implements Daemon {

    /**
     * Daemon name.
     */
    private static final String DAEMON_NAME = "Dsm Daemon";

    /**
     * Daemon initialization state.
     */
    private transient boolean inited = false;

    /**
     * DsmDaemon Constructor.
     */
    public DsmDaemon() {
        super("efae8bdb-2647-45e6-803e-c7ff2976a3e6", "DSM Daemon");
    }

    /**
     * Returns daemon name.
     *
     * @return Daemon name
     */
    public String getDaemonName() {
        return DsmDaemon.DAEMON_NAME;
    }

    /**
     * Returns whether daemon is initialized.
     *
     * @return Daemon initialization status
     */
    public boolean isInited() {
        return this.inited;
    }

    /**
     * Initializes daemon.
     *
     * @param initializationParams Contains initializations parameters
     */
    public void init(final ArgumentContainer initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown daemon.
     */
    public void shutdown() {
        this.inited = false;
    }
}
