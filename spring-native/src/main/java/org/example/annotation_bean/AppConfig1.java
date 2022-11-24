package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.annotation_bean")
public class AppConfig1 {
	@Bean
	public X1 x1() {
		return new X1();
	}

	@Bean
	public Y1 y1() {
		return new Y1();
	}
}
