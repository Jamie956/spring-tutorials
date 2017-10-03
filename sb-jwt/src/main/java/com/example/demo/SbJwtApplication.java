package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.security.JwtFilter;

@SpringBootApplication
public class SbJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbJwtApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new JwtFilter());
		registration.addUrlPatterns("/rest/*");
//		registration.addInitParameter("paramName", "paramValue");
//		registration.setName("testFilter");
		registration.setOrder(1);
		return registration;
	}

}
