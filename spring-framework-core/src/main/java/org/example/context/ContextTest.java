package org.example.context;

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
//        DebugUtils.printBeanDefinition(context, "before scan");
        //扫描包路径下的注解类, 将扫描的类 BeanDefinition 注册到 BeanDefinitionMap
        context.scan("org.example.context");
//        DebugUtils.printBeanDefinition(context, "before refresh");
        context.refresh();
//        DebugUtils.printBeanDefinition(context, "ending");
        Assert.assertNotNull(context.getBean(X.class));
        Assert.assertNotNull(context.getBean("getY"));
        context.close();
    }

    @Test
    public void classPathXmlApplicationContextTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
        Assert.assertNotNull(context.getBean(X.class));
        context.close();
    }

    @Test
    public void defaultListableBeanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //singletonObjects: custom instance put into singleton objects pool
        Z z = new Z();
        beanFactory.registerSingleton("z", z);
        Assert.assertEquals(z, beanFactory.getBean(Z.class));
    }

}
