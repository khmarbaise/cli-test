package com.soebes.cli.cli_test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import com.beust.jcommander.ParameterException;
import com.soebes.cli.cli_test.SupoSECommands.SupoSEExistingCommands;

/**
 * Testing the parameters for the scan command.
 */
public class ScanCommandTest {

    /**
     * This must produce an exception, cause the --url
     * parameter is defined as required for the scan command.
     * @throws MalformedURLException
     */
    @Test(expectedExceptions = {ParameterException.class})
    public void scanCommandMissingURLTest() throws MalformedURLException {
        String[] args = {"scan", "--create"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));

        assertTrue(cli.getScanCommand().isCreateIndex());
    }

    @Test
    public void scanCommandTest() throws MalformedURLException {
        String[] args = {"scan", "--url", "file:///test/url", "--create"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));

        assertEquals(new URL("file:///test/url"), cli.getScanCommand().getUrl());
        assertEquals(true, cli.getScanCommand().isCreateIndex());
    }

    @Test
    public void scanCommandWithUsernameTest() throws MalformedURLException {
        String[] args = {"scan", "--username", "username", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals("username", cli.getScanCommand().getUsername());
    }

    @Test
    public void scanCommandWithPasswordTest() throws MalformedURLException {
        String[] args = {"scan", "--password", "ThisIsASecret", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals("ThisIsASecret", cli.getScanCommand().getPasswort());
    }

    @Test
    public void scanCommandWithFromRevisionHeadTest() throws MalformedURLException {
        String[] args = {"scan", "--fromrev", "head", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals(-1, cli.getScanCommand().getFromRev());
    }

    @Test(expectedExceptions = {ParameterException.class})
    public void scanCommandWithWrongFromRevisionTest() throws MalformedURLException {
        String[] args = {"scan", "--fromrev", "XXXX", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals(-1, cli.getScanCommand().getFromRev());
    }

    @Test
    public void scanCommandWithFromRevisionTest() throws MalformedURLException {
        String[] args = {"scan", "--fromrev", "123456", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals(123456, cli.getScanCommand().getFromRev());
    }

    @Test
    public void scanCommandFromRevisionAndToRevWithoutGivingAsParameterTest() throws MalformedURLException {
        String[] args = {"scan", "--url", "file:///test/repos"};
        SupoSECommands cli = new SupoSECommands(args);
        assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SCAN));
        assertEquals(new URL("file:///test/repos"), cli.getScanCommand().getUrl());
        assertEquals(1, cli.getScanCommand().getFromRev());
        assertEquals(-1, cli.getScanCommand().getToRev());
    }
}
