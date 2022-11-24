package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.example.annotation_bean")
//@Configuration
public class AppConfig4 {

	@Bean
	public C c() {
		return new C();
	}

	@Bean
	public G g() {
		//如果不加@Configuration，每次调c 方法都会新创建c实例
		//如果加了@Configuration，c方法返回的都是同一个实例
		System.out.println(c());
		System.out.println(c());
		return new G();
	}
}
