package org.example.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<X> {
	@Override
	public X getObject() throws Exception {
		//breakpoint here, enter this method only when getBean(), although container refresh()
		X x = new X();
		return x;
	}

	@Override
	public Class<?> getObjectType() {
		return X.class;
	}
}
