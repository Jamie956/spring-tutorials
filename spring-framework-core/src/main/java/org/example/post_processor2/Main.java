package org.example.post_processor2;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 自定义注解 MyAutowired1 注入属性
public class Main {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(A.class, EmptyObject.class, MyBeanPostProcessor.class);
		context.refresh();
		Assert.assertNotNull(context.getBean(A.class).emptyObject);
	}
}
