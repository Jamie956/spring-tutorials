package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//combine @ExtendWith and @ContextConfiguration
@SpringJUnitConfig(X.class)
public class SpringJUnitConfigTest {
    @Autowired
    private X x;

    @Test
    public void test1() {
        Assert.assertEquals("foo", x.foo());
    }

}
