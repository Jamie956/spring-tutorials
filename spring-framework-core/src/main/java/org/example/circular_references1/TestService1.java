package org.example.circular_references1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService1 {

    @Autowired
    private TestService2 testService2;

    public TestService1() {
        // debug
        System.out.println();
    }

    public void test1() {
    }
}
