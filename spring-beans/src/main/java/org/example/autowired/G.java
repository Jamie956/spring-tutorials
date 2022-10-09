package org.example.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 1.spring 默认使用无参构造方法
 * 2.只有一个构造方法就用那个方法
 * 3.如果有两个有参构造方法，又没无参构造，spring 就不知道用哪个方法，
 * 如果在方法上加autowired注解，spring就知道要用哪一个构造方法
 */
@Component
public class G {
//	public G() {
//		System.out.println(0);
//	}

	public G(X x) {
		System.out.println(1);
	}

	@Autowired
	public G(X x, X x2) {
		System.out.println(2);
	}
}
