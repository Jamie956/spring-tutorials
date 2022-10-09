package org.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义 BeanFactoryPostProcessor
 *
 * postProcessBeanFactory 执行链路
 * 1.入口 refresh() invokeBeanFactoryPostProcessors, 扫描target class且加到 beanDefinitionMap
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 *
 * 2.从一级缓存获取自定义 BeanFactoryPostProcessor 的实例bean，beanFactory.getBeanNamesForType()
 * @see org.springframework.context.support.PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors
 *
 * 3.遍历 beanFactory 后置处理器，执行接口的实现方法
 * @see org.springframework.context.support.PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors
 *
 *
 * 自定义 BeanFactoryPostProcessor 的创建过程
 * （调试技巧：写个构造方法并且打条件断点，查看方法栈；beanName.equals("customBeanFactoryPostProcessor")）
 * 1.入口 refresh() invokeBeanFactoryPostProcessors, 扫描target class且加到 beanDefinitionMap
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 *
 * 2.入口 第二次 getSingleton 匿名函数 createBean
 * @see org.springframework.beans.factory.support.AbstractBeanFactory#doGetBean
 *
 * 3.反射实例化， createBeanInstance(beanName, mbd, args);
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
 *
 * 4.将自定义 BeanFactoryPostProcessor 的实例 bean 加到一级缓存 addSingleton
 * @see org.springframework.beans.factory.support.DefaultSingletonBeanRegistry#addSingleton
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	public CustomBeanFactoryPostProcessor() {
		System.out.println("create CustomBeanFactoryPostProcessor");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("postProcessBeanFactory");
	}
}