package org.example.construct;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class StartTest {
	@Test
	public void beanDefinitionTest() {
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(X.class);
		context.registerBean(Y.class);
		context.refresh();
		String[] beans = context.getBeanDefinitionNames();
	}
}