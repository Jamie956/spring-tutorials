package org.example.annotation_lazy2;

import org.springframework.beans.factory.annotation.Autowired;

public class B {

	//构成循环依赖，spring会解决
	@Autowired
	private A a;

	public void test1() {}
}
