package org.example.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class C {
	private D d;

	@Autowired
	@Lazy
	public C(D d) {
		//断点, 加了lazy d 就是代理对象
		this.d = d;
	}
}
