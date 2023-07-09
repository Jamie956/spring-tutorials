package org.example.annotation_lookup;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.annotation.Lookup;

public abstract class A {
	//给方法注入，代理类返回的注入bean，而不是null
	@Lookup("emptyObject")
	public EmptyObject lookupEmptyObject(){
		return null;
	}
}
