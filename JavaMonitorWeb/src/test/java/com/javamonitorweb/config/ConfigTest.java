package com.javamonitorweb.config;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConfigTest {

	private Config config;
	
	@Before
	public void setUp() throws Exception {
		config = Config.getInstance();
	}
	
	@Test
	public void testLoad()  {
		try {
			config.load();			
		} catch (Exception e) {
			fail (e.getMessage());
		}
	}
	
}
