package com.example.dddsample.domain.task;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class Task {

    private int id;
    private String name;
    private LocalDate dueDate;
    private TaskStatus taskStatus;

    private Task(int id, String name, LocalDate dueDate, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }

    public static Task create(String name, LocalDate dueDate) {
        if(name == null || dueDate == null) {
            throw new IllegalArgumentException("not set requirement");
        }
        return new Task(1, name, dueDate, TaskStatus.OPEN);
    }

    public static Task reconstruct(int id, String name, LocalDate dueDate, TaskStatus status) {
        return new Task(id, name, dueDate, status);
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
