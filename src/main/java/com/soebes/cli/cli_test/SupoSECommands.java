package com.soebes.cli.cli_test;

import java.util.HashMap;
import java.util.Map;

import com.beust.jcommander.JCommander;

public class SupoSECommands {
    public static final String PROGRAMM_NAME = "supose";

    public enum SupoSEExistingCommands {
        SCAN("scan"),
        SEARCH("search"),
        MERGE("merge");

        private String commandName;
        private SupoSEExistingCommands(String commandName) {
            this.commandName = commandName;
        }
        public String getCommandName() {
            return commandName;
        }

    }

    private MainCommand mainCommand;

    private Map<SupoSEExistingCommands, ICommand> commandList = null;

    private JCommander commander;

    public SupoSECommands(String[] args) {
        commandList = new HashMap<SupoSEExistingCommands, ICommand>();

        mainCommand = new MainCommand();

        commandList.put(SupoSEExistingCommands.MERGE, new MergeCommand());
        commandList.put(SupoSEExistingCommands.SCAN, new ScanCommand());
        commandList.put(SupoSEExistingCommands.SEARCH, new SearchCommand());

        commander = new JCommander(mainCommand);

        for (SupoSEExistingCommands item : SupoSEExistingCommands.values()) {
            getCommander().addCommand(item.getCommandName(), commandList.get(item));
        }

        getCommander().setProgramName(PROGRAMM_NAME);
        getCommander().parse(args);
    }

    /**
     * Check to see if for one command a help option is given or not.
     *
     * @return true if a command is given with help option false otherwise.
     */
    public boolean isHelpForCommand() {
        boolean result = false;
        SupoSEExistingCommands command = getCommand();
        ICommand baseCommand = commandList.get(command);
        if (baseCommand == null) {
            result = false;
        } else {
            result = baseCommand.isHelp();
        }
        return result;
    }

    public SupoSEExistingCommands getCommand() {
        SupoSEExistingCommands command = null;
        for (SupoSEExistingCommands item : SupoSEExistingCommands.values()) {
            if (item.getCommandName().equalsIgnoreCase(getCommander().getParsedCommand())) {
                command = item;
            }
        }
        return command;
    }

    public JCommander getCommander() {
        return this.commander;
    }

    public MainCommand getMainCommand() {
        return this.mainCommand;
    }

    public MergeCommand getMergeCommand() {
        return (MergeCommand) commandList.get(SupoSEExistingCommands.MERGE);
    }

    public ScanCommand getScanCommand() {
        return (ScanCommand) commandList.get(SupoSEExistingCommands.SCAN);
    }

    public SearchCommand getSearchCommand() {
        return (SearchCommand) commandList.get(SupoSEExistingCommands.SEARCH);
    }
}
