package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;
	
    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    
	@GetMapping("/client")
	public String client(){
		String url = "http://spring-boot-server/rest/server";
		return restTemplate.getForObject(url, String.class);
	}
	
    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }
	
}
