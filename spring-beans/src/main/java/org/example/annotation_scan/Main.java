package org.example.annotation_scan;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 *  ComponentScan 扫描自定义注解
	 *  测试 @ComponentScan(value = "com.cat.annotation_scan", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class))
	 */
	@Test
	public void t0() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(X.class));
	}

	/**
	 * 测试 @ComponentScan(value = "com.cat.annotation_scan", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class))
	 */
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		System.out.println(context.getBean(Y.class));
	}

	/**
	 * 索引扫描
	 * 测试配置文件 spring.components 使注解路径失效
	 */
	@Test
	public void t2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);
		System.out.println(context.getBean(G.class));
		System.out.println(context.getBean(C.class));
	}
}
