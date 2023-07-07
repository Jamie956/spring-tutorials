package org.example.construct2;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class InferConstructTest {
	@Test
	public void test() {
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(X.class);
		context.registerBean(Y.class);
		context.registerBean(EmptyObject.class);
		context.refresh();

		Assert.assertNotNull(context.getBean(X.class));
		Assert.assertNotNull(context.getBean(Y.class));
	}
}