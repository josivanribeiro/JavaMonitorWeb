package com.javamonitorweb.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ServerServiceImplTest {

	private ServerServiceImpl serverService;
	
	private static final boolean SUCCESS = true;
	
	@Before
	public void setUp() throws Exception {
		serverService = ServerServiceImpl.getInstance();
	}
	
	@Test
	public void testIsServersAvailable() {
		boolean isAvailable = false;
		try {
			isAvailable = serverService.isServersAvailable();
			assertTrue ("isAvailable must be true", isAvailable);
		} catch (Exception e) {
			fail (e.getMessage());
		}
	}
	
	/*@Test
	public void testIsServersAvailableWithoutServers() {
		try {
			serverService.isServersAvailable();
			fail ("An exception was expected.");
	    } catch (Exception e) {
	    	boolean contains = e.getMessage().contains("No servers.");
			assertEquals ("The result for the operation testIsServersAvailableWithoutServers() "
						 + "was [" + contains + "] but the expected was [" + SUCCESS + "]", SUCCESS, contains);
	    }
	}*/
	
}
