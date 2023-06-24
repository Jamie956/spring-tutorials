package org.example.annotation_bean1;

import org.example.share.EmptyObject;
import org.springframework.context.annotation.Bean;

public class X {
	// cannot inject to other bean if autowireCandidate = false
//	@Bean
	@Bean(autowireCandidate = false)
	public EmptyObject emptyObject() {
		return new EmptyObject();
	}
}
