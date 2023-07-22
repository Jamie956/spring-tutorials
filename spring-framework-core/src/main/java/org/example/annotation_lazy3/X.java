package org.example.annotation_lazy3;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class X {
	public EmptyObject emptyObject;

	// @Lazy 能注入构造方法参数?即使容器原来不存在参数对象?
	@Autowired
//	@Lazy
	public X(EmptyObject emptyObject) {
		//断点, 加了lazy 参数就是代理对象
		this.emptyObject = emptyObject;
	}
}
