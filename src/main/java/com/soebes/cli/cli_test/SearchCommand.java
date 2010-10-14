package com.soebes.cli.cli_test;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * The search command for command line.
 * 
 * @author Karl Heinz Marbaise
 */
@Parameters(separators = "=", commandDescription = "Query the index of scanned repositories to get answers.")
public class SearchCommand {

    @Parameter(names = {"--index", "-I"}, description = "Define the name of the index folder.")
    private String indexName;

    @Parameter(names = {"--field", "-F"}, description = "Give the name of the fields which should be printed out.", converter = FieldNamesConverter.class)
    private List<FieldNames> fields = new ArrayList<FieldNames>();

    @Parameter(names = { "--query", "-Q" }, description = "Define the query you would like to use for searching in the index.")
    private String query;

    @Parameter(names = { "--xml" }, description = "print out results as XML")
    private boolean xml;

    /**
     * This will define the defaults for the different command line options.
     */
    public SearchCommand() {
        this.indexName = "indexDir.test";
    }

    public String getIndexName() {
        return indexName;
    }

    public List<FieldNames> getFields() {
        return fields;
    }

    public String getQuery () {
        return query;
    }

    public boolean isXML () {
        return xml;
    }
}
