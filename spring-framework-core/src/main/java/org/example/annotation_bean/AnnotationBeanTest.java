package org.example.annotation_bean;

import junit.framework.TestCase;
import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBeanTest {

	@Test
	public void autowireCandidateFalseTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotatedBeanWithCandidate.class);
		// @Bean(autowireCandidate = false) how's work?
		// finishBeanFactoryInitialization(..): instantiate bean
		// -> getBean ...-> createBean: bean z populate bean
		// -> DefaultListableBeanFactory.findAutowireCandidates(..)
		// -> AutowireCandidateResolver.isAutowireCandidate(..)
		// -> AbstractBeanDefinition.autowireCandidate: flag is autowire candidate or not
		context.refresh();

		DebugUtils.printBeanDefinition(context, "ending");
		TestCase.assertNotNull(context.getBean(Z.class).getY());
		TestCase.assertNotNull(context.getBean("y1"));
		TestCase.assertNotNull(context.getBean("y2"));
		TestCase.assertNotSame(context.getBean(Z.class).getY(), context.getBean("y1"));
		TestCase.assertSame(context.getBean(Z.class).getY(), context.getBean("y2"));
	}

	@Test
	public void annotationScopeTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotatedBeanWithScope.class);
		context.refresh();
		// prototype scope how's work?
		// ..-> AbstractBeanFactory.doGetBean(): get from singleton map or create bean if prototype scope
		// -> AbstractBeanDefinition.scope -> create bean
		TestCase.assertNotSame(context.getBean(A.class), context.getBean(A.class));
	}

	@Test
	public void annotationBeanWithConfigTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		DebugUtils.printBeanDefinition(context, "before register");
		context.register(AnnotationBeanWithConfig.class);
		DebugUtils.printBeanDefinition(context, "before refresh");
		// invokeBeanFactoryPostProcessors() ->
		// ..-> ConfigurationClassUtils.isFullConfigurationClass(..)
		// -> ConfigurationClassPostProcessor.enhanceConfigurationClasses(..): @Configuration class new proxy instantiate
		context.refresh();
		DebugUtils.printBeanDefinition(context, "ending");
	}
}
