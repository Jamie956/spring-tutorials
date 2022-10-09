package org.example.construct;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartTest {
	@Test
	public void beanDefinitionTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(X.class, Y.class);
		context.refresh();
		String[] beans = context.getBeanDefinitionNames();
	}
}