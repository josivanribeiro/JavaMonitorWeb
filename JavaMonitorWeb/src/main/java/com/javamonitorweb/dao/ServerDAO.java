package com.javamonitorweb.dao;

import java.util.List;

import com.javamonitorweb.exception.DataAccessException;
import com.javamonitorweb.vo.ServerVO;

/**
 * Server DAO interface.
 * 
 * @author Ribeiro_Josivan
 *
 */
public interface ServerDAO {

	
	/**
	 * Finds all the servers. 
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public List<ServerVO> findAll () throws DataAccessException;
	
}
