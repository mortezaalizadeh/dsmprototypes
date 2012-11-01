/**
 * @author Morteza Alizadeh
 */
package dsm.dsmtester.configuration;

import dsm.common.DSMManifest;
import dsm.common.repositoryparser.RepositoryParserStartupInfo;
import dsm.dsmtester.exception.ConfigurationFileParsingException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * ConfigurationReader class parses repository file and extract information from
 * it.
 *
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public final class ConfigurationReader extends DSMManifest {

    /**
     * Repository file full path list.
     */
    private transient List<String> repositoryFileFullPathList = null;

    /**
     * Repository parser startup information.
     */
    private transient RepositoryParserStartupInfo repositoryParserStartupInfo = null;

    /**
     * ConfigurationReader Constructor.
     */
    public ConfigurationReader() {
        super("deb10709-8ac4-4ab7-8d61-beee2168a18f", "Configuration Reader");
    }

    /**
     * Loads DSM tester configuration from configuration file.
     *
     * @param configurationFilePath Configuration file path
     */
    public void loadCofigurationFromFile(final String configurationFilePath) {
        if (configurationFilePath == null) {
            throw new IllegalArgumentException("configurationFilePath");
        }

        if (configurationFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException("configurationFilePath");
        }

        loadCofiguration(new InputSource(configurationFilePath));
    }

    /**
     * Loads DSM tester configuration from passed string content.
     *
     * @param stringContent String content
     */
    public void loadCofiguration(final String stringContent) {
        if (stringContent == null) {
            throw new IllegalArgumentException("stringContent");
        }

        if (stringContent.trim().isEmpty()) {
            throw new IllegalArgumentException("stringContent");
        }

        loadCofiguration(new InputSource(new StringReader(stringContent)));
    }

    /**
     * Loads DSM tester configuration from passed string content.
     *
     * @param inputSource Input source contains XML message
     */
    public void loadCofiguration(final InputSource inputSource) {
        try {
            if (inputSource == null) {
                throw new IllegalArgumentException("inputSource");
            }

            final SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setValidating(false);

            final SAXParser parser = spf.newSAXParser();
            final XMLReader reader = parser.getXMLReader();

            reader.setErrorHandler(new ConfigurationFileParserSAXErrorHandler(this));
            reader.setContentHandler(new ConfigurationFileParserSAXContentHandler(this));

            if (this.repositoryFileFullPathList == null) {
                this.repositoryFileFullPathList = new LinkedList<String>();
            } else {
                this.repositoryFileFullPathList.clear();
            }

            reader.parse(inputSource);
        } catch (ConfigurationFileParsingException e) {
            this.repositoryFileFullPathList.clear();

            throw e;
        } catch (Exception e) {
            this.repositoryFileFullPathList.clear();

            throw new ConfigurationFileParsingException(e.getMessage(), e);
        }
    }

    /**
     * Adds new repository file full path to list of repository file full path.
     *
     * @param repositoryFileFullPath New repository file full path
     */
    public void addRepositoryFileFullPath(final String repositoryFileFullPath) {
        if (repositoryFileFullPath == null) {
            throw new IllegalArgumentException("repositoryFileFullPath");
        }

        if (repositoryFileFullPath.trim().isEmpty()) {
            throw new IllegalArgumentException("repositoryFileFullPath");
        }

        this.repositoryFileFullPathList.add(repositoryFileFullPath);
    }

    /**
     * Sets repository parser startup information.
     *
     * @param newRepositoryParserStartupInfo New repository parser startup
     * information.
     */
    public void setRepositoryParserStartupInfo(final RepositoryParserStartupInfo newRepositoryParserStartupInfo) {
        if (newRepositoryParserStartupInfo == null) {
            throw new IllegalArgumentException("newRepositoryParserStartupInfo");
        }

        this.repositoryParserStartupInfo = newRepositoryParserStartupInfo;
    }
}
