package com.example.dddsample.presentation.api.task;

import com.example.dddsample.domain.task.Task;
import com.example.dddsample.usecase.task.CreateTaskUsecase;
import com.example.dddsample.usecase.task.GetTaskUsecase;
import com.example.dddsample.usecase.task.GetTasksUsecase;
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

    public TaskRestController(GetTaskUsecase getTaskUsecase, GetTasksUsecase getTasksUsecase, CreateTaskUsecase createTaskUsecase) {
        this.getTaskUsecase = getTaskUsecase;
        this.getTasksUsecase = getTasksUsecase;
        this.createTaskUsecase = createTaskUsecase;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks(){
        List<Task> tasks = getTasksUsecase.getTasks();
        var taskResponseDtos = tasks.stream()
                .map(task ->
                        new TaskResponseDto(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus()))
                .toList();
        return ResponseEntity.ok(taskResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Integer id){
        Task task = getTaskUsecase.getTask(id);
        var taskResponseDto = new TaskResponseDto(task.getId(), task.getName(), task.getDueDate(), task.getTaskStatus());
        return ResponseEntity.ok(taskResponseDto);
    }

    @PostMapping
    public ResponseEntity<Void> saveTask(@RequestBody TaskRequestDto taskRequestDto){
        createTaskUsecase.createTask(taskRequestDto.getName(), taskRequestDto.getDueDate());
        return ResponseEntity.ok().build();
    }
}
