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
