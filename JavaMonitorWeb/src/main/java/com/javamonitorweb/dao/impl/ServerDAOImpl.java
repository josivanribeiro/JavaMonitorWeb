package com.javamonitorweb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.javamonitorweb.constants.Constants;
import com.javamonitorweb.dao.AbstractDAO;
import com.javamonitorweb.dao.ServerDAO;
import com.javamonitorweb.exception.DataAccessException;
import com.javamonitorweb.vo.ServerVO;

public class ServerDAOImpl extends AbstractDAO implements ServerDAO {
	
	private static ServerDAOImpl INSTANCE = new ServerDAOImpl ();
	
	private final Logger logger = LogManager.getLogger (ServerDAOImpl.class);
	
	private ServerDAOImpl () {
		
	}
	
	public static ServerDAOImpl getInstance () {
		return INSTANCE;
	}
	
	public List<ServerVO> findAll() throws DataAccessException {
		logger.debug ("Start executing the method findAll.");
		List<ServerVO> serverVOList = new ArrayList<ServerVO>();
		// updates the workbook with the last items from the spread sheet
		loadFile ();
		try {
			XSSFSheet sheet = workbook.getSheetAt (0);
	        Iterator<Row> rowIterator = sheet.iterator();
	        // skip the first row (title columns)
	    	rowIterator.next();
	        while (rowIterator.hasNext()) {
	            ServerVO serverVO = new ServerVO();        	
	        	Row row = rowIterator.next();
	            
	            Cell idCell   = row.getCell (Constants.SERVER_ID_CELL_INDEX);
	            Cell hostnameCell = row.getCell (Constants.SERVER_HOSTNAME_CELL_INDEX);
	            Cell portCell = row.getCell (Constants.SERVER_PORT_CELL_INDEX);
	            Cell typeCell = row.getCell (Constants.SERVER_TYPE_CELL_INDEX);
	            
	            if (idCell != null) {
	            	int id = (int) idCell.getNumericCellValue();
	            	serverVO.setId (id);	            	
	            }            
	            if (hostnameCell != null) {
	            	String hostname = hostnameCell.getStringCellValue();
	            	serverVO.setHostname (hostname);	            	
	            }            
	            if (portCell != null) {
	            	int port = (int) portCell.getNumericCellValue();
	            	serverVO.setPort (port);	            	
	            }            
	            if (typeCell != null) {
	            	String type = typeCell.getStringCellValue();            	
	            	serverVO.setType (type);	            	
	            }	            
	            serverVOList.add (serverVO);
	        }
		} catch (Exception e) {
			logger.error ("An error occurred while finding all the servers.", e);
			throw new DataAccessException (e.getMessage());
		}		
        logger.debug ("Finish executing the method findAll.");
		return serverVOList;
	}
	
	
}
