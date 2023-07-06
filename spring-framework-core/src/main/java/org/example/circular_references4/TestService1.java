package org.example.circular_references4;

import org.springframework.stereotype.Service;

@Service
public class TestService1 {

    public TestService1(TestService2 testService2) {
    }
}
