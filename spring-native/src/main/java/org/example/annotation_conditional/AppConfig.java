package org.example.annotation_conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

@ComponentScan("org.example.annotation_conditional")
public class AppConfig {

	@Bean
	@Conditional(MyCondition.class)
	public Y y() {
		return new Y();
	}
}
