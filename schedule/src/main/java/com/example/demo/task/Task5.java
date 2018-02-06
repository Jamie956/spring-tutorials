package com.example.demo.task;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class Task5 {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(fixedRate = 1000)
	public void job1() {
		// System.out.println(Thread.currentThread() + ", 1 ~ " + LocalTime.now());
//		System.out.println("current time -> " + sdf.format(new Date()));
//		System.out.println();
		int i = (int) (Math.random() * 2);
		if (i == 1) {
			System.out.println("*************************Need to migration: "+sdf.format(new Date()));
		} else {
			try {
				System.out.println("*************************No need to migration, sleeping 10s: "+sdf.format(new Date()));
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	@Scheduled(fixedRate = 5000)
	public void job2() {
//		System.out.println(Thread.currentThread() + ", 2 ~ " + LocalTime.now());
		System.out.println("Sync changed data: "+sdf.format(new Date()));
	}

}
