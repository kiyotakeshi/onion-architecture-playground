package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * @author kiyota
 */
@ExtendWith(MockitoExtension.class)
class DeleteTaskUsecaseTests {

	@InjectMocks
	DeleteTaskUsecase sut;

	@Mock
	TaskRepository taskRepository;

	@Test
	void deleteTask() {
		doNothing().when(this.taskRepository).deleteById(anyInt());

		sut.deleteTask(1);

		verify(taskRepository, times(1)).deleteById(eq(1));
	}

}