package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Event2 {
    public String name;
 
    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

	@Override
	public String toString() {
		return "Event2 [name=" + name + ", eventDate=" + eventDate + "]";
	}
    
}