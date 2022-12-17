package org.example;

import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class CustomTestExecutionListener implements TestExecutionListener, Ordered {

    @Override
    public void beforeTestClass(TestContext testContext) {
        System.out.println("beforeTestClass");
    };

    @Override
    public void prepareTestInstance(TestContext testContext) {
        System.out.println("prepareTestInstance");
    };

    @Override
    public void beforeTestMethod(TestContext testContext) {
        System.out.println("beforeTestMethod");
    };

    @Override
    public void afterTestMethod(TestContext testContext) {
        System.out.println("afterTestMethod");
    };

    @Override
    public void afterTestClass(TestContext testContext) {
        System.out.println("afterTestClass");
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    };
}