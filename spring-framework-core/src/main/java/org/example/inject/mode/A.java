package org.example.inject.mode;

public class A {
//	@Autowired
	B b;

	public void setB(B b) {
		this.b = b;
	}

	public void printInfo() {
		System.out.println("bean-b:" + b);
	}

}
