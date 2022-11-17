package com.example.dddsample.infrastructure.repository;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kiyota
 */
@Repository
public class TaskMyBatisRepository implements TaskRepository {

	private final TaskMapper taskMapper;

	public TaskMyBatisRepository(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	@Override
	public TaskEntity selectById(int id) {
		Task task = taskMapper.selectById(id);
		if (task == null) {
			throw new RuntimeException();
		}
		return TaskEntity.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus());
	}

	@Override
	public List<TaskEntity> selectAll() {
		List<Task> tasks = taskMapper.selectAll();
		return tasks.stream().map(
				task -> TaskEntity.reconstruct(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus()))
				.toList();
	}

	@Override
	public void save(TaskEntity taskEntity) {
		Task task = new Task(taskEntity.getName(), taskEntity.getDueDate(), taskEntity.getTaskStatus());
		taskMapper.save(task);
	}

	@Override
	public void deleteById(Integer id) {
		taskMapper.deleteById(id);
	}

	@Override
	public TaskEntity update(TaskEntity taskEntity) {
		Task task = new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.getDueDate(),
				taskEntity.getTaskStatus());
		Task update = taskMapper.update(task);
		return TaskEntity.reconstruct(update.getId(), update.getName(), update.getDueDate(), update.getTaskStatus());
	}

}
