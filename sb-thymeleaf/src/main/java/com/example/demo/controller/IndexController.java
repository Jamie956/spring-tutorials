package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;


@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	private List<Product> products = new ArrayList<Product>(Arrays.asList(
		new Product("01","product01","1.00"),
		new Product("02","product02","2.00"),
		new Product("03","product03","3.00")
	));
	
	@RequestMapping("/product")
	public String listProducts(Model model){
		model.addAttribute("products", products);
		return "product";
	}
	
}
