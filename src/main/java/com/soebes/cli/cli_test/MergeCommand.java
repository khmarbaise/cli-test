package com.soebes.cli.cli_test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;

/**
 * The merge command for command line.
 *
 * @author Karl Heinz Marbaise
 */
@Parameters(commandDescription = "Merge multiple indexes into a single index.", separators = "=")
public class MergeCommand {
    @Parameter(names = {"--help", "-help", "-?", "-h"}, description = "Get help for the merge command.")
    private boolean help;

    @Parameter(
        names = {"--destination", "-D"},
        description = "The destination index.",
        converter = FileConverter.class,
        required = true
    )
    private File destinationIndex;

    @Parameter(
        names = {"--index", "-I"},
        description = "The indexes you would like to merge into destination.",
        converter = FileConverter.class,
        required = true
    )
    private List<File> indexes = new ArrayList<File>();

    public File getDestinationIndex() {
        return destinationIndex;
    }

    public List<File> getIndexes() {
        return indexes;
    }

    public boolean isHelp() {
        return help;
    }

}
