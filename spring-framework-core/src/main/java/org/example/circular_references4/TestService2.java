package org.example.circular_references4;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {

    public TestService2(TestService1 testService1) {
    }
}