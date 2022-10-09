package org.example.inject.manually;

public class A {
	public A() {
		System.out.println("create A");
	}

	B b;

	/**
	 * setter 装配
	 */
	public void setB(B b) {
		//断点
		System.out.println("set b in a");
		this.b = b;
	}
}
