package org.example.annotation_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Bean(autowireCandidate = false) 表示bean 不会被注入，虽然会被实例化
 */
@ComponentScan("com.cat.annotation_bean")
public class AppConfig2 {
	@Bean
	public Z z() {
		return new Z();
	}

//	@Bean
//	这个bean y 不能注入给其他bean
	@Bean(autowireCandidate = false)
	public Y2 y21() {
		return new Y2();
	}

	@Bean
	public Y2 y22() {
		return new Y2();
	}

}
