package org.example.spring_junit;

import org.example.AppConfigWithProfile;
import org.example.X;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ActiveProfiles("dev")
@SpringJUnitConfig(AppConfigWithProfile.class)
public class ActiveProfilesTest {
    @Autowired
    private X x;
    @Test
    public void test1() {
        Assert.assertNotNull(x);
    }
}