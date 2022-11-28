package org.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Z2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	public Z2() {
        System.out.println("create Z2");
    }

    /**
	 * 注解自定义的初始化函数
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.遍历后置处理器，执行 postProcessBeforeInitialization
	 * AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization step processor.postProcessBeforeInitialization
	 *
	 * 4.后置处理器反射调
	 * InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization step metadata.invokeInitMethods
	 *
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization
	 * @see org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization
     */
	@PostConstruct
    public void myInit() {
        System.out.println("5自定义init");
    }

	/**
	 * 注解自定义的销毁方法
	 *
	 * 1.关闭容器入口
	 * AbstractApplicationContext#close step doClose
	 *
	 * 2.遍历后置处理器
	 * DisposableBeanAdapter#destroy step processor.postProcessBeforeDestruction
	 *
	 * 3.后置处理器反射调 销毁方法
	 * InitDestroyAnnotationBeanPostProcessor#postProcessBeforeDestruction step metadata.invokeDestroyMethods
	 *
	 * @see org.springframework.beans.factory.support.DisposableBeanAdapter#destroy
	 * @see org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor#postProcessBeforeDestruction
	 */
	@PreDestroy
	public void myDestroy() {
		System.out.println("7自定义destroy");
	}

    @Override
    public void afterPropertiesSet() {
        // TODO Auto-generated method stub
        System.out.println("4InitializingBean.afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("3ApplicationContextAware.setApplicationContext");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("2BeanFactoryAware.setBeanFactory");
    }

	@Override
    public void setBeanName(String beanName) {
        // TODO Auto-generated method stub
        System.out.println("1BeanNameAware.setBeanName ");
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("6DisposableBean.destroy");
	}
}