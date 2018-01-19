package com.example.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "user")
public class User {
	@Id
	private Long id;
	private String name;
	private String password;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date created_time;
	
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
	public User(Long id, String name, String password, Date created_time) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.created_time = created_time;
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
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", created_time=" + created_time + "]";
	}
	
}
