package org.example.post_processor2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Field;

public class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//查找bean 有没带 MyAutowired1 注解的属性，如果获取这个属性的bean，并复制给注解属性
		Class<?> clazz = bean.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(MyAutowired1.class)) {
				field.setAccessible(true);
				Object autowiredBean = applicationContext.getBean(field.getName());
				try {
					//注入属性
					field.set(bean, autowiredBean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
