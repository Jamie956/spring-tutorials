package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//id,name => name,id
@JsonPropertyOrder({ "name", "id" })
public class MyBean1 {
    public int id;
    public String name;
	public MyBean1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}