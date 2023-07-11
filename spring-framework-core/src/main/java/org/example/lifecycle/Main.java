package org.example.lifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Z.class, CustomBeanPostProcessor.class);
		System.out.println("------------ before refresh ------------");
		context.refresh();
		System.out.println("------------ after refresh ------------");
		context.close();
	}

}
