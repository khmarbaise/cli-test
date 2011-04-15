package com.soebes.cli.cli_test;

import junit.framework.Assert;

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
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
    }

    @Test
    public void mergeCommandWithIndexFailCauseOfMissingDestinationTest() {
        String[] args = {"merge", "-I", "index-1"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        Assert.assertEquals(1, cli.getMergeCommand().getIndexes().size());
        Assert.assertEquals("index-1", cli.getMergeCommand().getIndexes().get(0).getName());
    }

    @Test
    public void mergeCommandFailedCauseOfMissingIndexOptionTest() {
        String[] args = {"merge", "-D", "destination-index"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        Assert.assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());
        Assert.assertEquals(0, cli.getMergeCommand().getIndexes().size());
    }

    @Test
    public void mergeCommandWithCorrectOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        Assert.assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        Assert.assertEquals(1, cli.getMergeCommand().getIndexes().size());
        Assert.assertEquals("source-index", cli.getMergeCommand().getIndexes().get(0).getName());
    }

    @Test
    public void mergeCommandWithMultipleSourceIndexesOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index-1", "-I", "source-index-2"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));

        Assert.assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        Assert.assertEquals(2, cli.getMergeCommand().getIndexes().size());
        Assert.assertEquals("source-index-1", cli.getMergeCommand().getIndexes().get(0).getName());
        Assert.assertEquals("source-index-2", cli.getMergeCommand().getIndexes().get(1).getName());
    }

    @Test
    public void mergeCommandGlobalHelpTest() {
        String[] args = {"--help", "merge"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertEquals(true, cli.getMainCommand().isHelp());
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
    }
    @Test
    public void mergeCommandHelpTest() {
        String[] args = { "merge", "--help" };
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertEquals(false, cli.getMainCommand().isHelp());
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.MERGE));
        Assert.assertEquals(true, cli.getMergeCommand().isHelp());
    }
}
