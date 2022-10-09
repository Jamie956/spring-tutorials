package org.example.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	//可以解决循环依赖
	@Lazy
	private B b;

	@Async
	public void test1() {
		//断点，可以看出创建了b代理对象
		System.out.println(b);
		b.test1();
	}
}
