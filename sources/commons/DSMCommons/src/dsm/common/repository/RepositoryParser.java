/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * RepositoryParser class parses repository file and extract information from
 * it.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryParser extends DSMManifest {

    /**
     * Repository list
     */
    private Hashtable<String, RepositoryInfo> repositoryList = null;
    
    /**
     * RepositoryParser Constructor
     */
    public RepositoryParser() {
        super("f239604f-bf65-4d05-9ef1-2a34c8e6411a", "Repository Parser");
    }
    
    /**
     * Loads repository information from an repository file.
     * 
     * @param szRepositoryFilePath Repository file path
     */
    public void loadRepositoryFromFile(String szRepositoryFilePath) throws Exception {
        if (szRepositoryFilePath == null)
            throw new NullPointerException("Error: Passed szRepositoryFilePath reference is null.");

        if (szRepositoryFilePath.trim().isEmpty())
            throw new NullPointerException("Error: Passed szRepositoryFilePath length is zero.");

        loadRepository(new InputSource(szRepositoryFilePath));
   }

    /**
     * Loads repository information from passed string content.
     * 
     * @param szStringContent String content
     */
    public void loadRepository(String szStringContent) throws Exception {
        if (szStringContent == null)
            throw new NullPointerException("Error: Passed szStringContent reference is null.");

        if (szStringContent.trim().isEmpty())
            throw new NullPointerException("Error: Passed szStringContent length is zero.");

        loadRepository(new InputSource(new StringReader(szStringContent)));
    }

    /**
     * Loads repository information from passed string content.
     * 
     * @param inputSource Input source contains XML message
     */
    public void loadRepository(InputSource inputSource) throws Exception {
        if (inputSource == null)
            throw new NullPointerException("Error: Passed inputSource reference is null.");

        SAXParserFactory spf = SAXParserFactory.newInstance();

        spf.setValidating(false);

        SAXParser parser = spf.newSAXParser();
        XMLReader reader = parser.getXMLReader();

        reader.setErrorHandler(new RepositoryParserSAXErrorHandler(this));
        reader.setContentHandler(new RepositoryParserSAXContentHandler(this));
        reader.parse(inputSource);
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
        
        if (this.repositoryList == null)
            this.repositoryList = new Hashtable<String, RepositoryInfo>();
        
        this.repositoryList.put(repositoryInfo.getUniqueIdentifier(), repositoryInfo);
    }
}
