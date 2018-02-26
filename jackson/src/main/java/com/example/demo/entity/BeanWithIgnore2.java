package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BeanWithIgnore2 {
    @JsonIgnore
    public int id;
    public String name;
	public BeanWithIgnore2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}
