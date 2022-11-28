package org.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Z implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public Z() {
        System.out.println("create Z");
    }

    /**
	 * 自定义init方法调用过程
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.反射调自定义init方法(因为自定义方法没有实现接口，不能使用 instanceof 判断转型调实现方法)
	 * AbstractAutowireCapableBeanFactory#invokeCustomInitMethod step methodToInvoke.invoke(bean)
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeCustomInitMethod
     */
    public void myInit() {
        System.out.println("5自定义init");
    }

	/**
	 * InitializingBean.afterPropertiesSet
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.指定回调初始方法
	 * AbstractAutowireCapableBeanFactory#invokeInitMethods step ((InitializingBean) bean).afterPropertiesSet();
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeInitMethods
	 */
	@Override
    public void afterPropertiesSet() {
        // TODO Auto-generated method stub
        System.out.println("4InitializingBean.afterPropertiesSet");
    }

	/**
	 * ApplicationContextAware.setApplicationContext
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.遍历后置处理器
	 * AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization step processor.postProcessBeforeInitialization
	 *
	 * 4.instanceof 找出实现接口的类，回调实现的具体方法
	 * ApplicationContextAwareProcessor#invokeAwareInterfaces step ((ApplicationContextAware) bean).setApplicationContext
	 *
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization
	 * @see org.springframework.context.support.ApplicationContextAwareProcessor#invokeAwareInterfaces
	 */
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("3ApplicationContextAware.setApplicationContext");
    }

	/**
	 * BeanFactoryAware.setBeanFactory
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.instanceof 找出实现接口的类，回调实现的具体方法
	 * AbstractAutowireCapableBeanFactory#invokeAwareMethods step ((BeanFactoryAware) bean).setBeanFactory
	 *
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeAwareMethods
	 */
	@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("2BeanFactoryAware.setBeanFactory");
    }

	/**
	 * BeanNameAware.setBeanName
	 *
	 * 1.refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization
	 *
	 * 2.回调入口
	 * AbstractAutowireCapableBeanFactory#doCreateBean step initializeBean
	 *
	 * 3.instanceof 找出实现接口的类，回调实现的具体方法
	 * AbstractAutowireCapableBeanFactory#invokeAwareMethods step ((BeanNameAware) bean).setBeanName
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeAwareMethods
	 */
	@Override
    public void setBeanName(String beanName) {
        // TODO Auto-generated method stub
        System.out.println("1BeanNameAware.setBeanName");
    }

	/**
	 * 自定义销毁方法
	 *
	 * 1.关闭容器入口
	 * AbstractApplicationContext#close step doClose
	 *
	 * 2.反射回调自定义销毁方法
	 * DisposableBeanAdapter#invokeCustomDestroyMethod step destroyMethod.invoke
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#close
	 * @see org.springframework.beans.factory.support.DisposableBeanAdapter#invokeCustomDestroyMethod
	 */
	public void myDestroy() {
		System.out.println("自定义destroy");
	}

	/**
	 * DisposableBean.destroy
	 *
	 * 1.关闭容器入口
	 * AbstractApplicationContext#close step doClose
	 *
	 * 2.转型 DisposableBean，调destroy
	 * DisposableBeanAdapter#destroy step ((DisposableBean) this.bean).destroy
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#close
	 * @see org.springframework.beans.factory.support.DisposableBeanAdapter#destroy
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("6DisposableBean.destroy");
	}
}