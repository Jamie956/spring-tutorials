package org.example.circular_references4;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
构造器注入
构造器注入没能添加到三级缓存，也没有使用缓存，所以也无法解决循环依赖问题
 */
public class CRTest {
	@Test(expected = UnsatisfiedDependencyException.class)
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.example.circular_references4");
		context.refresh();
	}
}
