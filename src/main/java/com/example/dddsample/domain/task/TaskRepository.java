package com.example.dddsample.domain.task;

import java.util.List;

/**
 * @author kiyota
 */
public interface TaskRepository {
    TaskEntity selectById(int id);
    List<TaskEntity> selectAll();
    void save(TaskEntity taskEntity);
    void deleteTask(Integer id);

    com.example.dddsample.infrastructure.repository.Task update(TaskEntity taskEntity);
}
