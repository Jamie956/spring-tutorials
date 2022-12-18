package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ActiveProfiles("test")
@SpringJUnitConfig(AppConfig2.class)
public class ActiveProfilesTest2 {
    @Autowired
    private Y y;

    @Test
    public void test1() {
        Assert.assertEquals("foo", y.foo());
    }

}
