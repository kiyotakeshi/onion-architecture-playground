package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.infrastructure.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Task> selectAll() {
        var tasks = taskMapper.selectAll();
        return tasks.stream()
                .map(task ->
                        Task.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus()))
                .toList();
    }

    @Override
    public void save(Task task) {
        var task1 = new com.example.dddsample.infrastructure.repository.Task(task.getName(), task.getDueDate(), task.getTaskStatus());
        taskMapper.save(task1);
    }
}
