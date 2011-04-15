package com.soebes.cli.cli_test;

import com.beust.jcommander.Parameter;

public class BaseCommand {
    @Parameter(names = {"--help", "-help", "-?", "-h"}, description = "Get help for the particular command.")
    private boolean help;


    public boolean isHelp() {
        return help;
    }

}
