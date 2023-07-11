package org.example.construct3;

import org.example.share.EmptyObject;

/**
 * 推断构造方法
 * 0个无参构造方法、1个有参构造方法：构造有参方法
 */
public class X {

//	public X(Y y) {
//		System.out.println("debug2");
//	}
	public X(EmptyObject e){
		System.out.println("debug3");
	}
}