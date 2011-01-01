package com.soebes.cli.cli_test;

import java.net.URL;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * The scan command for command line.
 *
 * @author Karl Heinz Marbaise
 */
@Parameters(separators = "=", commandDescription = "Scan the contents of a repository")
public class ScanCommand {

    @Parameter(names = {"--help", "-help", "-?", "-h"}, description = "Get help for the scan command.")
    private boolean help;

    @Parameter(names = {"--index", "-I"}, description = "Define the name of the index folder.")
    private String indexName;
    @Parameter(names = {"--create", "-c"}, description = "Usually an index will be updated except you have given this option which will result in creating a new index.")
    private boolean createIndex;
    @Parameter(names = {"--username", "-u"}, description = "The username which is used to authenticate against the repository")
    private String username;
    @Parameter(names = {"--password", "-p"}, description = "The password which is used to authenticate against the repository.")
    private String passwort;
    @Parameter(required = true, names = {"--url", "-U"}, description = "Define the URL of the repository which should be scanned.", converter = URLConverter.class)
    private URL url;
    @Parameter(names = {"--fromrev"}, description = "The revision where to start the scanning process", converter = RevisionConverter.class)
    private Long fromRev;
    @Parameter(names = {"--torev"}, description = "The revision to which the scanning process will run.", converter = RevisionConverter.class)
    private Long toRev;

    /**
     * This will define the defaults for the different command line options.
     */
    public ScanCommand() {
        this.fromRev = new Long(1);
        this.toRev = new Long(-1);
        this.indexName = "indexDir.test";
        this.createIndex = false;
        this.url = null;
        this.username = null;
        this.passwort = null;
    }

    public long getFromRev() {
        return fromRev;
    }

    public long getToRev() {
        return toRev;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getIndexName() {
        return indexName;
    }

    public boolean isCreateIndex() {
        return createIndex;
    }

    public URL getUrl() {
        return url;
    }

    public boolean isHelp() {
        return help;
    }

}
