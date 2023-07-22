package org.example.annotation_lookup;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Lookup 方法返回值注入
 */
public class Main {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(A.class, EmptyObject.class);
		context.refresh();

		//A bean 是代理类
		Assert.assertNotNull(context.getBean(A.class));
		Assert.assertNotNull(context.getBean(A.class).lookupEmptyObject());
		Assert.assertTrue(context.getBean(A.class).lookupEmptyObject() instanceof EmptyObject);
	}
}
