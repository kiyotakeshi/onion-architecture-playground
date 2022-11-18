package com.example.dddsample.infrastructure.repository.jooq;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.jooq.codegen.tables.records.TaskRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.jooq.codegen.tables.Task.TASK;

/**
 * @author kiyota
 */
@Primary
@Repository
public class TaskJooqRepository implements TaskRepository {

	// https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jooq.dslcontext
	private final DSLContext create;

	public TaskJooqRepository(DSLContext create) {
		this.create = create;
	}

	@Override
	public TaskEntity selectById(int id) {
		TaskRecord taskRecord = this.create //
				.selectFrom(TASK) //
				.where(TASK.ID.eq(id)) //
				.fetchSingle();

		return TaskEntity //
				.reconstruct(taskRecord.getId(), taskRecord.getName(), taskRecord.getDueDate(),
						taskRecord.getTaskStatus());
	}

	@Override
	public List<TaskEntity> selectAll() {
		Result<TaskRecord> taskRecords = this.create.selectFrom(TASK).fetch();

		return taskRecords.stream() //
				.map(record -> TaskEntity.reconstruct( //
						record.getId(), record.getName(), record.getDueDate(), record.getTaskStatus())) //
				.collect(Collectors.toList());
	}

	@Override
	public void save(TaskEntity taskEntity) {
		// https://www.jooq.org/doc/latest/manual/sql-building/sql-statements/insert-statement/insert-values/#insert-values-with-a-single-row
		this.create.insertInto(TASK, TASK.NAME, TASK.DUE_DATE, TASK.TASK_STATUS) //
				.values(taskEntity.getName(), taskEntity.getDueDate(), taskEntity.getTaskStatus()) //
				.execute();
	}

	@Override
	public void deleteById(Integer id) {
		create.delete(TASK) //
				.where(TASK.ID.eq(id)) //
				.execute();
	}

	@Override
	public TaskEntity update(TaskEntity taskEntity) {
		TaskRecord taskRecord = create.update(TASK) //
				.set(TASK.NAME, taskEntity.getName()) //
				.set(TASK.DUE_DATE, taskEntity.getDueDate()) //
				.set(TASK.TASK_STATUS, taskEntity.getTaskStatus()) //
				.where(TASK.ID.eq(taskEntity.getId())) //
				.returning().fetchSingle();

		return TaskEntity //
				.reconstruct(taskRecord.getId(), taskRecord.getName(), taskRecord.getDueDate(),
						taskRecord.getTaskStatus());
	}

}
