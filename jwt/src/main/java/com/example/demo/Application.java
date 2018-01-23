package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.security.JwtFilter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
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
