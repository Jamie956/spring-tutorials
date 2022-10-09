package org.example.circular;

public class A {
	private B b;

	public A() {
		System.out.println("create a");
	}

	public void setB(B b) {
		System.out.println("a populate b");
		this.b = b;
	}
}
