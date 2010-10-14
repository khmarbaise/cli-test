package com.soebes.cli.cli_test;

import com.beust.jcommander.JCommander;

public class SupoSECLI {

    public static final String SCAN_COMMAND = "scan";
    public static final String SEARCH_COMMAND = "search";
    public static final String MERGE_COMMAND = "merge";

    private MainCommand mainCommand;
    private ScanCommand scanCommand;
    private SearchCommand searchCommand;
    private JCommander commander;

    public SupoSECLI(String[] args) {
        this.mainCommand = new MainCommand();

        this.scanCommand = new ScanCommand();
        this.searchCommand = new SearchCommand();

        this.commander = new JCommander(mainCommand);

        this.commander.addCommand(SCAN_COMMAND, scanCommand);
        this.commander.addCommand(SEARCH_COMMAND, searchCommand);

        this.commander.setProgramName("supose");
        this.commander.parse(args);
    }

    public boolean isScanCommand() {
        if (SCAN_COMMAND.equals(getCommander().getParsedCommand())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSearchCommand() {
        if (SEARCH_COMMAND.equals(getCommander().getParsedCommand())) {
            return true;
        } else {
            return false;
        }
    }

    public JCommander getCommander() {
        return this.commander;
    }

    public MainCommand getMainCommand() {
        return this.mainCommand;
    }

    public ScanCommand getScanCommand() {
        return this.scanCommand;
    }

    public SearchCommand getSearchCommand() {
        return this.searchCommand;
    }
}
