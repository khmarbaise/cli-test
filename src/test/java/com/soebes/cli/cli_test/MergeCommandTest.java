package com.soebes.cli.cli_test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.testng.annotations.Test;

import com.soebes.cli.cli_test.SupoSECommands.SupoSEExistingCommands;

/**
 * Testing the parameters for the search command.
 */
public class MergeCommandTest {

    @Test
    public void mergeCommandFailCauseOfMissingDestinationTest() {
        String[] args = {"merge"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
    }

    @Test
    public void mergeCommandWithIndexFailCauseOfMissingDestinationTest() {
        String[] args = {"merge", "-I", "index-1"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        assertEquals(1, cli.getMergeCommand().getIndexes().size());
        assertEquals("index-1", cli.getMergeCommand().getIndexes().get(0).getName());
    }

    @Test
    public void mergeCommandFailedCauseOfMissingIndexOptionTest() {
        String[] args = {"merge", "-D", "destination-index"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());
        assertEquals(0, cli.getMergeCommand().getIndexes().size());
    }

    @Test
    public void mergeCommandWithCorrectOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        assertEquals(1, cli.getMergeCommand().getIndexes().size());
        assertEquals("source-index", cli.getMergeCommand().getIndexes().get(0).getName());
    }

    @Test
    public void mergeCommandWithMultipleSourceIndexesOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index-1", "-I", "source-index-2"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        assertEquals(2, cli.getMergeCommand().getIndexes().size());
        assertEquals("source-index-1", cli.getMergeCommand().getIndexes().get(0).getName());
        assertEquals("source-index-2", cli.getMergeCommand().getIndexes().get(1).getName());
    }

    @Test
    public void mergeCommandGlobalHelpTest() {
        String[] args = {"--help", "merge"};
        SupoSECommands cli = new SupoSECommands(args);
        assertEquals(true, cli.getMainCommand().isHelp());
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
    }
    @Test
    public void mergeCommandHelpTest() {
        String[] args = { "merge", "--help" };
        SupoSECommands cli = new SupoSECommands(args);
        assertEquals(false, cli.getMainCommand().isHelp());
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
        assertEquals(true, cli.getMergeCommand().isHelp());
    }
}
