package com.example.dddsample.infrastructure.repository.jooq;

import com.example.dddsample.domain.task.TaskStatus;
import org.jooq.impl.EnumConverter;

/**
 * @author kiyota
 */
public class TaskStatusConverter extends EnumConverter<Integer, TaskStatus> {

	public TaskStatusConverter() {
		super(Integer.class, TaskStatus.class);
	}

}
