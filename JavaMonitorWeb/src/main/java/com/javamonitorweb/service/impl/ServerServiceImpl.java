package com.javamonitorweb.service.impl;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.javamonitorweb.dao.impl.ServerDAOImpl;
import com.javamonitorweb.exception.BusinessException;
import com.javamonitorweb.service.ServerService;
import com.javamonitorweb.vo.ServerVO;

public class ServerServiceImpl implements ServerService {

	private static ServerServiceImpl INSTANCE = new ServerServiceImpl ();
	
	private final Logger logger = LogManager.getLogger (ServerServiceImpl.class);
	
	private ServerDAOImpl serverDAO = ServerDAOImpl.getInstance();
		
	private ServerServiceImpl () {
		
	}
	
	public static ServerServiceImpl getInstance () {
		return INSTANCE;
	}
	
	public boolean isServersAvailable() throws BusinessException {
		logger.debug ("Start executing the method isServersAvailable.");
		List<ServerVO> serverVOList = null;
		boolean isAvailable = true;
		try {
			serverVOList = serverDAO.findAll();
			if (serverVOList != null && !serverVOList.isEmpty()) {			
				for (ServerVO serverVO : serverVOList) {
					logger.debug (serverVO.toString());
					if (!isServerAvailable (serverVO.getHostname(), serverVO.getPort())) {
						isAvailable = false;
						break;
					}
				}
			} else {
				String message = "No servers.";
				logger.debug (message);
				throw new BusinessException (message);
			}
		} catch (Exception e) {
			logger.error ("An error occurred while checking the available servers.", e);
			throw new BusinessException (e.getMessage());
		}
		logger.debug ("isAvailable [" + isAvailable + "]");
		logger.debug ("Finish executing the method isServersAvailable.");
		return isAvailable;
	}
	
	/**
	 * Checks if a given server is available.
	 * 
	 * @param hostname
	 * @param port
	 * @return 
	 */
	private boolean isServerAvailable (String hostname, int port) {
		logger.debug ("Start executing the method isServerAvailable.");
		Socket socket = null;
		boolean isAvailable = false;
		try {
		    socket = new Socket (hostname, port);
		    isAvailable = true;
		} catch (Exception e) {
			logger.error ("An error occurred while connecting to the specified server.", e);			
		} finally {            
		    if (socket != null) {
		    	try {
		    		socket.close(); 
		    	} catch (IOException e) {
		    		logger.error (e.getMessage());
		    	}
		    }
		}
		logger.debug ("isAvailable [" + isAvailable + "]");
		logger.debug ("Finish executing the method isServerAvailable.");
		return isAvailable;
	}

}
