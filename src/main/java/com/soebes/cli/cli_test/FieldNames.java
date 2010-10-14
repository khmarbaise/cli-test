package com.soebes.cli.cli_test;

public enum FieldNames {
	CONTENTS("contents"),
	REVISION("revision"),
	KIND("kind"),
	NODE("node"),
	PATH("path"),
	FILENAME("filename"),
	AUTHOR("author"),
	MESSAGE("message"),
	DATE("date"),
	FROM("from"),
	FROMREV("fromrev"),
	REPOSITORY("repository"),
	REPOSITORYUUID("repositoryuuid"),
	SIZE("size"),
	TAG("tag"),
	MAVENTAG("maventag"),
	SUBVERSIONTAG("subversiontag"),
	BRANCH("branch"),
	XLSSHEET("xlssheet"),
	XLSSHEETNAME("xlssheetname"),
	XLSCOMMENT("xlscomment"),
	XLSCOMMENTAUTHOR("xlscommentauthor"),
	XLSAUTHOR("xlsauthor"),
	PDFAUTHOR("pdfauthor"),
	PDFCREATIONDATE("pdfcreationdate"),
	PDFCREATOR("pdfcreator"),
	PDFKEYWORDS("pdfkeywords"),
	PDFMODIFICATIONDATE("pdfmodificationdate"),
	PDFPRODUCER("pdfproducer"),
	PDFSUBJECT("pdfsubject"),
	PDFTITLE("pdftitle"),
	PDFTRAPPED("pdftrapped"),
	METHODS("methods"),
	COMMENTS("comments"),

	PROPERTIES("properties"); //This is not a real entry only used for displaying on command line?

	private String value;

	public String getValue() {
		return this.value;
	}

	private FieldNames(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}

}
