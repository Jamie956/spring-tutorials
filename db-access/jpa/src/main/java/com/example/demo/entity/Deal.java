package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_deal")
public class Deal {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String value;
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deal(String title, String value) {
		super();
		this.title = title;
		this.value = value;
	}
	public Deal(Long id, String title, String value) {
		super();
		this.id = id;
		this.title = title;
		this.value = value;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Deal [id=" + id + ", title=" + title + ", value=" + value + "]";
	}
	
}
