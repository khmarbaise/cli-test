package com.soebes.cli.cli_test;

import junit.framework.Assert;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SupoSECLITest {

    @Test
    public void helpTest() {
        String[] args = {"--help"};
        SupoSECLI cli = new SupoSECLI(args);

        Assert.assertEquals(false, cli.isSearchCommand());
        Assert.assertEquals(false, cli.isScanCommand());
        Assert.assertEquals(false, cli.isMergeCommand());
        Assert.assertEquals(true, cli.getMainCommand().isHelp());

//        StringBuilder help = new StringBuilder();
        cli.getCommander().usage();
        cli.getCommander().usage(SupoSECLI.SCAN_COMMAND);
        cli.getCommander().usage(SupoSECLI.SEARCH_COMMAND);
        cli.getCommander().usage(SupoSECLI.MERGE_COMMAND);
//        System.out.println(help);
    }
}
