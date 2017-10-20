package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SbLog4j2Application.class)
public class SbLog4j2ApplicationTests {

	private static final Logger logger = LogManager.getLogger(SbLog4j2ApplicationTests.class);
	
	@Test
	public void test() throws Exception {
		logger.info("=> info");
		logger.debug("=> debug");
		logger.error("=> error");
		logger.warn("=> warn");
	}

}
