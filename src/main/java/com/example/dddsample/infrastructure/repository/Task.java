package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.TaskStatus;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class Task {

	private int id;

	private String name;

	private LocalDate dueDate;

	private TaskStatus taskStatus;

	Task(String name, LocalDate dueDate, TaskStatus taskStatus) {
		this.name = name;
		this.dueDate = dueDate;
		this.taskStatus = taskStatus;
	}

	Task(int id, String name, LocalDate dueDate, TaskStatus taskStatus) {
		this.id = id;
		this.name = name;
		this.dueDate = dueDate;
		this.taskStatus = taskStatus;
	}

	public static Task createTestTask() {
		return new Task("test", LocalDate.of(2022, 11, 15), TaskStatus.OPEN);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	protected Task() {
	}

}
