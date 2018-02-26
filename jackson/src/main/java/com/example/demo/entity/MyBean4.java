package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyBean4 {
    public int id;
    private String name;
 
    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }
 
    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

	public MyBean4(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
