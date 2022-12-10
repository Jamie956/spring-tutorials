package org.example.value;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * value的作用：
 * 普通字符串：			@Value("name不从配置文件读")
 * 占位符：				@Value("${na}") 读取配置文件
 * SpringEL 表达式：		@Value("#{yy1}") 注入bean
 * 定义一个带@value的注解：@MyValue
 */
public class Main {
	@Test
	public void readValue() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(X.class).toString());
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