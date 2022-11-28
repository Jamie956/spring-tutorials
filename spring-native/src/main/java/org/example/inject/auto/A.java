package org.example.inject.auto;

public class A {
	B b;

	public A() {
		System.out.println("create A");
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		// debug
		System.out.println("set b in a");
		this.b = b;
	}
}
