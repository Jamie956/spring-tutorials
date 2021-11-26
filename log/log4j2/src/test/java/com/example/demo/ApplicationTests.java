package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private static final Logger logger = LogManager.getLogger(ApplicationTests.class);
	
	@Test
	public void printLogTest() throws Exception {
		logger.info("=> info");
		logger.debug("=> debug");
		logger.error("=> error");
		logger.warn("=> warn");
	}

}
