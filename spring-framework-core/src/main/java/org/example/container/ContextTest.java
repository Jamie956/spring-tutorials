package org.example.container;

import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextTest {

    /**
     * new AnnotationConfigApplicationContext()
     * 1.AnnotationConfigApplicationContext -> GenericApplicationContext -> AbstractApplicationContext -> DefaultResourceLoader
     * @see org.springframework.context.support.GenericApplicationContext#GenericApplicationContext()
     * 2.initial processors
     * @see org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(BeanDefinitionRegistry, Object)
     * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#registerBeanDefinition
     *
     * context.scan()
     * 1.doScan step findCandidateComponents: scan path
     * 2.doScan step registerBeanDefinition: BeanDefinition put into BeanDefinitionMap
     * @see org.springframework.context.annotation.ClassPathBeanDefinitionScanner#doScan
     *
     * context.refresh()
     */
    @Test
    public void annotationConfigApplicationContextTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        DebugUtils.printBeanDefinition(context, "before scan");
        //扫描包路径下的注解类, 将扫描的类 BeanDefinition 注册到 BeanDefinitionMap
        context.scan("org.example.container");
        DebugUtils.printBeanDefinition(context, "before refresh");
        context.refresh();
        DebugUtils.printBeanDefinition(context, "ending");
        context.close();
    }

    @Test
    public void classPathXmlApplicationContextTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
        DebugUtils.printBeans(context, "after new context");
        context.close();
    }

    @Test
    public void defaultListableBeanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //singletonObjects: custom instance put into singleton objects pool
        beanFactory.registerSingleton("z", new Z());

        System.out.println(beanFactory.getBean(Z.class));
    }

    @Test
    public void defaultListableBeanFactoryTest2() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Z.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //custom bean definition put into bean definition map
        beanFactory.registerBeanDefinition("z", beanDefinition);

        System.out.println(beanFactory.getBean(Z.class));
    }
}
