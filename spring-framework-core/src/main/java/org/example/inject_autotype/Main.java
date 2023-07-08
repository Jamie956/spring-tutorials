package org.example.inject_autotype;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	// debug PropertyValues pvs = (mbd.hasPropertyValues() ? mbd.getPropertyValues() : null);
	@Test
	public void autoInjectTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(A.class, EmptyObject.class);
		//设置注入模式
		AbstractBeanDefinition bd = (AbstractBeanDefinition) context.getBeanDefinition("a");
		bd.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		context.refresh();

		Assert.assertNotNull(context.getBean(A.class));
		Assert.assertNotNull(context.getBean(A.class).o);
	}
}