package org.example.annotation_conditional;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConditionalTest {
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		System.out.println(context.getBean(X.class));
		System.out.println(context.getBean(Y.class));
	}
}
