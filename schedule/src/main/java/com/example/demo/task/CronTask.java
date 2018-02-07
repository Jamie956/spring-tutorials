package com.example.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

//	@Scheduled(cron = "0 39 16 7 * ?") // execute in 16:35 every month, day 7
	public void scheduleTaskUsingCronExpression() {
		System.out.println("scheduleTaskUsingCronExpression:" + sdf.format(new Date()));
	}
}
