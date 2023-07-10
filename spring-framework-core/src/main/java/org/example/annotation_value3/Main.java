package org.example.annotation_value3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 * 测试value String值赋值给对象变量
	 * spring 方式
	 */
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(A.class, AppConfig.class);
        context.refresh();
        Assert.assertEquals("223", context.getBean(A.class).b.name);
	}
}