package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author kiyota
 */
@ExtendWith(MockitoExtension.class)
class CreateTaskUsecaseTests {

	@InjectMocks
	private CreateTaskUsecase sut;

	@Mock
	private TaskRepository taskRepository;

	@Test
	void createTask() {
		doNothing().when(this.taskRepository).save(any());

		sut.createTask("test", LocalDate.now());

		verify(this.taskRepository, times(1)).save(isA(TaskEntity.class));
	}

}