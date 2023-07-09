package org.example.post_processor1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(CustomBeanFactoryPostProcessor.class);
		context.refresh();
	}
}
