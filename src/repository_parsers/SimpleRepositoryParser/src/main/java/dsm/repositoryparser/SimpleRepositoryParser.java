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
import java.util.Map;
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
public final class SimpleRepositoryParser extends DsmManifest implements RepositoryParser {

    /**
     * Repository list.
     */
    private final transient Map<String, RepositoryInfo> repositoryList = new HashMap<String, RepositoryInfo>();

    /**
     * RepositoryParser Constructor.
     */
    public SimpleRepositoryParser() {
        super("f239604f-bf65-4d05-9ef1-2a34c8e6411a", "Simple Repository Parser");
    }

    /**
     * Loads repository information from an repository file.
     *
     * @param repositoryFilePath Repository file path
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     */
    public void loadRepositoryFromFile(final String repositoryFilePath,
                                       final boolean loadStartupRepositories,
                                       final boolean loadNoneStartupRepositories) {
        if (repositoryFilePath == null) {
            throw new IllegalArgumentException("repositoryFilePath");
        }

        if (repositoryFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException("repositoryFilePath");
        }

        loadRepository(new InputSource(repositoryFilePath),
                       loadStartupRepositories,
                       loadNoneStartupRepositories);
   }

    /**
     * Loads repository information from passed string content.
     *
     * @param content Content
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     */
    public void loadRepository(final String content,
                               final boolean loadStartupRepositories,
                               final boolean loadNoneStartupRepositories) {
        if (content == null) {
            throw new IllegalArgumentException("content");
        }

        if (content.trim().isEmpty()) {
            throw new IllegalArgumentException("content");
        }

        loadRepository(new InputSource(new StringReader(content)),
                    loadStartupRepositories,
                    loadNoneStartupRepositories);
    }

    /**
     * Loads repository information from passed string content.
     *
     * @param inputSource Input source contains XML message
     * @param loadStartupRepositories Determines whether startup repositories should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup repositories should be loaded
     */
    public void loadRepository(final InputSource inputSource,
                               final boolean loadStartupRepositories,
                               final boolean loadNoneStartupRepositories) {
        try {
            if (inputSource == null) {
                throw new IllegalArgumentException("inputSource");
            }

            final SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setValidating(false);

            final SAXParser parser = spf.newSAXParser();
            final XMLReader reader = parser.getXMLReader();

            reader.setErrorHandler(new RepositoryParserSAXErrorHandler(this));
            reader.setContentHandler(new RepositoryParserSAXContentHandler(this,
                                                                           loadStartupRepositories,
                                                                           loadNoneStartupRepositories));
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
    public void addParsedRepositoryInfo(final RepositoryInfo repositoryInfo) {
        if (repositoryInfo == null) {
            throw new IllegalArgumentException("repositoryInfo");
        }

        this.repositoryList.put(repositoryInfo.getUniqueIdentifier(), repositoryInfo);
    }
}
