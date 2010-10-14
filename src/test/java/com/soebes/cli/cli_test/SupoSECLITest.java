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

        Assert.assertEquals(cli.isSearchCommand(), false);
        Assert.assertEquals(cli.isScanCommand(), false);
        Assert.assertEquals(cli.getMainCommand().isHelp(), true);

//        StringBuilder help = new StringBuilder();
        cli.getCommander().usage();
        cli.getCommander().usage(SupoSECLI.SCAN_COMMAND);
        cli.getCommander().usage(SupoSECLI.SEARCH_COMMAND);
//        System.out.println(help);
    }
}
