package com.example.demo.domain;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String original_id;
	private String name;
	private String merchant_id;
	private String category_ufo;
	private String script;
	private String created_time;
	private String updated_time;
	private String alcohol;
	private String hidden;
	private String flag;
	private String display_name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginal_id() {
		return original_id;
	}
	public void setOriginal_id(String original_id) {
		this.original_id = original_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getCategory_ufo() {
		return category_ufo;
	}
	public void setCategory_ufo(String category_ufo) {
		this.category_ufo = category_ufo;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", original_id=" + original_id + ", name=" + name + ", merchant_id=" + merchant_id
				+ ", category_ufo=" + category_ufo + ", script=" + script + ", created_time=" + created_time
				+ ", updated_time=" + updated_time + ", alcohol=" + alcohol + ", hidden=" + hidden + ", flag=" + flag
				+ ", display_name=" + display_name + "]";
	}
	
}

