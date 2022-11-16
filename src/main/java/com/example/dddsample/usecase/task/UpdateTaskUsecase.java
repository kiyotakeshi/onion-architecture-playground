package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.domain.task.TaskStatus;
import com.example.dddsample.infrastructure.repository.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author kiyota
 */
@Service
public class UpdateTaskUsecase {

    private final TaskRepository taskRepository;

    public UpdateTaskUsecase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity updateTask(Integer id, String name, LocalDate dueDate, TaskStatus taskStatus) {
        TaskEntity found = taskRepository.selectById(id);
        if (found == null) {
            throw new RuntimeException();
        }
        TaskEntity taskEntity = TaskEntity.reconstruct(id, name, dueDate, taskStatus);
        Task update = taskRepository.update(taskEntity);
        return TaskEntity.reconstruct(update.getId(), update.getName(), update.getDueDate(), update.getTaskStatus());
    }
}
