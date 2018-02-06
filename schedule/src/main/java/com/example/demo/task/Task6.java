package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class Task6 {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(fixedDelay = 1000)
	public void job1() {
		task1();
	}

//	@Scheduled(fixedDelay = 5*1000)
	public void job2() {
		task2();
	}

	public void task1() {
		int i = (int) (Math.random() * 2);
		if (i == 1) {
			System.out.println("*************************Need to migration: " + sdf.format(new Date()));
		} else {
			try {
				System.out.println("*************************No need to migration, sleeping 10s: " + sdf.format(new Date()));
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void task2() {
		int i = (int) (Math.random() * 2);
		if (i == 1) {
			System.out.println("Need to sync changed data: " + sdf.format(new Date()));
		} else {
			try {
				System.out.println("Changed data is null, sleeping 20s: " + sdf.format(new Date()));
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
