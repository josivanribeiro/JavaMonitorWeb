package com.javamonitorweb.constants;

/**
 * Config property enum.
 * 
 * @author Ribeiro_Josivan
 *
 */
public enum ConfigProperty {

	EXCEL_FILE_PATH ("excel.file.path");
	
	private String value;
	
	ConfigProperty (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
