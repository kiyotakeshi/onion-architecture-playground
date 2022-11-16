package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
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
    public TaskEntity selectById(int id) {
        var task = taskMapper.selectById(id);
        return TaskEntity.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus());
    }

    @Override
    public List<TaskEntity> selectAll() {
        var tasks = taskMapper.selectAll();
        return tasks.stream()
                .map(task ->
                        TaskEntity.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus()))
                .toList();
    }

    @Override
    public void save(TaskEntity taskEntity) {
        var task1 = new Task(taskEntity.getName(), taskEntity.getDueDate(), taskEntity.getTaskStatus());
        taskMapper.save(task1);
    }

    @Override
    public void deleteTask(Integer id) {
        taskMapper.deleteById(id);
    }

    @Override
    public Task update(TaskEntity taskEntity) {
        Task task1 = new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.getDueDate(), taskEntity.getTaskStatus());
        return taskMapper.update(task1);
    }
}
