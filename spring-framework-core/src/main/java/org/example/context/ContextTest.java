package org.example.context;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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
        //扫描包路径下的注解类, 将扫描的类 BeanDefinition 注册到 BeanDefinitionMap
        context.scan("org.example.context");
        context.refresh();
        Assert.assertNotNull(context.getBean(X.class));
        System.out.println();
    }

    @Test
    public void classPathXmlApplicationContextTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
        Assert.assertNotNull(context.getBean(EmptyObject.class));
    }

    @Test
    public void defaultListableBeanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //singletonObjects: custom instance put into singleton objects pool
        EmptyObject o = new EmptyObject();
        beanFactory.registerSingleton("o", o);
        Assert.assertEquals(o, beanFactory.getBean(EmptyObject.class));
    }

}
