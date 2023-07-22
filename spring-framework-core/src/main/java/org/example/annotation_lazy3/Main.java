package org.example.annotation_lazy3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 * 测试 lazy 注解构造方法
	 */
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class, X.class);
		context.refresh();
		Assert.assertNotNull(context.getBean(X.class).emptyObject);
	}
}
