package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {
    @JacksonInject
    public int id;
     
    public String name;

	@Override
	public String toString() {
		return "BeanWithInject [id=" + id + ", name=" + name + "]";
	}
    
}