package org.example.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

@ComponentScan("org.example.value")
public class AppConfig3 {

	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean convert = new ConversionServiceFactoryBean();
		convert.setConverters(Collections.singleton(new SpringConvert()));
		return convert;
	}
}
