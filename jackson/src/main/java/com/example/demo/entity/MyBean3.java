package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MyBean3 {
    public int id;
    public String name;
	public MyBean3(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}