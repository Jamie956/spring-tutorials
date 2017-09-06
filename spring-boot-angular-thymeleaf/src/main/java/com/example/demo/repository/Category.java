package com.example.demo.repository;

public class Category {
	private String name;
	private String display_name;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String name, String display_name) {
		super();
		this.name = name;
		this.display_name = display_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	

}
