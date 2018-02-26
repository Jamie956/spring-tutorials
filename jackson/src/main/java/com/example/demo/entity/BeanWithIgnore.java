package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class BeanWithIgnore {
    public int id;
    public String name;
	public BeanWithIgnore(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}
