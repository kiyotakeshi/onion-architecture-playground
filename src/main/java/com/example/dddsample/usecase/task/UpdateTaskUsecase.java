package com.example.dddsample.usecase.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.domain.task.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author kiyota
 */
@Service
public class UpdateTaskUsecase {

	private final TaskRepository taskRepository;

	public UpdateTaskUsecase(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public TaskEntity updateTask(Integer id, String name, LocalDate dueDate, TaskStatus taskStatus) {
		taskRepository.selectById(id);
		TaskEntity taskEntity = TaskEntity.reconstruct(id, name, dueDate, taskStatus);
		return taskRepository.update(taskEntity);
	}

}
