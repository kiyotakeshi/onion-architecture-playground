package com.example.dddsample.domain.task;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kiyota
 */
public interface TaskRepository {
    Task selectById(int id);
    List<Task> selectAll();
    void save(Task task);
}
