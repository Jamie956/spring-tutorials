package org.example.annotation_bean;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.annotation_bean")
public class AppConfig3 {

	@MyBean
	public A a() {
		return new A();
	}
}
