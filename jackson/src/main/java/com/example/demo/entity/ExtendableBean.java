package com.example.demo.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class ExtendableBean {
	public String name;
	private Map<String, String> properties;

	//It can get all k-v, not in {}
	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public ExtendableBean(String name, Map<String, String> properties) {
		super();
		this.name = name;
		this.properties = properties;
	}

	public ExtendableBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}