package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTest {
	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void save() {
		Task t = taskRepository.save(new Task("GOHome", "doing"));
		System.out.println("t => "+t);
	}

	@Test
	public void findByTitle() {
		Task t = taskRepository.oopsFindByTitle("GoHome");
		System.out.println("t => "+t);
	}
	
	@Test
	public void findByTitleAndNote() {
		Task t = taskRepository.oopsFindByTitleAndNote("GoHome", "doing");
		System.out.println("t => "+t);
	}
	
}
