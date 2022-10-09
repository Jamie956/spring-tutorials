package org.example.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

@ComponentScan("com.cat.lazy")
public class AppConfig {

	@Bean
	@Lazy
	public Y y () {
		return new Y();
	}
}
