package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.JsonTableModel;
import com.example.demo.services.CategoriesService;
import com.google.gson.Gson;

@RestController
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping("/categories")
	public ResponseEntity<?> getCategoriesTable() {
		JsonTableModel result = categoriesService.initCategoriesTableByMid();
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
}
