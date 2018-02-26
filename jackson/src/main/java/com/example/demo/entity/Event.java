package com.example.demo.entity;

import java.util.Date;

import com.example.demo.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Event {
    public String name;
 
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

	public Event(String name, Date eventDate) {
		super();
		this.name = name;
		this.eventDate = eventDate;
	}
}
