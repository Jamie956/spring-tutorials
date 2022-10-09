package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.annotation_bean")
public class AppConfig2 {
	@Bean
	public Z z() {
		return new Z();
	}

//	@Bean
	//这个bean y 不能注入给其他bean
	@Bean(autowireCandidate = false)
	public Y y1() {
		return new Y();
	}

	@Bean
	public Y y2() {
		return new Y();
	}

}
