/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.repositoryparser;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.basicimplementations.BasicGuiceInjectorModule;
import dsm.daemon.common.DaemonStartupInfo;
import dsm.repository.common.RepositoryInfo;
import dsm.repositoryparser.exceptions.common.RepositoryFileParsingException;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * BasicRepositoryParserSAXContentHandler class implements required method to
 * read XML file attributes and elements.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class BasicRepositoryParserSAXContentHandler implements ContentHandler {

    /**
     * Error message in case of repository parsing failure occurs.
     */
    private static final String FAILED_TO_PARSE_REPOSITORY_MESSAGE =
            "Failed to parse Repository XML file. It contains wrong tags.";

    /**
     * Name tag.
     */
    private static final String NAME_TAG = "name";

    /**
     * Library tag.
     */
    private static final String LIBRARY_TAG = "library";

    /**
     * Package name tag.
     */
    private static final String PACKAGE_NAME_TAG = "package_name";

    /**
     * Class name tag.
     */
    private static final String CLASS_NAME_TAG = "class_name";

    /**
     * Configuration file full path tag.
     */
    private static final String CONFIGURATION_FILE_FULL_PATH_TAG = "configuration_file_full_path";

    /**
     * Reference to dependency injector.
     */
    private static Injector dependecyInjector = Guice.createInjector(
            new BasicGuiceInjectorModule());

    /**
     * Set of RepositoryInfoParserListener.
     */
    private final transient Set<RepositoryInfoParserListener> repositoryInfoParserListeners;

    /**
     * Determines whether startup repositories should be loaded.
     */
    private transient boolean loadStartupRepositories = false;

    /**
     * Determines whether none startup repositories should be loaded.
     */
    private transient boolean loadNoneStartupRepositories = false;

    /**
     * Cached repository info.
     */
    private transient RepositoryInfo cachedRepositoryInfo = null;

    /**
     * Cached repository info validity flag.
     */
    private transient boolean cachedRepositoryInfoValidityFlag = false;

    /**
     * XML Repository parsing depth.
     */
    private transient int parsedDepth = 0;

    /**
     * SAX locator.
     */
    private transient Locator saxLocator = null;

    /**
     * BasicRepositoryParserSAXContentHandler constructor.
     *
     * @param initialLoadStartupRepositories Determines whether startup repositories should be loaded.
     * @param initialLoadNoneStartupRepositories Determines whether none startup repositories should be loaded.
     */
    public BasicRepositoryParserSAXContentHandler(final boolean initialLoadStartupRepositories,
                                                  final boolean initialLoadNoneStartupRepositories) {
        this.repositoryInfoParserListeners = new HashSet<RepositoryInfoParserListener>();

        this.loadStartupRepositories = initialLoadStartupRepositories;
        this.loadNoneStartupRepositories = initialLoadNoneStartupRepositories;
    }

    /**
     * Add the listener to the list of current listeners.
     *
     * @param listener Reference to the listener to add
     */
    public void addRepositoryInfoParserListener(final RepositoryInfoParserListener listener) {
        synchronized (this.repositoryInfoParserListeners) {
            this.repositoryInfoParserListeners.add(listener);
        }
    }

    /**
     * Remove the listener from the list of current listeners.
     *
     * @param listener Reference to the listener to remove
     */
    public void removeRepositoryInfoParserListener(final RepositoryInfoParserListener listener) {
        synchronized (this.repositoryInfoParserListeners) {
            this.repositoryInfoParserListeners.remove(listener);
        }
    }

    /**
     * Raise NewRepositoryInfoParsed event.
     *
     * @param repositoryInfoParserEvent Reference to RepositoryInfoParserEvent
     */
    private void fireNewRepositoryInfoParsedEvent(RepositoryInfoParserEvent repositoryInfoParserEvent) {
        synchronized (this.repositoryInfoParserListeners) {
            for (RepositoryInfoParserListener listener : this.repositoryInfoParserListeners) {
                listener.addNewRepositoryInfoParsed(repositoryInfoParserEvent);
            }
        }
    }

    @Override
    public void setDocumentLocator(final Locator locator) {
        this.saxLocator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(final String prefix, final String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(final String prefix) throws SAXException {
    }

    @Override
    public void startElement(final String uri,
                             final String localName,
                             final String qName,
                             final Attributes atts) throws SAXException {
        do {
            if (uri == null) {
                throw new IllegalArgumentException("uri");
            }

            if (localName == null) {
                throw new IllegalArgumentException("localName");
            }

            if (qName == null) {
                throw new IllegalArgumentException("qName");
            }

            final String name = qName.trim();

            if (name.equalsIgnoreCase("repository")) {
                if (this.parsedDepth != 0) {
                    throw new RepositoryFileParsingException(
                            BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
                }

                this.parsedDepth++;

                final RepositoryInfo tmpRepositoryInfo = dependecyInjector.getInstance(RepositoryInfo.class);

                String value;

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"name\" tag is not defined for repository.");
                } else {
                    tmpRepositoryInfo.setName(value.trim());
                }

                value = atts.getValue("unique_identifier");
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"unique_identifier\" tag is not defined for repository.");
                } else {
                    tmpRepositoryInfo.setUniqueIdentifier(value.trim());
                }

                value = atts.getValue("include_in_startup");
                if (value == null) {
                    tmpRepositoryInfo.setIncludeInStartup(false);
                } else {
                    if (value.equalsIgnoreCase("Yes")
                        || value.equalsIgnoreCase("Y")
                        || value.equalsIgnoreCase("True")
                        || value.equalsIgnoreCase("T")) {
                        tmpRepositoryInfo.setIncludeInStartup(true);
                    } else {
                        tmpRepositoryInfo.setIncludeInStartup(false);
                    }
                }

                if (this.loadStartupRepositories && tmpRepositoryInfo.isIncludeInStartup()) {
                    this.cachedRepositoryInfo = tmpRepositoryInfo;
                    this.cachedRepositoryInfoValidityFlag = true;
                } else if (this.loadNoneStartupRepositories && !tmpRepositoryInfo.isIncludeInStartup()) {
                    this.cachedRepositoryInfo = tmpRepositoryInfo;
                    this.cachedRepositoryInfoValidityFlag = true;
                } else {
                    this.cachedRepositoryInfoValidityFlag = false;
                }
            } else if (name.equalsIgnoreCase("daemon")) {
                if (this.parsedDepth != 1) {
                    throw new RepositoryFileParsingException(
                            BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
                }

                this.parsedDepth++;

                if (!this.cachedRepositoryInfoValidityFlag) {
                    break;
                }

                final DaemonStartupInfo info = dependecyInjector.getInstance(DaemonStartupInfo.class);
                String value;

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.NAME_TAG);
                if (value == null) {
                    info.setName("");
                } else {
                    info.setName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.LIBRARY_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"library\" tag is not defined for daemon.");
                } else {
                    info.setLibrary(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.PACKAGE_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"package_name\" tag is not defined for daemon.");
                } else {
                    info.setPackageName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CLASS_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"class_name\" tag is not defined for daemon.");
                } else {
                    info.setClassName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CONFIGURATION_FILE_FULL_PATH_TAG);
                if (value == null) {
                    info.setConfigurationFileFullPath("");
                } else {
                    info.setConfigurationFileFullPath(value.trim());
                }

                this.cachedRepositoryInfo.addDaemonStartupInfo(info);
            } else if (name.equalsIgnoreCase("action_manager")) {
                if (this.parsedDepth != 1) {
                    throw new RepositoryFileParsingException(
                            BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
                }

                this.parsedDepth++;

                if (!this.cachedRepositoryInfoValidityFlag) {
                    break;
                }

                final ActionManagerStartupInfo info = dependecyInjector.getInstance(ActionManagerStartupInfo.class);
                String value;

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.NAME_TAG);
                if (value == null) {
                    info.setName("");
                } else {
                    info.setName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.LIBRARY_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"library\" tag is not defined for action manager.");
                } else {
                    info.setLibrary(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.PACKAGE_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"package_name\" tag is not defined for action manager.");
                } else {
                    info.setPackageName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CLASS_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException(
                            "Error: \"class_name\" tag is not defined for action manager.");
                } else {
                    info.setClassName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CONFIGURATION_FILE_FULL_PATH_TAG);
                if (value == null) {
                    info.setConfigurationFileFullPath("");
                } else {
                    info.setConfigurationFileFullPath(value.trim());
                }

                this.cachedRepositoryInfo.addActionManagerStartupInfo(info);
            } else if (name.equalsIgnoreCase("action")) {
                if (this.parsedDepth != 1) {
                    throw new RepositoryFileParsingException(
                            BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
                }

                this.parsedDepth++;

                if (!this.cachedRepositoryInfoValidityFlag) {
                    break;
                }

                final ActionStartupInfo info = dependecyInjector.getInstance(ActionStartupInfo.class);
                String value;

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.NAME_TAG);
                if (value == null) {
                    info.setName("");
                } else {
                    info.setName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.LIBRARY_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for action.");
                } else {
                    info.setLibrary(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.PACKAGE_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for action.");
                } else {
                    info.setPackageName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CLASS_NAME_TAG);
                if (value == null) {
                    throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for action.");
                } else {
                    info.setClassName(value.trim());
                }

                value = atts.getValue(BasicRepositoryParserSAXContentHandler.CONFIGURATION_FILE_FULL_PATH_TAG);
                if (value == null) {
                    info.setConfigurationFileFullPath("");
                } else {
                    info.setConfigurationFileFullPath(value.trim());
                }

                this.cachedRepositoryInfo.addActionStartupInfo(info);
            }
        } while(false);
    }

    @Override
    public void endElement(final String uri,
                           final String localName,
                           final String qName) throws SAXException {
        if (uri == null) {
            throw new IllegalArgumentException("uri");
        }

        if (localName == null) {
            throw new IllegalArgumentException("localName");
        }

        if (qName == null) {
            throw new IllegalArgumentException("qName");
        }

        final String name = qName.trim();

        if (name.equalsIgnoreCase("repository")) {
            if (this.parsedDepth != 1) {
                throw new RepositoryFileParsingException(
                        BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
            }

            this.parsedDepth--;

            fireNewRepositoryInfoParsedEvent(new RepositoryInfoParserEvent(this.cachedRepositoryInfo));
            this.cachedRepositoryInfo = null;
        } else if (name.equalsIgnoreCase("daemon")) {
            if (this.parsedDepth != 2) {
                throw new RepositoryFileParsingException(
                        BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
            }

            this.parsedDepth--;
        } else if (name.equalsIgnoreCase("action_manager")) {
            if (this.parsedDepth != 2) {
                throw new RepositoryFileParsingException(
                        BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
            }

            this.parsedDepth--;
        } else if (name.equalsIgnoreCase("action")) {
            if (this.parsedDepth != 2) {
                throw new RepositoryFileParsingException(
                        BasicRepositoryParserSAXContentHandler.FAILED_TO_PARSE_REPOSITORY_MESSAGE);
            }

            this.parsedDepth--;
        }
    }

    @Override
    public void characters(final char[] chars, final int start, final int length) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(final char[] chars, final int start, final int length) throws SAXException {
    }

    @Override
    public void processingInstruction(final String target, final String data) throws SAXException {
    }

    @Override
    public void skippedEntity(final String name) throws SAXException {
    }
}
