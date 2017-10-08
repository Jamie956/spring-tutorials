package com.example.demo.repository;

import java.util.List;

public class JsonTableModel {

	private Integer total;
	private List<?> rows;

	public JsonTableModel(Integer totalItems, List<?> itemsInfo) {
		this.total = totalItems;
		this.rows = itemsInfo;
	}
	public JsonTableModel(Integer totalItems) {
		this.total = totalItems;
	}
	public JsonTableModel(List<?> itemsInfo) {
		this.rows = itemsInfo;
	}

	public Integer getTotal() {
		return total;
	}

	public List<?> getRows() {
		return rows;
	}

}