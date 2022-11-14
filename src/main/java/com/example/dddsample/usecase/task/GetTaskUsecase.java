package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.domain.task.TaskRepository;
import org.springframework.stereotype.Service;

/**
 * @author kiyota
 */
@Service
public class GetTaskUsecase {

    private final TaskRepository taskRepository;

    public GetTaskUsecase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Integer id) {
        return taskRepository.selectById(id);
    }
}
