package org.example.importing;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("--------------------------------------------------------");
		for (String beanDefinitionName: context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		System.out.println("--------------------------------------------------------");
	}

}
