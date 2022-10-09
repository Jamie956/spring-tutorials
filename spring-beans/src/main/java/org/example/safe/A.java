package org.example.safe;

import org.springframework.stereotype.Component;

/**
 * 单例bean情况下
 * 如果在类中声明成员变量 并且有读写操作（有状态），就会线程不安全
 * 但是，只要变量声明在方法中，单例bean就是线程安全的
 */
@Component
public class A {
//	private String newname;

	public String greet(String name) {
		String newname;

		newname = "hi " + name;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return newname;
	}
}

