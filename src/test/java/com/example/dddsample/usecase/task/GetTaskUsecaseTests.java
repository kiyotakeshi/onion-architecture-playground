package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskEntityFixture;
import com.example.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * {@link com.example.dddsample.usecase.task.GetTaskUsecase}
 * @author kiyota
 */
@ExtendWith(MockitoExtension.class)
class GetTaskUsecaseTests {

	@InjectMocks
	GetTaskUsecase sut;

	@Mock
	TaskRepository taskRepository;

	@Test
	void getTask() {
		TaskEntity taskEntity = TaskEntityFixture.TASK_A();
		when(taskRepository.selectById(anyInt())).thenReturn(taskEntity);

		TaskEntity actual = sut.getTask(1);

		verify(taskRepository, times(1)).selectById(eq(1));
		assertThat(actual).isEqualTo(taskEntity);
	}

}