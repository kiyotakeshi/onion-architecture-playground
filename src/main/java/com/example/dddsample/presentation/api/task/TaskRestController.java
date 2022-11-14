package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.usecase.task.GetTaskUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kiyota
 */
@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    private final GetTaskUsecase getTaskUsecase;

    public TaskRestController(GetTaskUsecase getTaskUsecase) {
        this.getTaskUsecase = getTaskUsecase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Integer id){
        Task task = getTaskUsecase.getTask(id);
        var taskResponseDto = new TaskResponseDto(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus());
        return ResponseEntity.ok(taskResponseDto);
    }
}
