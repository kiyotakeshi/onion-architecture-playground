package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskRepository;
import org.springframework.stereotype.Service;

/**
 * @author kiyota
 */
@Service
public class DeleteTaskUsecase {

    private final TaskRepository taskRepository;

    public DeleteTaskUsecase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteTask(id);
    }
}
