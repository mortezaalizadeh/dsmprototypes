/**
 * @author Morteza Alizadeh
 */
package dsm.common.configuration;

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
     * Reads configurations from the file.
     *
     * @param configurationFilePath Path to configuration file
     * @exception IOException throws when this exception occurs
     * @exception SAXException throws when this exception occurs
     * @exception ParserConfigurationException throws when this exception occurs
     */
    void readConfigurationsFromFile(final String configurationFilePath);
}
