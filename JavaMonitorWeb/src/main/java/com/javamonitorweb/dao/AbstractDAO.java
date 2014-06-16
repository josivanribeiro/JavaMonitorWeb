package com.javamonitorweb.dao;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.javamonitorweb.config.Config;
import com.javamonitorweb.constants.ConfigProperty;
import com.javamonitorweb.exception.DataAccessException;

/**
 * Abstract DAO class.
 * 
 * @author Ribeiro_Josivan
 *
 */
public abstract class AbstractDAO {
	
	private Config config = Config.getInstance();
	
	private final Logger logger = LogManager.getLogger (AbstractDAO.class);
	
	protected XSSFWorkbook workbook;

	public AbstractDAO () {
		try {
			loadFile ();
		} catch (Exception e) {		
			logger.error ("An error occurred while invoking the loadFile.", e);
		}
	}
	
	/**
	 * Loads the excel file.
	 * 
	 * @throws Exception
	 */
	public void loadFile () throws DataAccessException {			
		try {		
			String filename = config.getProperties().getProperty (ConfigProperty.EXCEL_FILE_PATH.getValue());
			FileInputStream fis = new FileInputStream (new File (filename));
			workbook = new XSSFWorkbook (fis);
			fis.close();
		} catch (Exception e) {
			logger.error ("An error occurred while loading the excel file.", e);
			throw new DataAccessException (e.getMessage());
		}
	}
	
}

