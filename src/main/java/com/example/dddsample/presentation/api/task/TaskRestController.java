package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.usecase.task.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kiyota
 */
@RestController
@RequestMapping("/tasks")
public class TaskRestController {

	private final GetTaskUsecase getTaskUsecase;

	private final GetTasksUsecase getTasksUsecase;

	private final CreateTaskUsecase createTaskUsecase;

	private final UpdateTaskUsecase updateTaskUsecase;

	private final DeleteTaskUsecase deleteTaskUsecase;

	public TaskRestController(GetTaskUsecase getTaskUsecase, GetTasksUsecase getTasksUsecase,
			CreateTaskUsecase createTaskUsecase, UpdateTaskUsecase updateTaskUsecase,
			DeleteTaskUsecase deleteTaskUsecase) {
		this.getTaskUsecase = getTaskUsecase;
		this.getTasksUsecase = getTasksUsecase;
		this.createTaskUsecase = createTaskUsecase;
		this.updateTaskUsecase = updateTaskUsecase;
		this.deleteTaskUsecase = deleteTaskUsecase;
	}

	@GetMapping
	public ResponseEntity<List<TaskResponseDto>> getTasks() {
		List<TaskEntity> taskEntities = getTasksUsecase.getTasks();
		var taskResponseDtos = taskEntities.stream()
				.map(task -> new TaskResponseDto(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus()))
				.toList();
		return ResponseEntity.ok(taskResponseDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskResponseDto> getTask(@PathVariable Integer id) {
		TaskEntity taskEntity = getTaskUsecase.getTask(id);
		var taskResponseDto = new TaskResponseDto(taskEntity.getId(), taskEntity.getName(), taskEntity.getDueDate(),
				taskEntity.getTaskStatus());
		return ResponseEntity.ok(taskResponseDto);
	}

	@PostMapping
	public ResponseEntity<Void> saveTask(@RequestBody TaskCreateRequestDto taskCreateRequestDto) {
		createTaskUsecase.createTask(taskCreateRequestDto.getName(), taskCreateRequestDto.getDueDate());
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Integer id,
			@RequestBody TaskUpdateRequestDto taskUpdateRequestDto) {
		TaskEntity taskEntity = updateTaskUsecase.updateTask(id, taskUpdateRequestDto.getName(),
				taskUpdateRequestDto.getDueDate(), taskUpdateRequestDto.getTaskStatus());
		var taskResponseDto = new TaskResponseDto(taskEntity.getId(), taskEntity.getName(), taskEntity.getDueDate(),
				taskEntity.getTaskStatus());
		return ResponseEntity.ok(taskResponseDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
		deleteTaskUsecase.deleteTask(id);
		return ResponseEntity.ok().build();
	}

}
