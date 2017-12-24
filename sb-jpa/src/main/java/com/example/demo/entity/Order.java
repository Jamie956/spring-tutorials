package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String title, String status) {
		super();
		this.title = title;
		this.status = status;
	}
	public Order(Long id, String title, String status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", status=" + status + "]";
	}
	
}
