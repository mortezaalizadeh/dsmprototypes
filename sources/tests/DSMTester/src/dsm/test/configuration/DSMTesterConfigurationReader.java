/**
 * @author Morteza Alizadeh
 */
package dsm.test.configuration;

import dsm.common.DSMManifest;
import dsm.common.repositoryparser.RepositoryParserStartupInfo;
import dsm.test.exception.ConfigurationFileParsingException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * DSMTesterConfigurationReader class parses repository file and extract information from
 * it.
 * 
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public class DSMTesterConfigurationReader extends DSMManifest {

    /**
     * Repository file full path list
     */
    private LinkedList<String> repositoryFileFullPathList = null;
    
    /**
     * Repository parser startup information
     */
    private RepositoryParserStartupInfo repositoryParserStartupInfo = null;
    
    /**
     * DSMTesterConfigurationReader Constructor
     */
    public DSMTesterConfigurationReader() {
        super("deb10709-8ac4-4ab7-8d61-beee2168a18f", "DSM Tester Configuration Reader");
    }
    
    /**
     * Loads DSM tester configuration from configuration file.
     * 
     * @param szRepositoryFilePath Repository file path
     */
    public void loadCofigurationFromFile(String szConfigurationFilePath) throws Exception {
        if (szConfigurationFilePath == null)
            throw new NullPointerException("Error: Passed szConfigurationFilePath reference is null.");

        if (szConfigurationFilePath.trim().isEmpty())
            throw new NullPointerException("Error: Passed szConfigurationFilePath length is zero.");

        loadCofiguration(new InputSource(szConfigurationFilePath));
   }

    /**
     * Loads DSM tester configuration from passed string content.
     * 
     * @param szStringContent String content
     */
    public void loadCofiguration(String szStringContent) throws Exception {
        if (szStringContent == null)
            throw new NullPointerException("Error: Passed szStringContent reference is null.");

        if (szStringContent.trim().isEmpty())
            throw new NullPointerException("Error: Passed szStringContent length is zero.");

        loadCofiguration(new InputSource(new StringReader(szStringContent)));
    }

    /**
     * Loads DSM tester configuration from passed string content.
     * 
     * @param inputSource Input source contains XML message
     */
    public void loadCofiguration(InputSource inputSource) throws Exception {
        try {
            if (inputSource == null)
                throw new NullPointerException("Error: Passed inputSource reference is null.");

            SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setValidating(false);

            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            reader.setErrorHandler(new ConfigurationFileParserSAXErrorHandler(this));
            reader.setContentHandler(new ConfigurationFileParserSAXContentHandler(this));

            if (this.repositoryFileFullPathList == null)
                this.repositoryFileFullPathList = new LinkedList<String>();
            else
                this.repositoryFileFullPathList.clear();
            
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
     * @param szRepositoryFileFullPath New repository file full path
     */
    public void addRepositoryFileFullPath(String szRepositoryFileFullPath)
    {
        if (szRepositoryFileFullPath == null)
            throw new NullPointerException("Error: Passed szRepositoryFileFullPath reference is null.");
        
        szRepositoryFileFullPath = szRepositoryFileFullPath.trim();
        
        if (szRepositoryFileFullPath.isEmpty())
            throw new NullPointerException("Error: Passed szRepositoryFileFullPath is empty.");

        this.repositoryFileFullPathList.add(szRepositoryFileFullPath);
    }
    
}
