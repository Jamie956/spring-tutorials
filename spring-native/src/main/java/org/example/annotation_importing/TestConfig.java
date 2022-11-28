package org.example.annotation_importing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	@Bean
	public Y getY(){
		return new Y();
	}
}
