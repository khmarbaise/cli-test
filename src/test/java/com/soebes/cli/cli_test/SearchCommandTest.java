package com.soebes.cli.cli_test;

import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.soebes.cli.cli_test.SupoSECommands.SupoSEExistingCommands;

/**
 * Testing the parameters for the search command.
 */
public class SearchCommandTest {

    @Test
    public void searchCommandMissingURLTest() {
        String[] args = {"search"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SEARCH));
    }

    @Test
    public void searchCommandFieldsTest() {
        String[] args = {"search", "--field", "revision", "--field", "author"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SEARCH));

        Assert.assertEquals(2, cli.getSearchCommand().getFields().size());
        List<FieldNames> fieldList = cli.getSearchCommand().getFields();
        Assert.assertEquals(FieldNames.REVISION, fieldList.get(0));
        Assert.assertEquals(FieldNames.AUTHOR, fieldList.get(1));

    }

    @Test
    public void searchCommandQueryTest() {
        String[] args = {"search", "--query", "ThisIsAQuery"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SEARCH));
        Assert.assertEquals("ThisIsAQuery", cli.getSearchCommand().getQuery());
    }

    @Test
    public void searchCommandQueryWithSpacesTest() {
        String[] args = {"search", "--query", "+filename:* -path:/trunk/*"};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SEARCH));
        Assert.assertEquals("+filename:* -path:/trunk/*", cli.getSearchCommand().getQuery());
    }

    @Test
    public void searchCommandQueryWithQuotedPartsTest() {
        String[] args = {"search", "--query", "+filename:* -path:/trunk/* +message:\"log\""};
        SupoSECommands cli = new SupoSECommands(args);
        Assert.assertTrue(cli.getCommand().equals(SupoSEExistingCommands.SEARCH));
        Assert.assertEquals("+filename:* -path:/trunk/* +message:\"log\"", cli.getSearchCommand().getQuery());
    }
}
