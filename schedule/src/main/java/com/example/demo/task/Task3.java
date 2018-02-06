package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Task3 {

//    @Scheduled(fixedRate = 5000)
    public void job1() {
        System.out.println(Thread.currentThread() + ", job1@"  + LocalTime.now());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
    }

}
