package com.example.dddsample.infrastructure.mapper;

import com.example.dddsample.domain.task.TaskStatus;
import com.example.dddsample.infrastructure.repository.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kiyota
 */
@MybatisTest
class TaskMapperTests {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void selectById() {
        Task task = taskMapper.selectById(1);
        assertThat(task.getId()).isEqualTo(1);
        assertThat(task.getName()).isEqualTo("test");
        assertThat(task.getDueDate()).isEqualTo(LocalDate.of(2022,11,14));
        assertThat(task.getTaskStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }
}
