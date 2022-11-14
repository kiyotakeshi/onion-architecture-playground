package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.infrastructure.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

/**
 * @author kiyota
 */
@Repository
public class TaskMyBatisRepository implements TaskRepository {

    private final TaskMapper taskMapper;

    public TaskMyBatisRepository(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public Task selectById(int id) {
        var task = taskMapper.selectById(id);
        return Task.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus());
    }
}
