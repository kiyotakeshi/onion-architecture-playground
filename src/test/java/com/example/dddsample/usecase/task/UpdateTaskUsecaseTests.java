package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskEntityFixture;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.domain.task.TaskStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * {@link com.example.dddsample.usecase.task.UpdateTaskUsecase}
 * @author kiyota
 */
@ExtendWith(MockitoExtension.class)
class UpdateTaskUsecaseTests {

	@InjectMocks
	UpdateTaskUsecase sut;

	@Mock
	TaskRepository taskRepository;

	@Test
	void updateTask() {
		TaskEntity taskEntity = TaskEntityFixture.TASK_A();
		when(taskRepository.selectById(anyInt())).thenReturn(taskEntity);
		when(taskRepository.update(isA(TaskEntity.class))).thenReturn(taskEntity);

		sut.updateTask(1, "sample", LocalDate.now(), TaskStatus.IN_PROGRESS);

		verify(taskRepository, times(1)).selectById(eq(1));
		verify(taskRepository, times(1)).update(isA(TaskEntity.class));
	}

}