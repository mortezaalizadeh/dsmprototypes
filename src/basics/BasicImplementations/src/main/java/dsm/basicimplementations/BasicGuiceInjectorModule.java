/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations;

import com.google.inject.AbstractModule;
import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.basicimplementations.action.common.BasicActionStartupInfo;
import dsm.basicimplementations.action.manager.common.BasicActionManagerStartupInfo;
import dsm.basicimplementations.common.argument.BasicArgumentContainer;
import dsm.basicimplementations.daemon.common.BasicDaemonStartupInfo;
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
    protected void configure() {
        bind(ActionStartupInfo.class).to(BasicActionStartupInfo.class);
        bind(ActionManagerStartupInfo.class).to(BasicActionManagerStartupInfo.class);
        bind(ArgumentContainer.class).to(BasicArgumentContainer.class);
        bind(DaemonStartupInfo.class).to(BasicDaemonStartupInfo.class);
    }
}
