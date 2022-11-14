package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.TaskStatus;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class TaskResponseDto {
    private int id;
    private String name;
    private LocalDate dueDate;
    private TaskStatus taskStatus;

    public TaskResponseDto(int id, String name, LocalDate dueDate, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
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
}
