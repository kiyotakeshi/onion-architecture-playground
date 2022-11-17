package com.example.dddsample.domain.task;

import java.time.LocalDate;

/**
 * @author kiyota
 */
public class TaskEntityFixture {

	public static TaskEntity TASK_A() {
		return new TaskEntity(1000, "test", LocalDate.of(2022, 11, 17), TaskStatus.IN_PROGRESS);
	}

	public static TaskEntity TASK_B() {
		return new TaskEntity(1001, "sample", LocalDate.of(2022, 11, 13), TaskStatus.OPEN);
	}

}
