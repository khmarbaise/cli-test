package com.soebes.cli.cli_test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=", commandDescription = "Global options")
public class MainCommand {

    @Parameter(names = {"--help", "-help", "-?", "-h"}, description = "Get the global help")
    private boolean help;

    @Parameter(names = { "--version" }, description = "Print out version information")
    private boolean version;

    public boolean isHelp() {
        return help;
    }

    public boolean isVersion() {
        return version;
    }

}
