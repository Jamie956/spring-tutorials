package org.example.safe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试spring单例是否线程安全
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		A bean = context.getBean(A.class);
		A bean2 = context.getBean(A.class);
		System.out.println(bean == bean2);

		new Thread(() -> {
			System.out.println(bean.greet("tim"));
		}).start();

		new Thread(() -> {
			System.out.println(bean2.greet("tom"));
		}).start();

		//从运行结果看，脏读
	}
}
