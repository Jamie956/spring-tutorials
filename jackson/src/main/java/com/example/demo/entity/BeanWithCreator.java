package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanWithCreator {
	public int id;
	public String name;
	
	//json to pojo
	@JsonCreator
	public BeanWithCreator(@JsonProperty("id") int id, @JsonProperty("theName") String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanWithCreator [id=" + id + ", name=" + name + "]";
	}

}
