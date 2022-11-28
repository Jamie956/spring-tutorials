package org.example.annotation_bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

public class AnnotatedBeanWithScope {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public A a() {
		// debug: invoke every time getBean(..)
		return new A();
	}
}
