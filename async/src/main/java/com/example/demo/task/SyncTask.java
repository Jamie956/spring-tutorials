package com.example.demo.task;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SyncTask {
	public static Random random = new Random();

	public void doTaskOne() throws Exception {
		System.out.println("begin task 1");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("finished task 1, spend time -> " + (end - start) + "ms");
	}

	public void doTaskTwo() throws Exception {
		System.out.println("begin task 2");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("finished task 2, spend time -> " + (end - start) + "ms");
	}

	public void doTaskThree() throws Exception {
		System.out.println("begin task 3");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("finished task 3, spend time -> " + (end - start) + "ms");
	}
}
