package com.example.demo;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.task.AsyncTask;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void asyncTest() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> t1 = asyncTask.doTaskOne();
		Future<String> t2 = asyncTask.doTaskTwo();
		Future<String> t3 = asyncTask.doTaskThree();

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
