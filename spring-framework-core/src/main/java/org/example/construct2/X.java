package org.example.construct2;

import org.example.share.EmptyObject;

/**
 * 推断构造方法
 * 0个无参构造方法、2个有参构造方法：java.lang.NoSuchMethodException: org.example.construct.X.<init>()
 */
public class X {
	public X(EmptyObject emptyObject) {
		System.out.println("debug2");
	}
	public X(EmptyObject e, Y y){
		System.out.println("debug3");
	}
}