package org.example.annotation_lazy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class X {
	private Y y;

	// @Lazy 能注入构造方法参数?即使容器原来不存在参数对象?
	@Autowired
	@Lazy
	public X(Y y) {
		//断点, 加了lazy d 就是代理对象
		this.y = y;
	}
}
