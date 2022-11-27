package org.example.annotation_scan;

import junit.framework.TestCase;
import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {
	/**
	 *  @ComponentScan include filters custom define annotation
	 */
	@Test
	public void componentScanIncludeFiltersTest() {
		//register internal post processor bean definition
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		DebugUtils.printBeanDefinition(context, "before register");
		//register annotated config class
		context.register(AppConfig.class);
		DebugUtils.printBeanDefinition(context, "before refresh");
		// invokeBeanFactoryPostProcessors()
		// -> ConfigurationClassParser.doProcessConfigurationClass(..): parse @ComponentScan
		// -> ComponentScanAnnotationParser.parse(..): parse @ComponentScan include filter and doScan()
		context.refresh();
		DebugUtils.printBeanDefinition(context, "ending");

		TestCase.assertNotNull(context.getBean(AppConfig.class));
		TestCase.assertNotNull(context.getBean(X.class));
		TestCase.assertNotNull(context.getBean(Y.class));
		TestCase.assertNotNull(context.getBean(Z.class));
	}

	@Test
	public void scanExcludeTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		DebugUtils.printBeanDefinition(context, "before register");
		context.register(AppConfig2.class);
		DebugUtils.printBeanDefinition(context, "before refresh");
		context.refresh();
		DebugUtils.printBeanDefinition(context, "ending");
	}

}
