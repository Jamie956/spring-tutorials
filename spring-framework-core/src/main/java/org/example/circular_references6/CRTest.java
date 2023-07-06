package org.example.circular_references6;

import org.example.circular_references5.TestService1;
import org.example.circular_references5.TestService2;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
DependsOn循环依赖
if (isDependent(beanName, dep)) {
 */
public class CRTest {

	@Test(expected = BeanCreationException.class)
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.example.circular_references6");
		context.refresh();

		TestService1 bean1 = context.getBean(TestService1.class);
		TestService2 bean2 = context.getBean(TestService2.class);
	}
}
