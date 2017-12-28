package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private Long id;
	private String name;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User(Long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
