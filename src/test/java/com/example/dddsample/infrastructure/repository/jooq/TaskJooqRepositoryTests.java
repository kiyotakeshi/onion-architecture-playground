package com.example.dddsample.infrastructure.repository.jooq;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskEntityFixture;
import com.example.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kiyota
 */
@JooqTest
@Sql(scripts = { "classpath:db/task.sql" })
class TaskJooqRepositoryTests {

	private final TaskRepository sut;

	@Autowired
	TaskJooqRepositoryTests(TaskRepository sut) {
		this.sut = sut;
	}

	@Test
	void selectById() {
		TaskEntity actual = sut.selectById(1000);
		assertThat(actual).isEqualTo(TaskEntityFixture.TASK_A());
		assertThat(actual.getName()).isEqualTo(TaskEntityFixture.TASK_A().getName());
		assertThat(actual.getDueDate()).isEqualTo(TaskEntityFixture.TASK_A().getDueDate());
		assertThat(actual.getTaskStatus()).isEqualTo(TaskEntityFixture.TASK_A().getTaskStatus());
	}

	@Configuration
	@Import({ TaskJooqRepository.class })
	static class LocalTestContext {

	}

}