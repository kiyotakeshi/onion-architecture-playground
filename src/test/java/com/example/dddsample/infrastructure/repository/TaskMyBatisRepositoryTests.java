package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskEntityFixture;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.domain.task.TaskStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * {@link com.example.dddsample.infrastructure.repository.TaskMyBatisRepository}
 * @author kiyota
 */
@MybatisTest
@Sql(scripts = {"classpath:db/task.sql"})
class TaskMyBatisRepositoryTests {

    private final TaskRepository sut;

    @Autowired
    TaskMyBatisRepositoryTests(TaskRepository sut) {
        this.sut = sut;
    }

    @Test
    void selectById() {
        TaskEntity task = sut.selectById(1000);
        assertThat(task).isEqualTo(TaskEntityFixture.TASK_A());
        assertThat(task.getName()).isEqualTo("test");
        assertThat(task.getDueDate()).isEqualTo(LocalDate.of(2022, 11, 17));
        assertThat(task.getTaskStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }

    @Test
    void selectById_taskNotFound() {
        assertThatThrownBy(() ->
                sut.selectById(10001)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void selectAll() {
        List<TaskEntity> tasks = sut.selectAll();
        assertThat(tasks).hasSize(3);
        assertThat(tasks.get(0)).isEqualTo(TaskEntityFixture.TASK_A());
        assertThat(tasks.get(0).getTaskStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
        assertThat(tasks.get(1).getTaskStatus()).isEqualTo(TaskStatus.OPEN);
        assertThat(tasks.get(2).getTaskStatus()).isEqualTo(TaskStatus.IN_REVIEW);
    }

    @Test
    void save() {
        TaskEntity taskEntity = TaskEntityFixture.TASK_A();
        sut.save(taskEntity);
    }

    @Test
    void deleteById() {
        sut.deleteById(1002);
    }

    @Test
    @Disabled("h2 が returning に対応していないため")
    void updateById() {
        TaskEntity taskEntity = TaskEntityFixture.TASK_A();
        TaskEntity update = sut.update(taskEntity);
        assertThat(update.getTaskStatus()).isEqualTo(TaskEntityFixture.TASK_A().getTaskStatus());
    }

    @Configuration
    @Import({TaskMyBatisRepository.class})
    @MapperScan(basePackages = "com.example.dddsample.infrastructure.repository")
    static class LocalTestContext {
    }
}
