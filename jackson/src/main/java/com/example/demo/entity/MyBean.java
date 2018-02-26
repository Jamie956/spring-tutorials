package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MyBean {
	public int id;
	private String name;
	
	//Replace "TheName" with "name"
	@JsonGetter("name")
	public String getTheName() {
		return name;
	}

	public MyBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}