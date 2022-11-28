package org.example.annotation_lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	//构成循环依赖，spring会解决
	@Autowired
	private A a;

	public void test1() {}
}
