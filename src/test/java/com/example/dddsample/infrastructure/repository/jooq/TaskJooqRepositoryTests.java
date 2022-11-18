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

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link com.example.dddsample.infrastructure.repository.jooq.TaskJooqRepository}
 * https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#features.testing.spring-boot-applications.autoconfigured-jooq
 * https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#appendix.test-auto-configuration.slices
 *
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

	@Test
	void selectAll() {
		List<TaskEntity> actual = sut.selectAll();
		assertThat(actual).hasSize(3);
	}

	@Test
	void save() {
		TaskEntity taskEntity = TaskEntity.create("sample", LocalDate.of(2022, 11, 18));
		sut.save(taskEntity);
	}

	@Test
	void deleteById() {
		sut.deleteById(1000);
	}

	@Test
	void update() {
		TaskEntity taskEntity = TaskEntityFixture.TASK_A();
		TaskEntity update = sut.update(taskEntity);
		assertThat(update.getTaskStatus()).isEqualTo(TaskEntityFixture.TASK_A().getTaskStatus());
	}

	@Configuration
	@Import({ TaskJooqRepository.class })
	static class LocalTestContext {

	}

}