package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_task")
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String note;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(String title, String note) {
		super();
		this.title = title;
		this.note = note;
	}
	public Task(Long id, String title, String note) {
		super();
		this.id = id;
		this.title = title;
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", note=" + note + "]";
	}

}
