/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repositoryparser;

import dsm.common.DsmManifest;
import dsm.repository.common.RepositoryInfo;
import dsm.repositoryparser.common.RepositoryParser;
import dsm.repositoryparser.exceptions.common.RepositoryFileParsingException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * BasicRepositoryParser class parses repository file and extract information from
 * it.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class BasicRepositoryParser extends DsmManifest
        implements RepositoryParser, RepositoryInfoParserListener {

    /**
     * Repository info list.
     */
    private final transient Map<String, RepositoryInfo> repositoryList = new HashMap<String, RepositoryInfo>();

    /**
     * BasicRepositoryParser Constructor.
     */
    public BasicRepositoryParser() {
        super("f239604f-bf65-4d05-9ef1-2a34c8e6411a", "Basic Repository Parser");
    }

    /**
     * Loads repository information from an repository file.
     *
     * @param repositoryFilePath Repository file path
     * @param loadStartupRepositories Determines whether startup repositories
     * should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup
     * repositories should be loaded
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
     * @param loadStartupRepositories Determines whether startup repositories
     * should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup
     * repositories should be loaded
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
     * @param loadStartupRepositories Determines whether startup repositories
     * should be loaded
     * @param loadNoneStartupRepositories Determines whether none startup
     * repositories should be loaded
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

            final BasicRepositoryParserSAXErrorHandler basicRepositoryParserSAXErrorHandler =
                    new BasicRepositoryParserSAXErrorHandler();

            final BasicRepositoryParserSAXContentHandler basicRepositoryParserSAXContentHandler =
                    new BasicRepositoryParserSAXContentHandler(loadStartupRepositories,
                                                               loadNoneStartupRepositories);

            basicRepositoryParserSAXContentHandler.addRepositoryInfoParserListener(this);

            reader.setErrorHandler(basicRepositoryParserSAXErrorHandler);
            reader.setContentHandler(basicRepositoryParserSAXContentHandler);
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
     * An event occurs when new repository info is parsed.
     *
     * @param repositoryInfoParserEvent Reference to repositoryInfoParserEvent
     */
    public void addNewRepositoryInfoParsed(final RepositoryInfoParserEvent repositoryInfoParserEvent) {
        if (repositoryInfoParserEvent == null) {
            throw new IllegalArgumentException("repositoryInfoParserEvent");
        }

        final RepositoryInfo repositoryInfo = repositoryInfoParserEvent.getRepositoryInfo();

        if (repositoryInfo == null) {
            throw new IllegalArgumentException("repositoryInfo");
        }

        this.repositoryList.put(repositoryInfo.getUniqueIdentifier(), repositoryInfo);
    }
}
