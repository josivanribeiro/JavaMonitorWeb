package com.javamonitorweb.service;

import com.javamonitorweb.exception.BusinessException;

/**
 * Server Service interface.
 * 
 * @author Ribeiro_Josivan
 *
 */
public interface ServerService {

	/**
	 * Business service that checks if all servers are available.
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public boolean isServersAvailable () throws BusinessException;
	
}
