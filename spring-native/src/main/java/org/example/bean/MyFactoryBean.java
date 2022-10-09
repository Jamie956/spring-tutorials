package org.example.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<X> {
	@Override
	public X getObject() throws Exception {
		//断点，context 容器 refresh 不会执行这个方法，在 getBean 的时候才会去实例化，有点像懒加载
		X x = new X();
		return x;
	}

	@Override
	public Class<?> getObjectType() {
		return X.class;
	}
}
