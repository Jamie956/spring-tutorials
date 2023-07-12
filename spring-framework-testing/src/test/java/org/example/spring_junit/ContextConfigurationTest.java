package org.example.spring_junit;

import org.example.AppConfig;
import org.example.X;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class ContextConfigurationTest {
    @Autowired
    private X x;
    @Test
    public void test() {
        Assert.assertNotNull(x);
    }
}