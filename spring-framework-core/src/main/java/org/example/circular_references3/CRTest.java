package org.example.circular_references3;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
多例的setter注入: 这种循环依赖问题是无法解决的，因为它没有用缓存，每次都会生成一个新对象
非抽象、单例 并且非懒加载的类才能被提前初始bean: debug DefaultListableBeanFactory#preInstantiateSingletons
 */
public class CRTest {
	@Test(expected = UnsatisfiedDependencyException.class)
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.example.circular_references3");
		context.refresh();
	}
}
