package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HiRest {
	private final static Logger logger = LoggerFactory.getLogger(HiRest.class); 
	
	@RequestMapping(method = RequestMethod.GET, value = "")
	public String sayHi() {
		logger.info("logback 成功了");
        logger.error("logback 成功了");
        
		return "hi";
	}
}