package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.TaskStatus;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class TaskRequestDto {
    private String name;

    @JsonAlias(value = "due_date")
    private LocalDate dueDate;

    public TaskRequestDto(String name, LocalDate dueDate, TaskStatus taskStatus) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
