package com.example.demo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.example.demo.domain.JwtUser;

public class JwtFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(JwtFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("===Filter===");
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		String headerToken = httpServletRequest.getHeader("Authorization");
		String sessionToken = (String) httpServletRequest.getSession().getAttribute("token");
		
		logger.info("header token => "+headerToken);
		logger.info("session token => "+sessionToken);
		
		JwtUser jwtUser = null;
		if(headerToken != null && headerToken.length() > 0) {
			jwtUser = new JwtValidator().validate(headerToken);
			logger.info("header jwtUser => "+jwtUser.toString());
		}
		if(sessionToken != null && sessionToken.length() > 0) {
			jwtUser = new JwtValidator().validate(sessionToken);
			logger.info("session jwtUser => "+jwtUser.toString());
		}
        if (jwtUser != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
	}
	
	@Override
	public void destroy() {
	}	
	
}
