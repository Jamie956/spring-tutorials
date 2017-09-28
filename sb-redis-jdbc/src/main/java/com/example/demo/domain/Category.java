package com.example.demo.domain;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String original_id;
	private String name;
	private String merchant_id;
	private String createdTime;
	private String updatedTime;
	private String categoryUfo;
	private String alcohol;
	private String displayName;
	
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", original_id=" + original_id + ", name=" + name + ", merchant_id=" + merchant_id
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", categoryUfo=" + categoryUfo
				+ ", alcohol=" + alcohol + ", displayName=" + displayName + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getCategoryUfo() {
		return categoryUfo;
	}
	public void setCategoryUfo(String categoryUfo) {
		this.categoryUfo = categoryUfo;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getOriginal_id() {
		return original_id;
	}
	public void setOriginal_id(String original_id) {
		this.original_id = original_id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}

