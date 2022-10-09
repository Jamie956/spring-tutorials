package org.example.construct;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 推断构造方法
 * 情况：
 * 1个无参构造方法、2个有参构造方法：
 * 0个无参构造方法、2个有参构造方法：java.lang.NoSuchMethodException: org.example.construct.X.<init>()
 * 0个无参构造方法、1个有参构造方法：
 */
public class X {
//	public X() {
//		System.out.println("debug1");
//	}
	public X(Y y) {
		System.out.println("debug2");
	}
//	public X(int i, int j){
//		System.out.println("debug3");
//	}
}