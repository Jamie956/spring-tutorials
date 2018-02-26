package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {
	public String name;

	@JsonRawValue
	public String json;

	public RawBean(String name, String json) {
		super();
		this.name = name;
		this.json = json;
	}

}
