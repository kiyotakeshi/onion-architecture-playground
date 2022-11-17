package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.TaskStatus;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class TaskUpdateRequestDto {

	private String name;

	@JsonAlias(value = "due_date")
	private LocalDate dueDate;

	@JsonAlias(value = "task_status")
	private TaskStatus taskStatus;

	public TaskUpdateRequestDto(String name, LocalDate dueDate, TaskStatus taskStatus) {
		this.name = name;
		this.dueDate = dueDate;
		this.taskStatus = taskStatus;
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

}
