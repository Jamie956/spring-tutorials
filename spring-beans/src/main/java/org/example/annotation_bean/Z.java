package org.example.annotation_bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Z {
	@Autowired
	private Y y123;

	public void setY(Y y) {
		System.out.println("set");
		this.y123 = y;
	}

	public Y getY() {
		return y123;
	}
}
