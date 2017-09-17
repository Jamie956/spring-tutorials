package com.example.demo.repository;

public class Category {
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
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String original_id, String name, String merchant_id, String category_ufo, String script,
			String created_time, String updated_time, String alcohol, String hidden, String flag, String display_name) {
		super();
		this.id = id;
		this.original_id = original_id;
		this.name = name;
		this.merchant_id = merchant_id;
		this.category_ufo = category_ufo;
		this.script = script;
		this.created_time = created_time;
		this.updated_time = updated_time;
		this.alcohol = alcohol;
		this.hidden = hidden;
		this.flag = flag;
		this.display_name = display_name;
	}
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
	
}

