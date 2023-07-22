package org.example.annotation_lookup;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.annotation.Lookup;

public class A {
	//注入方法返回值，代理类返回的注入bean，而不是null
	@Lookup("emptyObject")
	public EmptyObject lookupEmptyObject(){
		return null;
	}
}
