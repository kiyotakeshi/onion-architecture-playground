package com.example.dddsample.domain.task;

import org.springframework.stereotype.Repository;

/**
 * @author kiyota
 */
public interface TaskRepository {

    Task selectById(int id);
}
