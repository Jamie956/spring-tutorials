package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Event3 {
	public String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public Date eventDate;

	public Event3(String name, Date eventDate) {
		super();
		this.name = name;
		this.eventDate = eventDate;
	}
	
	
}