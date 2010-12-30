package com.soebes.cli.cli_test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.beust.jcommander.ParameterException;

/**
 * Testing the parameters for the search command.
 */
public class MergeCommandTest {

    @Test(expectedExceptions = {ParameterException.class})
    public void mergeCommandFailCauseOfMissingDestinationTest() {
        String[] args = {"merge"};
        SupoSECLI cli = new SupoSECLI(args);
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(true, cli.isMergeCommand());
    }

    @Test(expectedExceptions = {ParameterException.class})
    public void mergeCommandWithIndexFailCauseOfMissingDestinationTest() {
        String[] args = {"merge", "-I", "index-1"};
        SupoSECLI cli = new SupoSECLI(args);
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(true, cli.isMergeCommand());
    }

    @Test(expectedExceptions = {ParameterException.class})
    public void mergeCommandFailedCauseOfMissingIndexOptionTest() {
        String[] args = {"merge", "-D", "destination-index"};
        SupoSECLI cli = new SupoSECLI(args);
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(true, cli.isMergeCommand());
        
        Assert.assertEquals(1, cli.getMergeCommand().getIndexes().size());
    }

    @Test
    public void mergeCommandWithCorrectOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index"};
        SupoSECLI cli = new SupoSECLI(args);
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(true, cli.isMergeCommand());

        Assert.assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        Assert.assertEquals(1, cli.getMergeCommand().getIndexes().size());
        Assert.assertEquals("source-index", cli.getMergeCommand().getIndexes().get(0).getName());
    }

    @Test
    public void mergeCommandWithMultipleSourceIndexesOptionsTest() {
        String[] args = {"merge", "-D", "destination-index", "-I", "source-index-1", "-I", "source-index-2"};
        SupoSECLI cli = new SupoSECLI(args);
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(true, cli.isMergeCommand());

        Assert.assertEquals("destination-index", cli.getMergeCommand().getDestinationIndex().getName());

        Assert.assertEquals(2, cli.getMergeCommand().getIndexes().size());
        Assert.assertEquals("source-index-1", cli.getMergeCommand().getIndexes().get(0).getName());
        Assert.assertEquals("source-index-2", cli.getMergeCommand().getIndexes().get(1).getName());
    }
}
