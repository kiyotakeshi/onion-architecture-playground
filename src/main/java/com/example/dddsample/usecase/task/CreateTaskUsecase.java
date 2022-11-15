package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.domain.task.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @author kiyota
 */
@Service
public class CreateTaskUsecase {

    private final TaskRepository taskRepository;

    public CreateTaskUsecase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void createTask(String name, LocalDate dueDate){
        Task task = Task.create(name, dueDate);
        taskRepository.save(task);
    }
}
