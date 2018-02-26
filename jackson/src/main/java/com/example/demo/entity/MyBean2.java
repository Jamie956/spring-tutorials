package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonSetter;

public class MyBean2 {
    public int id;
    private String name;
 
    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "MyBean2 [id=" + id + ", name=" + name + "]";
	}
    
}
