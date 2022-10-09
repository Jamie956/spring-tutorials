package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class B {
	public void greeting(){
		System.out.println("greet from b");
	}
}
