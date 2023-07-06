package org.example.circular_references2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
为什么要用第二级缓存呢？
TestService1注入到TestService3又需要从第三级缓存中获取实例，而第三级缓存里保存的并非真正的实例对象，而是ObjectFactory对象。
两次从三级缓存中获取都是ObjectFactory对象，而通过它创建的实例对象每次可能都不一样的。
 */
public class CRTest {
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.example.circular_references2");
		context.refresh();

		Assert.assertNotNull(context.getBean(TestService1.class));
		Assert.assertNotNull(context.getBean(TestService2.class));
		Assert.assertNotNull(context.getBean(TestService3.class));
	}
}
