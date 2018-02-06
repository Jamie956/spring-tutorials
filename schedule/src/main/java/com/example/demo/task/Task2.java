package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Task2 {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	
//	@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {
		System.out.println("*********************Fixed delay task - " + sdf.format(new Date()));
	}
	
	
	//The task will be executed a first time after the initialDelay value – and it will continue to be executed according to the fixedDelay
//	@Scheduled(fixedDelay = 1000, initialDelay = 5*1000)
	public void scheduleFixedRateWithInitialDelayTask() {
	    System.out.println("Fixed rate task with one second initial delay - " + sdf.format(new Date()));
	}

}
