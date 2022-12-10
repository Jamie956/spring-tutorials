package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

public class AnnotatedBeanWithCandidate {
	@Bean
	public Z z() {
		return new Z();
	}

	// cannot inject to other bean
	// debug AbstractBeanDefinition.isAutowireCandidate()
	@Bean(autowireCandidate = false)
	public Y y1() {
		return new Y();
	}

	@Bean
	public Y y2() {
		return new Y();
	}
}
