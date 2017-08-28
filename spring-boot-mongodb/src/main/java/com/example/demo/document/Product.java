package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private Integer id;
	private String name;
	private String price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Product(Integer id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
