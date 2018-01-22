package com.example.demo.model;

import java.util.List;

public class JsonTable {

	private Integer count;
	private List<?> rows;
	
	public JsonTable() {}
	public JsonTable(Integer count, List<?> rows) {
		this.count = count;
		this.rows = rows;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}