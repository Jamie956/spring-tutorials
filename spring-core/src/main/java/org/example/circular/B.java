package org.example.circular;

public class B {
	private A a;

	public B() {
		System.out.println("create b");
	}

	public void setA(A a) {
		System.out.println("b populate a");
		this.a = a;
	}
}
