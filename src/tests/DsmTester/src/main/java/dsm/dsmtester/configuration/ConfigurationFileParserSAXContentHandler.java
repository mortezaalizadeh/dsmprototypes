/**
 * @author Morteza Alizadeh
 */
package dsm.dsmtester.configuration;

import dsm.common.repository.RepositoryInfo;
import dsm.common.repositoryparser.RepositoryParserStartupInfo;
import dsm.common.repositoryparser.exceptions.RepositoryFileParsingException;
import dsm.dsmtester.exception.ConfigurationFileParsingException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * RepositoryParserSAXContentHandler class implements required method to handle
 * read XML file attributes and elements.
 *
 * @version 0.1, May 22, 2012
 * @author Morteza Alizadeh
 */
public final class ConfigurationFileParserSAXContentHandler implements ContentHandler {

    /**
     * Exception message for parsing failure.
     */
    private static final transient String FAILED_TO_PARSE_EXCEPTION_MESSAGE =
            "Error: Failed to parse Repository XML file. It contains wrong tags.";

    /**
     * Configuration tag desired depth.
     */
    private static final transient int CONFIGURATION_TAG_DESIRED_DEPTH = 1;

    /**
     * Repository files desired depth.
     */
    private static final transient int REPOSITORY_FILES_TAG_DESIRED_DEPTH = 2;

    /**
     * Repository file desired depth.
     */
    private static final transient int REPOSITORY_FILE_TAG_DESIRED_DEPTH = 3;

    /**
     * Repository parser desired depth.
     */
    private static final transient int REPOSITORY_PARSER_TAG_DESIRED_DEPTH = 1;

    /**
     * Reference to DSM tester configuration reader object.
     */
    private transient ConfigurationReader dsmTesterConfigurationReader = null;

    /**
     * XML Repository parsing depth.
     */
    private transient int parsedDepth = 0;

    /**
     * SAX locator.
     */
    private transient Locator saxLocator = null;

    /**
     * RepositoryParserSAXContentHandler constructor.
     *
     * @param initialDsmTesterConfigurationReader Reference to Dsm tester configuration reader object
     */
    public ConfigurationFileParserSAXContentHandler(final ConfigurationReader initialDsmTesterConfigurationReader) {
        if (initialDsmTesterConfigurationReader == null) {
            throw new IllegalArgumentException("dsmTesterConfigurationReader");
        }

        this.dsmTesterConfigurationReader = initialDsmTesterConfigurationReader;
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

        if (name.equalsIgnoreCase("configuration")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.CONFIGURATION_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth++;
        } else if (name.equalsIgnoreCase("repository_files")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_FILES_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth++;
        } else if (name.equalsIgnoreCase("repository_file")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_FILE_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth++;

            String value = atts.getValue("repository_file_full_path");

            if (value != null) {
                value = value.trim();

                if (!value.isEmpty()) {
                    this.dsmTesterConfigurationReader.addRepositoryFileFullPath(value);
                }
            }
        } else if (qName.equalsIgnoreCase("repository_parser")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_PARSER_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth++;

            final RepositoryParserStartupInfo repositoryParserStartupInfo = new RepositoryParserStartupInfo();

            String value;

            value = atts.getValue("name");
            if (value == null) {
                repositoryParserStartupInfo.setName("");
            } else {
                repositoryParserStartupInfo.setName(value.trim());
            }

            value = atts.getValue("library");
            if (value == null) {
                throw new RepositoryFileParsingException("Error: \"library\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setLibrary(value.trim());
            }

            value = atts.getValue("package_name");
            if (value == null) {
                throw new RepositoryFileParsingException("Error: \"package_name\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setPackageName(value.trim());
            }

            value = atts.getValue("class_name");
            if (value == null) {
                throw new RepositoryFileParsingException("Error: \"class_name\" tag is not defined for daemon.");
            } else {
                repositoryParserStartupInfo.setClassName(value.trim());
            }

            this.dsmTesterConfigurationReader.setRepositoryParserStartupInfo(repositoryParserStartupInfo);
        }
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

        if (name.equalsIgnoreCase("configuration")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.CONFIGURATION_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth--;
        } else if (name.equalsIgnoreCase("repository_files")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_FILES_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth--;
        } else if (name.equalsIgnoreCase("repository_file")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_FILE_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
            }

            this.parsedDepth--;
        } else if (name.equalsIgnoreCase("repository_parser")) {
            if (this.parsedDepth != ConfigurationFileParserSAXContentHandler.REPOSITORY_PARSER_TAG_DESIRED_DEPTH) {
                throw new ConfigurationFileParsingException(
                        ConfigurationFileParserSAXContentHandler.FAILED_TO_PARSE_EXCEPTION_MESSAGE);
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
