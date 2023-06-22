package org.example.annotation_autowired;

import org.example.utils.DebugUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAutowiredTest {

    @Test
    public void test() {
        // Debug AnnotationConfigUtils.registerAnnotationConfigProcessors:
        //      register Spring internal bean include AutowiredAnnotationBeanPostProcessor
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        DebugUtils.printBeanDefinition(context, "created context");

        // Debug ClassPathScanningCandidateComponentProvider.findCandidateComponents:
        //      path resolve finding candidate bean definition
        // Debug ClassPathBeanDefinitionScanner.registerBeanDefinition:
        //      register bean definition
        context.scan("org.example.annotation_autowired");
        DebugUtils.printBeanDefinition(context, "finished scan");

        // Debug Z#setX: when populate bean
        // Instantiate Bean
        context.refresh();
        DebugUtils.printBeanDefinition(context, "done");

        Assert.assertNotNull(context.getBean("x"));
        Assert.assertNotNull(context.getBean("y"));
        Assert.assertNotNull(context.getBean("z"));
    }

}