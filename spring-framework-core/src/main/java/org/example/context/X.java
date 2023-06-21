package org.example.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {
	private Y y;
	@Autowired
	public void setY(Y y) {
		this.y = y;
	}

	public X() {
		System.out.println("create X");
	}
}