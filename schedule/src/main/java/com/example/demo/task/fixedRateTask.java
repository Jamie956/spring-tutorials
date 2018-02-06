package com.example.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class fixedRateTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //the beginning of the task execution doesn’t wait for the completion of the previous execution
//	@Scheduled(fixedRate = 1000)
	public void scheduleFixedRateTask() {
		try {
			System.out.println("fixedRate, sleeping 5s: " + sdf.format(new Date()));
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
