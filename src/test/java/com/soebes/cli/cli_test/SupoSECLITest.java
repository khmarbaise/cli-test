package com.soebes.cli.cli_test;

import static junit.framework.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SupoSECLITest {

//    @Test
//    public void helpTest() {
//        String[] args = {"--help"};
//        SupoSECommands cli = new SupoSECommands(args);
//        assertTrue(cli.getMainCommand().isHelp());
//        cli.getCommander().usage();
//    }
//
//    @Test
//    public void helpTestWithoutArguments() {
//        String[] args = { };
//        SupoSECommands cli = new SupoSECommands(args);
////        assertTrue(cli.getMainCommand().isHelp());
//        cli.getCommander().usage();
//    }
    
    @Test
    public void testWithoutArgumentsInSupoSECLI() {
        String[] args = { };
        SupoSECLI cli = new SupoSECLI();
        cli.run(args);
    }
}
