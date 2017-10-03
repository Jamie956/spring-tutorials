package com.example.demo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.domain.JwtUser;

public class JwtFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("===Filter===");
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		String token = httpServletRequest.getHeader("Authorization");
		
        JwtValidator jwtValidator = new JwtValidator();
        JwtUser jwtUser = jwtValidator.validate(token);
        
        System.out.println("name -> "+jwtUser.getUserName());
        System.out.println("id -> "+jwtUser.getId());
        System.out.println("role -> "+jwtUser.getRole());
        
        
        if (jwtUser != null) {

            
            filterChain.doFilter(servletRequest, servletResponse);
        }
        
	}
	
	@Override
	public void destroy() {
	}	
	
}
