package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String loginPage() {
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
	
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "dashboard";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register/admin")
	public String userRegister(UserEntity userEntity) {
		userEntity.setRoles("ROLE_ADMIN");
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userRepository.save(userEntity);
		return "register_success";
	}
	
	@PostMapping("/register/user")
	public String adminRegister(UserEntity userEntity) {
		userEntity.setRoles("ROLE_USER");
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userRepository.save(userEntity);
		return "register_success";
	}
}
