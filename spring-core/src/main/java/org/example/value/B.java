package org.example.value;

import org.springframework.stereotype.Component;

@Component
public class B {
	private String name;

	public B() {
		System.out.println("create b 1");
	}

	public B(String name) {
		System.out.println("create b 2");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "b:" + name;
	}
}
