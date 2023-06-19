package org.example.bean_definition;

import org.example.share.EmptyObject;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<EmptyObject> {
	@Override
	public EmptyObject getObject() throws Exception {
		//breakpoint here, enter this method only when getBean(), although container refresh()
		EmptyObject o = new EmptyObject();
		return o;
	}

	@Override
	public Class<?> getObjectType() {
		return EmptyObject.class;
	}
}
