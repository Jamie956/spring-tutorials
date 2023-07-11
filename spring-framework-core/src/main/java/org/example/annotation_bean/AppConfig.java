package org.example.annotation_bean;

import org.example.share.EmptyObject;
import org.springframework.context.annotation.Bean;

public class AppConfig {
	// autowireCandidate = false: cannot inject to other bean
	@Bean(autowireCandidate = false)
	public EmptyObject emptyObject() {
		return new EmptyObject();
	}
}
