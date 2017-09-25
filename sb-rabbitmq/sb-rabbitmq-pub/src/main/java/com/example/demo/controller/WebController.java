package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.publisher.Publisher;


@RestController
public class WebController {
	
	@Autowired
	Publisher publisher;
	
	@RequestMapping("/send")
	public String sendMsg(@RequestParam("msg") String msg){
		publisher.produceMsg(msg);
		return "Done";
	}
}
