package com.example.dddsample.domain.task;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author kiyota
 */
public class TaskEntity {

    private int id;
    private String name;
    private LocalDate dueDate;
    private TaskStatus taskStatus;

    private TaskEntity(String name, LocalDate dueDate, TaskStatus taskStatus) {
        this.name = name;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }
    TaskEntity(int id, String name, LocalDate dueDate, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }

    public static TaskEntity create(String name, LocalDate dueDate) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("not set name");
        }
        if(dueDate == null){
            throw new IllegalArgumentException("not set dueDate");
        }
        return new TaskEntity(name, dueDate, TaskStatus.OPEN);
    }

    public static TaskEntity reconstruct(int id, String name, LocalDate dueDate, TaskStatus status) {
        return new TaskEntity(id, name, dueDate, status);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
