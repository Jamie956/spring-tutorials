package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "t_item")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Item.awesomeFindByName", query = "SELECT * FROM t_item WHERE name = ?1", resultClass = Item.class),
		@NamedNativeQuery(name = "Item.awesomeFindByNameAndPrice", query = "SELECT * FROM t_item WHERE name = ?1 AND price = ?2", resultClass = Item.class)
})
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer price;
	private String content;
	
	public Item() {}
	public Item(String name, Integer price, String content) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
	}
	public Item(Long id, String name, Integer price, String content) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.content = content;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", content=" + content + "]";
	}
	
}
