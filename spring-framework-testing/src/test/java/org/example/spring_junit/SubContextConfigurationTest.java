package org.example.spring_junit;

import org.example.X;
import org.example.spring_junit.ContextConfigurationTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubContextConfigurationTest extends ContextConfigurationTest {
    @Autowired
    private X x;
    @Test
    public void test() {
        Assert.assertNotNull(x);
    }
}
