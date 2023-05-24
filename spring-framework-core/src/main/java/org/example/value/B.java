package org.example.value;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class B {
	private String name;

	public B() {
//		System.out.println("create b 1");
	}

	public B(String name) {
//		System.out.println("create b 2");
		this.name = name;
	}

}
