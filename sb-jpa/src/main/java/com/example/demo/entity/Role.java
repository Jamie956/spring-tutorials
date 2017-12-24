package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String permission;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String name, String permission) {
		super();
		this.name = name;
		this.permission = permission;
	}
	public Role(Long id, String name, String permission) {
		super();
		this.id = id;
		this.name = name;
		this.permission = permission;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permission=" + permission + "]";
	}
	
}
