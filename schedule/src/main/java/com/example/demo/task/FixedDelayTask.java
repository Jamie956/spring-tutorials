package com.example.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedDelayTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	// the previous execution is completed before running again
//	@Scheduled(fixedDelay = 2*1000)
	public void scheduleFixedDelayTask() {
		try {
			System.out.println("*********************fixedDelay, will sleeping 5s: " + sdf.format(new Date()));
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
