package org.example.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.autowired")
public class AppConfig {
	@Bean
	public X x1() {
		return new X();
	}

	@Bean
	public X x2() {
		return new X();
	}
}
