/**
 * @author Morteza Alizadeh
 */
package dsm.common.configuration;

import dsm.common.argument.ArgumentContainer;

/**
 * ConfigurationParser interface defines methods require to implement a
 * configuration parser.
 *
 * This interface must be implemented by all ConfigurationParser implementations.
 *
 * @version 0.1, November 21, 2012
 * @author Morteza Alizadeh
 */
public interface ConfigurationParser {

    /**
     * Reads configurations.
     */
    void readConfigurations(ArgumentContainer configurationParam);
}
