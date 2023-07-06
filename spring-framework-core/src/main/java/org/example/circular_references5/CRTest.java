package org.example.circular_references5;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
单例的代理对象setter注入
bean初始化完成之后，后面还有一步去检查：第二级缓存 和 原始对象 是否相等
懒加载可避免这种情况的循环依赖
 */
public class CRTest {
	@Test(expected = UnsatisfiedDependencyException.class)
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.example.circular_references5");
		context.refresh();

		TestService1 bean1 = context.getBean(TestService1.class);
		TestService2 bean2 = context.getBean(TestService2.class);
		System.out.println();
	}
}
