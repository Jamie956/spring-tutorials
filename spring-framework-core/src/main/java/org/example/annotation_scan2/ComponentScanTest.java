package org.example.annotation_scan2;

import junit.framework.TestCase;
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
		//register annotated config class
		context.register(ConfigIncludeFilters.class);
		// invokeBeanFactoryPostProcessors()
		// -> ConfigurationClassParser.doProcessConfigurationClass(..): parse @ComponentScan
		// -> ComponentScanAnnotationParser.parse(..): parse @ComponentScan include filter and doScan()
		context.refresh();

		TestCase.assertNotNull(context.getBean(X.class));
	}
}
