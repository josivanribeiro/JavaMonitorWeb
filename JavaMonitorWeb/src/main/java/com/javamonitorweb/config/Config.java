package com.javamonitorweb.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Configuration class.
 * 
 * @author Ribeiro_Josivan
 *
 */
public class Config {

	private static Config INSTANCE = new Config ();
	
	private final Logger logger = LogManager.getLogger (Config.class);
	
	private static final String CONFIG_FILE_ARGUMENT = "com.javamonitorweb.configFile";
	
	private static final String CONFIG_FILE_PATH = System.getProperty (CONFIG_FILE_ARGUMENT);
	
	private Properties properties = null;
	
	private Config () {
		
	}
	
	public static Config getInstance () {
		return INSTANCE;
	}
	
	public Properties getProperties() {
		if (properties == null) {
			load ();
		}
		return properties;
	}

	public void setProperties (Properties properties) {
		this.properties = properties;
	}

	/**
	 * Loads the properties file.
	 */
	public void load() {		 
		properties = new Properties ();
		try {			
			File file = new File (CONFIG_FILE_PATH);
			FileInputStream is = new FileInputStream (file);
			properties.load (is);
			logger.debug ("The properties file loaded successfully.");
		} catch (IOException e) {
			logger.error ("An error occurred while loading the properties file.", e);
		}
	}
	
}
