package org.example.value;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void readPropertiesValue() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		X bean = context.getBean(X.class);
		Assert.assertEquals("aa", bean.getPropertiesFileValue());
		Assert.assertEquals("${properties.file.not.found.value}", bean.getPropertiesFileValueNotFoundValue());
		Assert.assertEquals("111", bean.getPropertiesFileValueNotFoundDefaultValue());
		Assert.assertEquals("pureStringValue", bean.getPureString());
		Assert.assertNotNull(bean.getY());
		Assert.assertEquals("aa", bean.getCustomAnnotationValue());
	}

	/**
	 * 测试 Editor
	 */
	@Test
	public void t1() {
		MyEditor editor = new MyEditor();
		editor.setAsText("122");
		B value = (B) editor.getValue();
		System.out.println(value.getName());
	}

	/**
	 * 测试value String值赋值给对象变量
	 * jdk 方式
	 */
	@Test
	public void t2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		System.out.println(context.getBean(A.class).getB().getName());
	}


	/**
	 * 测试value String值赋值给对象变量
	 * spring 方式
	 */
	@Test
	public void t3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);
		System.out.println(context.getBean(A.class).getB().getName());
	}
}