package org.example.execution_listener;

import org.example.AppConfig;
import org.example.X;
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
@TestExecutionListeners(value = {
        CustomListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class ListenerTest {

    @Autowired
    private X x;

    @Test
    public void test() {
        System.out.println("-------------- execution --------------");
        Assert.assertNotNull(x);
    }

}
