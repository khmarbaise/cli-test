package com.soebes.cli.cli_test;

import static junit.framework.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SupoSECLITest {

    @Test
    public void helpTest() {
        String[] args = {"--help"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getMainCommand().isHelp());


//        StringBuilder help = new StringBuilder();
        cli.getCommander().usage();
//        System.out.println(help);
    }
}
