package org.example.annotation_bean;

public class X {
	private Y y;

	public void setY(Y y) {
		System.out.println("set");
		this.y = y;
	}

	public Y getY() {
		return y;
	}
}
