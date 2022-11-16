package com.example.dddsample.domain.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

/**
 * {@link TaskEntity}
 * @author kiyota
 */
class TaskEntityTests {

    @Test
    void create() {
        TaskEntity taskEntity = TaskEntity.create("test", LocalDate.of(2022, 10, 16));
        assertThat(taskEntity.getTaskStatus()).isEqualTo(TaskStatus.OPEN);
    }
}