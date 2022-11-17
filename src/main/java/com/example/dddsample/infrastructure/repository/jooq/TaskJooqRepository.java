package com.example.dddsample.infrastructure.repository.jooq;

import com.example.dddsample.domain.task.TaskEntity;
import com.example.dddsample.domain.task.TaskRepository;
import com.example.dddsample.domain.task.TaskStatus;
import com.example.jooq.codegen.tables.records.TaskRecord;
import org.jooq.DSLContext;
import org.jooq.impl.EnumConverter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.example.jooq.codegen.tables.pojos.Task;
import java.util.List;

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
		TaskRecord taskRecord = this.create.selectFrom(TASK).where(TASK.ID.eq(id)).fetchSingle();
		return TaskEntity.reconstruct(taskRecord.getId(), taskRecord.getName(), taskRecord.getDueDate(),
				taskRecord.getTaskStatus());
	}

	@Override
	public List<TaskEntity> selectAll() {
		return null;
	}

	@Override
	public void save(TaskEntity taskEntity) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public TaskEntity update(TaskEntity taskEntity) {
		return null;
	}

}
