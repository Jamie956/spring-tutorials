package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MusicService;

@RestController
public class MusicRest {

	@Autowired
	private MusicService musicService;

	@RequestMapping(value = "/")
	public String listen() {
		return musicService.listen();
	}

}
