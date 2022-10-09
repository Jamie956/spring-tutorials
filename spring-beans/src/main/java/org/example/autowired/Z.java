package org.example.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Z {
	private X x;

	//注解会找到参数x，执行set方法
	@Autowired
	public void setX(X x) {
		System.out.println("set");
		this.x = x;
	}

	//虽然没参数，还是会调方法
	@Autowired
	public void a() {
		System.out.println("a");
	}
}
