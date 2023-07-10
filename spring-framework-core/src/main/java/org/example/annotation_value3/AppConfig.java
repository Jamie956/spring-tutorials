package org.example.annotation_value3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

public class AppConfig {
	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean convert = new ConversionServiceFactoryBean();
		convert.setConverters(Collections.singleton(new SpringConvert()));
		return convert;
	}
}
