package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String homePage(){
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/login_success")
	public String loginSuccessPage(){
		return "login_success";
	}
	
	@RequestMapping("/logout_success")
	public String logoutSuccessPage(){
		return "logout_success";
	}
	
	@RequestMapping("/user")
	public String userPage(){
		return "user";
	}
	
	@RequestMapping("/admin")
	public String adminPage(){
		return "admin";
	}
}
