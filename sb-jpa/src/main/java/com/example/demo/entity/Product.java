package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	@Column(name = "price")
	private Integer price;

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Product(String name, Integer price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(Long id, String name, Integer price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
