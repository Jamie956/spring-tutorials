package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExtendContextConfigurationTest extends ContextConfigurationTest {

    @Autowired
    private X x;

    @Test
    public void test1() {
        Assert.assertEquals("foo", x.foo());
    }

}
