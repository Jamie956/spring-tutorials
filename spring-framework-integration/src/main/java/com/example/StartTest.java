package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@EnableAsync
public class StartTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example");
        AsyncTask task = ctx.getBean(AsyncTask.class);

        long start = System.currentTimeMillis();

        Future<String> t1 = task.doTaskOne();
        Future<String> t2 = task.doTaskTwo();
        Future<String> t3 = task.doTaskThree();

        while (true) {
            if (t1.isDone() && t2.isDone() && t3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("total spend -> " + (end - start) + "ms");
    }
}
