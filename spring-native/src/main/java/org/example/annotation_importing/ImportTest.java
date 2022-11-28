package org.example.annotation_importing;

import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DebugUtils.printBeanDefinition(context, "after");
	}
}
