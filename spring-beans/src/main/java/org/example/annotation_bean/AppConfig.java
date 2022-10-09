package org.example.annotation_bean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.annotation_bean")
public class AppConfig {
	//表示X 类的变量使用 byType 模式注入属性
	@Bean(autowire = Autowire.BY_TYPE)
	public X x() {
		return new X();
	}

	@Bean
	public Y y() {
		return new Y();
	}
}
