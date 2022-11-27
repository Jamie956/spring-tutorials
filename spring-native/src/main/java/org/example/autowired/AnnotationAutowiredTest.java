package org.example.autowired;

import junit.framework.TestCase;
import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AnnotationAutowiredTest {

    @Test
    public void t1() {
        // 1.AnnotatedBeanDefinitionReader
        // -> AnnotationConfigUtils.registerAnnotationConfigProcessors(..): register post processor bean definition
        // post processor bean definition class:
        //      ConfigurationClassPostProcessor.class
        //      AutowiredAnnotationBeanPostProcessor.class
        //      CommonAnnotationBeanPostProcessor.class
        //      EventListenerMethodProcessor.class
        //      DefaultEventListenerFactory.class
        // DefaultListableBeanFactory.registerBeanDefinition(..): register bean
        // 2.new ClassPathBeanDefinitionScanner
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //register candidate beans
        DebugUtils.printBeanDefinition(context, "before scan");
        // ClassPathScanningCandidateComponentProvider.findCandidateComponents(..): path resolve finding candidate bean definition
        // post processor handle candidate bean definition
        // DefaultListableBeanFactory.registerBeanDefinition(..): register bean definition, put into bean definition map
        context.scan("org.example.autowired");
        DebugUtils.printBeanDefinition(context, "before refresh");
        // prepareRefresh(): setup context fields startupDate, closed, active, earlyApplicationListeners ...
        // obtainFreshBeanFactory(): get parent class bean factory
        // prepareBeanFactory(..): setup factory bean var
        // invokeBeanFactoryPostProcessors(..) -> PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(..): invoke post processor
        //      put object annotated @Bean into bean definition names
        // registerBeanPostProcessors(): bean post processor add to list in bean factory
        // initApplicationEventMulticaster():
        // finishBeanFactoryInitialization(): instantiate bean
        context.refresh();
        DebugUtils.printBeanDefinition(context, "ending");

        TestCase.assertNotNull(context.getBean("x"));
        TestCase.assertNotNull(context.getBean("y"));
        TestCase.assertNotNull(context.getBean("z"));
        TestCase.assertNotNull(context.getBean("x1"));
        TestCase.assertNotNull(context.getBean("x2"));
        TestCase.assertNotSame(context.getBean("x"), context.getBean("x1"));
        TestCase.assertNotSame(context.getBean("x1"), context.getBean("x2"));
    }


}