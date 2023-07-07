package org.example.construct1;

/**
 * 推断构造方法
 * 1个无参构造方法、2个有参构造方法：实例化无参构造方法
 */
public class X {
	public X() {
		System.out.println("debug1");
	}
	public X(Y y) {
		System.out.println("debug2");
	}
	public X(int i, int j){
		System.out.println("debug3");
	}
}