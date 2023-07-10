package org.example.annotation_value2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 * value String值赋值给对象变量
	 */
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class, A.class, B.class);
		context.refresh();
		Assert.assertEquals("223", context.getBean(A.class).b.name);
	}
}