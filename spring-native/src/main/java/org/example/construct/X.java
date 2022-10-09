package org.example.construct;

/**
 * 推断构造方法
 * 情况：
 * 1个无参构造方法、2个有参构造方法：0
 * 0个无参构造方法、2个有参构造方法：报错 java.lang.NoSuchMethodException: com.cat.bean.cons.X.<init>()
 * 0个无参构造方法、1个有参构造方法：
 */
public class X {
//	public X() {
//		System.out.println("0");
//	}

//	@Autowired
	//参数先 byType 再 byName 从单例池找
	public X(Y y) {
		System.out.println("1");
	}
//	public X(int i, int j){
//		System.out.println("1");
//	}
}