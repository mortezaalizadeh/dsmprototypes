/**
 * @author Morteza Alizadeh
 */
package dsm.dsmtester.daemon;

import dsm.common.DsmManifest;
import dsm.dsmtester.configuration.ConfigurationReader;

/**
 * DaemonManager class launches daemons, manages their life cycle and keep track
 * of them.
 *
 * @version 0.1, May 23, 2012
 * @author Morteza Alizadeh
 */
public final class DaemonManager extends DsmManifest {

    /**
     * Singleton object of DaemonManager class.
     */
    private static DaemonManager singletonObject = null;

    /**
     * Daemon manager initialization state.
     */
    private transient boolean inited = false;

    /**
     * Configuration reader.
     */
    private ConfigurationReader configurationReader = null;

    /**
     * DaemonManager Constructor.
     */
    private DaemonManager() {
        super("e5dfde74-782e-4fce-97d9-33e94bc5baa5", "Daemon Manager");
    }

    /**
     * Returns reference to singleton object of DaemonManager class.
     *
     * @return Reference to singleton object of DaemonManager class.
     */
    public static DaemonManager getSingletonObject() {
        synchronized (DaemonManager.class) {
            if (singletonObject == null) {
                singletonObject = new DaemonManager();
            }
        }

        return singletonObject;
    }

    /**
     * Returns whether daemon manager is initialized.
     *
     * @return Daemon manager initialization status
     */
    public boolean isInited() {
        return this.inited;
    }

    /**
     * Initializes daemon manager.
     * @param initializationParams Contains initializations parameters
     */
    public void init(final String initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown daemon manager.
     */
    public void shutdown() {
        this.inited = false;
    }
}
