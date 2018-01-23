package com.example.demo.web.rest;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;

@RestController
public class LoginRest {
	private static final Logger logger = LogManager.getLogger(LoginRest.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		//Get token from session
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attributes.getRequest().getSession();
        String token = (String) session.getAttribute("token");
        //Session exist token.
        if(token != null) {
        	logger.info("Session token => "+token);
        	return "Session exist token.";
        }
        //Generate token if auth success
		if(userDao.login(user)) {
			token = jwtUtil.generate(user);
			session.setAttribute("token", token);
			logger.info("Create session token => "+token);
			return "Create session token";
		}
		return "Try again";
	}
}
