package com.example.demo.web.rest;

import javax.servlet.http.HttpServletRequest;
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

import com.example.demo.dao.LoginDao;
import com.example.demo.domain.JwtUser;
import com.example.demo.security.JwtGenerator;

@RestController
public class LoginREST {
	private static final Logger logger = LogManager.getLogger(LoginREST.class);
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody JwtUser jwtuser) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        
        String token = (String) session.getAttribute("token");
        if(token != null) {
        	logger.info("session token => "+token);
        	return "has token";
        }
		if(loginDao.login(jwtuser)) {
			token = jwtGenerator.generate(jwtuser);
			session.setAttribute("token", token);
			logger.info("new token => "+token);
			return "login success";
		}
		return "try again";
	}
	
}
