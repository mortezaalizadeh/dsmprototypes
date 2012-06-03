/**
 * @author Morteza Alizadeh
 */
package dsm.repositoryparser;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.repository.RepositoryInfo;
import dsm.common.repositoryparser.exceptions.RepositoryFileParsingException;
import dsm.daemon.common.DaemonStartupInfo;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * RepositoryParserSAXContentHandler class implements required method to handle
 * read XML file attributes and elements.
 * 
 * @version 0.1, April 15, 2012
 * @author Morteza Alizadeh
 */
public class RepositoryParserSAXContentHandler implements ContentHandler {

    /**
     * Reference to simple repository parser object
     */
    private SimpleRepositoryParser simpleRepositoryParser;
    
    /**
     * Determines whether startup repositories should be loaded.
     */
    private boolean loadStartupRepositories = false;

    /**
     * Determines whether none startup repositories should be loaded.
     */
    private boolean loadNoneStartupRepositories = false;

    /**
     * Cached repository info
     */
    private RepositoryInfo cachedRepositoryInfo;
    
    /**
     * XML Repository parsing depth
     */
    private int parsedDepth;

    /**
     * SAX locator
     */
    private Locator saxLocator = null;
    
    /**
     * RepositoryParserSAXContentHandler constructor
     * 
     * @param refRepositoryParser Reference to simple repository parser object
     * @param bLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param bLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    public RepositoryParserSAXContentHandler(SimpleRepositoryParser refSimpleRepositoryParser,
                                             boolean bLoadStartupRepositories,
                                             boolean bLoadNoneStartupRepositories) {
        if (refSimpleRepositoryParser == null)
            throw new NullPointerException("Error: Passed refSimpleRepositoryParser reference is null.");

        this.simpleRepositoryParser = refSimpleRepositoryParser;
        this.loadStartupRepositories = bLoadStartupRepositories;
        this.loadNoneStartupRepositories = bLoadNoneStartupRepositories;
        this.cachedRepositoryInfo = null;
        this.parsedDepth = 0;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        this.saxLocator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (uri == null)
            throw new NullPointerException("Error: Passed uri reference is null.");

        if (localName == null)
            throw new NullPointerException("Error: Passed localName reference is null.");

        if (qName == null)
            throw new NullPointerException("Error: Passed qName reference is null.");

        qName = qName.trim();

        if (qName.equalsIgnoreCase("repository")) {
            if (this.parsedDepth != 0)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            RepositoryInfo tmpRepositoryInfo = new RepositoryInfo();
            
            String value;

            if ((value = atts.getValue("name")) == null)
                throw new RepositoryFileParsingException("Error: \"name\" tag is not defined for repository.");
            else
                tmpRepositoryInfo.setName(value.trim());

            if ((value = atts.getValue("unique_identifier")) == null)
                throw new RepositoryFileParsingException("Error: \"unique_identifier\" tag is not defined for repository.");
            else
                tmpRepositoryInfo.setUniqueIdentifier(value.trim());

            if ((value = atts.getValue("include_in_startup")) == null)
                tmpRepositoryInfo.setIncludeInStartup(false);
            else {
                if (value.equalsIgnoreCase("Yes") || value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("True") || value.equalsIgnoreCase("T"))
                    tmpRepositoryInfo.setIncludeInStartup(true);
                else
                    tmpRepositoryInfo.setIncludeInStartup(false);
            }

            if(this.loadStartupRepositories && tmpRepositoryInfo.getIncludeInStartup())
                this.cachedRepositoryInfo = tmpRepositoryInfo;
            else if(this.loadNoneStartupRepositories && !tmpRepositoryInfo.getIncludeInStartup())
                this.cachedRepositoryInfo = tmpRepositoryInfo;
            else
                this.cachedRepositoryInfo = null;
        } else if (qName.equalsIgnoreCase("daemon")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            if(this.cachedRepositoryInfo == null)
                return;
            
            DaemonStartupInfo info = new DaemonStartupInfo();
            String value;
            
            if ((value = atts.getValue("name")) == null) {
                info.setName("");
            } else {
                info.setName(value.trim());
            }

            if ((value = atts.getValue("library")) == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for daemon.");
            } else {
                info.setLibrary(value.trim());
            }

            if ((value = atts.getValue("package_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for daemon.");
            } else {
                info.setPackageName(value.trim());
            }

             if ((value = atts.getValue("class_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for daemon.");
            } else {
                info.setClassName(value.trim());
            }

            if ((value = atts.getValue("configuration_file_full_path")) == null) {
                info.setConfigurationFileFullPath("");
            } else {
                info.setConfigurationFileFullPath(value.trim());
            }
            
            this.cachedRepositoryInfo.addDaemon(info);
        } else if (qName.equalsIgnoreCase("action_manager")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            if(this.cachedRepositoryInfo == null)
                return;

            ActionManagerStartupInfo info = new ActionManagerStartupInfo();
            String value;
            
            if ((value = atts.getValue("name")) == null) {
                info.setName("");
            } else {
                info.setName(value.trim());
            }

            if ((value = atts.getValue("library")) == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for action manager.");
            } else {
                info.setLibrary(value.trim());
            }

            if ((value = atts.getValue("package_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for action manager.");
            } else {
                info.setPackageName(value.trim());
            }

             if ((value = atts.getValue("class_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for action manager.");
            } else {
                info.setClassName(value.trim());
            }

            if ((value = atts.getValue("configuration_file_full_path")) == null) {
                info.setConfigurationFileFullPath("");
            } else {
                info.setConfigurationFileFullPath(value.trim());
            }
            
            this.cachedRepositoryInfo.addActionManager(info);
        } else if (qName.equalsIgnoreCase("action")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth++;

            if(this.cachedRepositoryInfo == null)
                return;

            ActionStartupInfo info = new ActionStartupInfo();
            String value;
            
            if ((value = atts.getValue("name")) == null) {
                info.setName("");
            } else {
                info.setName(value.trim());
            }

            if ((value = atts.getValue("library")) == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for action.");
            } else {
                info.setLibrary(value.trim());
            }

            if ((value = atts.getValue("package_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for action.");
            } else {
                info.setPackageName(value.trim());
            }

             if ((value = atts.getValue("class_name")) == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for action.");
            } else {
                info.setClassName(value.trim());
            }

            if ((value = atts.getValue("configuration_file_full_path")) == null) {
                info.setConfigurationFileFullPath("");
            } else {
                info.setConfigurationFileFullPath(value.trim());
            }
            
            this.cachedRepositoryInfo.addAction(info);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (uri == null)
            throw new NullPointerException("Error: Passed uri reference is null.");
            
        if (localName == null)
            throw new NullPointerException("Error: Passed localName reference is null.");
        
        if (qName == null)
            throw new NullPointerException("Error: Passed qName reference is null.");
        
        qName = qName.trim();
        
        if (qName.equalsIgnoreCase("repository")) {
            if (this.parsedDepth != 1)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;

            if (this.simpleRepositoryParser != null) {
                this.simpleRepositoryParser.addParsedRepositoryInfo(this.cachedRepositoryInfo);
                this.cachedRepositoryInfo = null;
            }

        } else if (qName.equalsIgnoreCase("daemon")) {
            if (this.parsedDepth != 2)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        } else if (qName.equalsIgnoreCase("action_manager")) {
            if (this.parsedDepth != 2)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        } else if (qName.equalsIgnoreCase("action")) {
            if (this.parsedDepth != 2)
                throw new RepositoryFileParsingException("Error: Failed to parse Repository XML file. It contains wrong tags.");

            this.parsedDepth--;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }
}
