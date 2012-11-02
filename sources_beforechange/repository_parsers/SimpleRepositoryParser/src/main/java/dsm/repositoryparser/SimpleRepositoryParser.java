/**
 * @author Morteza Alizadeh
 */
package dsm.repositoryparser;

import dsm.common.DsmManifest;
import dsm.common.repository.RepositoryInfo;
import dsm.common.repositoryparser.RepositoryParser;
import dsm.common.repositoryparser.exceptions.RepositoryFileParsingException;
import java.io.StringReader;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * SimpleRepositoryParser class parses repository file and extract information from
 * it.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class SimpleRepositoryParser extends DsmManifest implements RepositoryParser {

    /**
     * Repository list
     */
    private HashMap<String, RepositoryInfo> repositoryList = null;
    
    /**
     * RepositoryParser Constructor
     */
    public SimpleRepositoryParser() {
        super("f239604f-bf65-4d05-9ef1-2a34c8e6411a", "Simple Repository Parser");
    }
    
    /**
     * Loads repository information from an repository file.
     * 
     * @param szRepositoryFilePath Repository file path
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    @Override
    public void loadRepositoryFromFile(String szRepositoryFilePath,
                                       boolean bLoadStartupRepositories,
                                       boolean bLoadNoneStartupRepositories) throws Exception {
        if (szRepositoryFilePath == null)
            throw new NullPointerException("Error: Passed szRepositoryFilePath reference is null.");

        if (szRepositoryFilePath.trim().isEmpty())
            throw new NullPointerException("Error: Passed szRepositoryFilePath length is zero.");

        loadRepository(new InputSource(szRepositoryFilePath),
                       bLoadStartupRepositories,
                       bLoadNoneStartupRepositories);
   }

    /**
     * Loads repository information from passed string content.
     * 
     * @param szStringContent String content
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    @Override
    public void loadRepository(String szStringContent,
                               boolean bLoadStartupRepositories,
                               boolean bLoadNoneStartupRepositories) throws Exception {
        if (szStringContent == null)
            throw new NullPointerException("Error: Passed szStringContent reference is null.");

        if (szStringContent.trim().isEmpty())
            throw new NullPointerException("Error: Passed szStringContent length is zero.");

        loadRepository(new InputSource(new StringReader(szStringContent)),
                       bLoadStartupRepositories,
                       bLoadNoneStartupRepositories);
    }

    /**
     * Loads repository information from passed string content.
     * 
     * @param inputSource Input source contains XML message
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    @Override
    public void loadRepository(InputSource inputSource,
                               boolean bLoadStartupRepositories,
                               boolean bLoadNoneStartupRepositories) throws Exception {
        try {
            if (inputSource == null)
                throw new NullPointerException("Error: Passed inputSource reference is null.");

            SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setValidating(false);

            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            reader.setErrorHandler(new RepositoryParserSAXErrorHandler(this));
            reader.setContentHandler(new RepositoryParserSAXContentHandler(this,
                                                                           bLoadStartupRepositories,
                                                                           bLoadNoneStartupRepositories));

            if (this.repositoryList == null)
                this.repositoryList = new HashMap<String, RepositoryInfo>();
            else
                this.repositoryList.clear();
            
            reader.parse(inputSource);
        } catch (RepositoryFileParsingException e) {
            this.repositoryList.clear();

            throw e;
        } catch (Exception e) {
            this.repositoryList.clear();

            throw new RepositoryFileParsingException(e.getMessage(), e);
        }
    }
    
    /**
     * Adds new repository info to list of repositories.
     * 
     * @param repositoryInfo new repository info to add
     */
    public void addParsedRepositoryInfo(RepositoryInfo repositoryInfo)
    {
        if (repositoryInfo == null)
            throw new NullPointerException("Error: Passed repositoryInfo reference is null.");
        
        this.repositoryList.put(repositoryInfo.getUniqueIdentifier(), repositoryInfo);
    }
}
