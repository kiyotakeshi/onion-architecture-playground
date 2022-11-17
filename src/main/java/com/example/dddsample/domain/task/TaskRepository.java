package com.example.dddsample.domain.task;

import java.util.List;

/**
 * @author kiyota
 */
public interface TaskRepository {
    TaskEntity selectById(int id);
    List<TaskEntity> selectAll();
    void save(TaskEntity taskEntity);
    void deleteById(Integer id);

    TaskEntity update(TaskEntity taskEntity);
}
