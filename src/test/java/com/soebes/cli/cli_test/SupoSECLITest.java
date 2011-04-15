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
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getMainCommand().isHelp());


//        StringBuilder help = new StringBuilder();
        cli.getCommander().usage();
//        System.out.println(help);
    }
}
