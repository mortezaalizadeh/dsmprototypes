/**
 * @author Morteza Alizadeh
 */
package dsm.common.repository;

import dsm.common.DSMManifest;
import dsm.common.file.DSMFileHelper;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
        DSMFileHelper dsmFileHelper = new DSMFileHelper();
        String szRepositoryFileContent = dsmFileHelper.readEntireTextFileContent(szRepositoryFilePath);
        
        loadRepositoryFromStringContent(szRepositoryFileContent);
   }

    /**
     * Loads repository information from passed string content.
     * 
     * @param szStringContent String content
     */
    public void loadRepositoryFromStringContent(String szStringContent) throws Exception {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setValidating(true);
            
            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            
            reader.setErrorHandler(new RepositoryParserSAXErrorHandler());
            reader.setContentHandler(new RepositoryParserSAXContentHandler());
            reader.parse(szStringContent);
        } finally {
        }
    }
}
