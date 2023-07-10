package org.example.annotation_scope;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Config {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EmptyObject emptyObject() {
		// debug here
		return new EmptyObject();
	}
}
