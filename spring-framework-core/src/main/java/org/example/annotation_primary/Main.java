package org.example.annotation_primary;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	//没有 Primary 注解时，同时存在两个bean，spring 不知道取哪个
	//加了 Primary 注解，当同时存在多个bean 时，取有Primary 注解的bean
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		Assert.assertEquals(context.getBean(EmptyObject.class), context.getBean("eo2"));
	}
}
