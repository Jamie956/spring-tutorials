package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.example.annotation_bean")
//@Configuration
//注解 @Configuration，class 变成代理对象
public class AppConfig4 {

	@Bean
	public C c() {
		return new C();
	}

	@Bean
	public G g() {
		//注解 @Configuration，c() 每次返回新实例c；否则不注解@Configuration，c()返回的都是同一个实例
		System.out.println(c());
		System.out.println(c());
		return new G();
	}
}
