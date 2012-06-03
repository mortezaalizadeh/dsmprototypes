/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.dsmdaemon;

import dsm.common.DSMManifest;
import dsm.daemon.common.Daemon;

/**
 * DSMDaemon is a test daemon bringing up test modules during tests.
 * 
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public class DSMDaemon extends DSMManifest implements Daemon {
    
    /**
     * Daemon name
     */
    private String daemonName = "DSM Daemon";

    /**
     * Daemon initialization state
     */
    private boolean inited = false;

    /**
     * DSMDaemon Constructor
     */
    public DSMDaemon() {
        super("efae8bdb-2647-45e6-803e-c7ff2976a3e6", "DSM Daemon");
    }

    /**
     * Returns daemon name.
     * 
     * @return Daemon name
     */
    @Override
    public String getDaemonName() {
        return this.daemonName;
    }

    /**
     * Returns whether daemon is initialized.
     * 
     * @return Daemon initialization status
     */
    @Override
    public boolean isInited() {
        return this.inited;
    }

    /**
     * Initializes daemon.
     * 
     * @param initializationParams Contains initializations parameters
     */
    @Override
    public void init(String initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown daemon.
     */
    @Override
    public void shutdown() {
        this.inited = false;
    }
}