package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
// listen test class life cycle
@TestExecutionListeners(value = {
        CustomTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class TestExecutionListenersTest {

    @Autowired
    private X x;

    @Test
    public void test1() {
        System.out.println("--------------");
        Assert.assertEquals("foo", x.foo());
    }

}
