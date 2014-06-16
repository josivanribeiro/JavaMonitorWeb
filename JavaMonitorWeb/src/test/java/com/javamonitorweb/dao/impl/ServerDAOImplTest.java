package com.javamonitorweb.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.javamonitorweb.dao.ServerDAO;
import com.javamonitorweb.vo.ServerVO;


@RunWith(JUnit4.class)
public class ServerDAOImplTest {

	private ServerDAO serverDAO;
	
	@Before
	public void setUp() throws Exception {
		serverDAO = ServerDAOImpl.getInstance();
	}
	
	@Test
	public void testFindAll()  {
		List<ServerVO> list = null;
		try {
			list = serverDAO.findAll();
			assertNotNull ("list is null", list);
			assertTrue ("list is empty", !list.isEmpty());
		} catch (Exception e) {
			fail (e.getMessage());
		}
	}
	
}
