/**
 * @author Morteza Alizadeh
 */
package dsm.basic.implementations;

import com.google.inject.AbstractModule;
import dsm.basic.implementations.argument.BasicArgumentContainer;
import dsm.basic.implementations.daemon.common.BasicDaemonStartupInfo;
import dsm.common.argument.ArgumentContainer;
import dsm.daemon.common.DaemonStartupInfo;

/**
 * BasicGuiceInjectorModule class defines interfaces and implementations
 * associations for the basic implementation project.
 *
 * @version 0.1, November 16, 2012
 * @author Morteza Alizadeh
 */
public class BasicGuiceInjectorModule extends AbstractModule {
    /**
     * Configures a Binder via the exposed methods.
     */
    protected final void configure() {
        bind(ArgumentContainer.class).to(BasicArgumentContainer.class);
        bind(DaemonStartupInfo.class).to(BasicDaemonStartupInfo.class);
    }
}
