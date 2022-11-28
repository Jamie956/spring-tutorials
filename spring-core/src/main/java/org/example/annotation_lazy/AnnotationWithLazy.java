package org.example.annotation_lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

@ComponentScan("org.example.annotation_lazy")
public class AnnotationWithLazy {

	@Bean
	@Lazy
	public Y y () {
		return new Y();
	}
}
