package com.example.demo.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean1 {
	public String name;
	private Map<String, String> properties;

	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}

	public ExtendableBean1(String name, Map<String, String> properties) {
		super();
		this.name = name;
		this.properties = properties;
		
	}

	@Override
	public String toString() {
		return "ExtendableBean1 [name=" + name + ", properties=" + properties + "]";
	}

}
