package org.example.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class A {
	//给方法注入，代理类返回的注入bean，而不是null
	@Lookup("b")
	public B test(){
		System.out.println("tttt");
		return null;
	}
}
