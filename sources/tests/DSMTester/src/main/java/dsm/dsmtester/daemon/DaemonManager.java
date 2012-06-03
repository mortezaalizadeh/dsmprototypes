/**
 * @author Morteza Alizadeh
 */
package dsm.dsmtester.daemon;

import dsm.common.DSMManifest;
import dsm.dsmtester.configuration.ConfigurationReader;

/**
 * DaemonManager class launches daemons, manages their life cycle and keep track
 * of them.
 * 
 * @version 0.1, May 23, 2012
 * @author Morteza Alizadeh
 */
public class DaemonManager extends DSMManifest {

    /**
     * Singleton object of DaemonManager class.
     */
    private static DaemonManager singletonObject = null;
    
    /**
     * Daemon manager initialization state
     */
    private boolean inited = false;

    /**
     * Configuration reader
     */
    private ConfigurationReader configurationReader = null;
    
    /**
     * DaemonManager Constructor
     */
    protected DaemonManager() {
        super("e5dfde74-782e-4fce-97d9-33e94bc5baa5", "Daemon Manager");
    }

    /**
     * Returns reference to singleton object of DaemonManager class.
     * 
     * @return Reference to singleton object of DaemonManager class.
     */
    public static synchronized DaemonManager getSingletonObject() {
        if (singletonObject == null)
            singletonObject = new DaemonManager();

        return singletonObject;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
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
     * 
     * @param initializationParams Contains initializations parameters
     */
    public void init(String initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown daemon manager.
     */
    public void shutdown() {
        this.inited = false;
    }
}