package org.example.construct;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 推断构造方法
 */
public class Main {
	@Test
	public void beanDefinitionTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(X.class, Y.class);
		context.refresh();
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}
}