package com.kartik.backend.tasks;

import com.kartik.backend.common.ErrorResponseDto;
import com.kartik.backend.tasks.dtos.CreateTaskDto;
import com.kartik.backend.tasks.dtos.TaskResponseDto;
import com.kartik.backend.tasks.exceptions.DueDateException;
import com.kartik.backend.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @GetMapping("")
//    public String getTasks() {
//        return taskService.getTasks();
//    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto createTaskDto) {
        TaskResponseDto TaskResponse = taskService.createTask(createTaskDto);
        return ResponseEntity.created(URI.create("http://localhost:8383/tasks/" + TaskResponse.getId())).body(TaskResponse);
    }

    @GetMapping("/{id}")
    public TaskResponseDto getTask(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }

    @ExceptionHandler({ TaskNotFoundException.class, DueDateException.class })
    public ResponseEntity<ErrorResponseDto> handlingException(Exception e){
        if(e instanceof TaskNotFoundException)
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body( new ErrorResponseDto(e.getMessage()));
        else if(e instanceof DueDateException)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorResponseDto(e.getMessage()));
        return ResponseEntity.badRequest().body( new ErrorResponseDto(e.getMessage()));
    }

}


