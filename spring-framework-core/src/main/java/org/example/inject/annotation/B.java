package org.example.inject.annotation;

import org.springframework.stereotype.Component;

@Component
public class B {
	public B() {
		System.out.println("create b");
	}
}