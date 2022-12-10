package org.example.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@ComponentScan("com.cat.primary")
public class AppConfig {

	@Bean
	//当同时存在多个bean 时，取有Primary 注解的bean
	@Primary
	public A a1() {
		return new A();
	}
}
