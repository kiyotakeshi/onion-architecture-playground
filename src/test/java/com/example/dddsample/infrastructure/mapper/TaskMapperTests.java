package com.example.dddsample.infrastructure.mapper;

import com.example.dddsample.domain.task.TaskStatus;
import com.example.dddsample.infrastructure.repository.Task;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author kiyota
 */
@MybatisTest
class TaskMapperTests {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void selectById() {
        Task task = taskMapper.selectById(1);
        assertThat(task.getId()).isEqualTo(1);
        assertThat(task.getName()).isEqualTo("test");
        assertThat(task.getDueDate()).isEqualTo(LocalDate.of(2022,11,14));
        assertThat(task.getTaskStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }

    @Test
    void selectAll() {
        List<Task> tasks = taskMapper.selectAll();
        assertThat(tasks).hasSize(3);
        assertThat(tasks.get(0).getTaskStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
        assertThat(tasks.get(1).getTaskStatus()).isEqualTo(TaskStatus.OPEN);
        assertThat(tasks.get(2).getTaskStatus()).isEqualTo(TaskStatus.IN_REVIEW);
    }
}
