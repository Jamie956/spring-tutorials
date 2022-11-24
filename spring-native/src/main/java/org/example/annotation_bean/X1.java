package org.example.annotation_bean;

import org.springframework.beans.factory.annotation.Autowired;

public class X1 {
	private Y1 y1;

	@Autowired
	public void setY1(Y1 y1) {
		System.out.println("set");
		this.y1 = y1;
	}

	public Y1 getY1() {
		return y1;
	}
}
