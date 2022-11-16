package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.TaskStatus;
import org.junit.jupiter.api.Disabled;
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
class TaskEntityMapperTests {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void selectById() {
        Task task = taskMapper.selectById(1000);
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

    @Test
    void save() {
        taskMapper.save(Task.createTestTask());
    }

    @Test
    void deleteById() {
        taskMapper.deleteById(1002);
    }

    @Test
    @Disabled("h2 が returning に対応していないため")
    void updateById() {
        Task found = taskMapper.selectById(1000);
        Task task = new Task(found.getId(), "test", LocalDate.of(2022, 11, 16), TaskStatus.IN_PROGRESS);
        taskMapper.update(task);
    }
}
