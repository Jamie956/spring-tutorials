package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonFilter("myFilter")
public class BeanWithFilter {
    public int id;
    public String name;
	public BeanWithFilter(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}