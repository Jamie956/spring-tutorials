package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //1000 = 1s
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("current time -> " + sdf.format(new Date()));
    }
}
