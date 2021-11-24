package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "t_category")
@NamedQueries(value = {
		@NamedQuery(name = "Category.customizeFindByName", query = "SELECT c FROM Category c WHERE c.name = ?1"),
		@NamedQuery(name = "Category.customizeFindByNameAndType", query = "SELECT c FROM Category c WHERE c.name = ?1 AND c.type = ?2")
})
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String type;
	
	public Category(Long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Category( String name, String type) {
		this.name = name;
		this.type = type;
	}
	public Category() {}
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
