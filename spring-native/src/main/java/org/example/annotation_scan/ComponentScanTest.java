package org.example.annotation_scan;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {
	/**
	 *  scan custom define annotation
	 */
	@Test
	public void componentScanFilterTest() {
		//create internal bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//check bean definition before register annotated config class and refresh
		String[] beanDefinitionNames1 = context.getBeanDefinitionNames();
		//register annotated class
		context.register(AppConfig.class);
		context.refresh();
		//check bean definition after register and refresh
		String[] beanDefinitionNames2 = context.getBeanDefinitionNames();
		AppConfig appConfig = context.getBean(AppConfig.class);
		System.out.println(context.getBean(X.class));
	}

	/**
	 * scan exclude
	 */
	@Test
	public void scanExcludeTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig2.class);
		context.refresh();
		System.out.println(context.getBean(Y.class));
	}

}
