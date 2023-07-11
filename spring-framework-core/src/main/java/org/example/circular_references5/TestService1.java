package org.example.circular_references5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class TestService1 {

//    @Lazy
    @Autowired
    private TestService2 testService2;

    @Async
    public void test1() {
    }
}
