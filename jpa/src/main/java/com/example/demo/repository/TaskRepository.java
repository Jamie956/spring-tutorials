package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	@Query(value = "SELECT * FROM t_task WHERE title = ?1", nativeQuery = true)
	Task oopsFindByTitle(String title);
	@Query(value = "SELECT * FROM t_task WHERE title = ?1 AND note = ?2", nativeQuery = true)
	Task oopsFindByTitleAndNote(String title, String note);
}
