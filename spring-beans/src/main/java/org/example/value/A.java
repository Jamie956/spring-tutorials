package org.example.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Value("223")
	private B b;

	public B getB() {
		return b;
	}
}
