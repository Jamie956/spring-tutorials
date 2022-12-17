package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "/spring-config.xml")
public class ContextConfigurationWithXmlTest {
    @Autowired
    private X x;

    @Test
    public void test1() {
        Assert.assertEquals("foo", x.foo());
    }
}
