package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskEntityFixture;
import com.example.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * {@link * {@link com.example.dddsample.usecase.task.GetTasksUsecase}
 *
 * @author kiyota
 */
@ExtendWith(MockitoExtension.class)
class GetTasksUsecaseTests {

	@InjectMocks
	GetTasksUsecase sut;

	@Mock
	TaskRepository taskRepository;

	@Test
	void getTasks() {
		List<TaskEntity> taskEntities = List.of(TaskEntityFixture.TASK_A(), TaskEntityFixture.TASK_B());
		when(taskRepository.selectAll()).thenReturn(taskEntities);

		List<TaskEntity> actual = sut.getTasks();

		verify(taskRepository, times(1)).selectAll();
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0)).isEqualTo(TaskEntityFixture.TASK_A());
	}

}