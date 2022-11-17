package com.example.dddsample.domain.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@Test
	void create_IllegalArgumentName() {
		assertThatThrownBy(() -> TaskEntity.create(null, LocalDate.of(2022, 10, 16)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void create_IllegalArgumentName2() {
		assertThatThrownBy(() -> TaskEntity.create("", LocalDate.of(2022, 10, 16)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void create_IllegalArgumentDueDate() {
		assertThatThrownBy(() -> TaskEntity.create("test", null)).isInstanceOf(IllegalArgumentException.class);
	}

}