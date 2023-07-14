package com.kartik.backend.tasks;

import com.kartik.backend.tasks.dtos.CreateTaskDto;
import com.kartik.backend.tasks.dtos.TaskResponseDto;
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

//    @GetMapping("/{id}")
//    public String getTask(@PathVariable("id") String id) {
//        return taskService.getTask(id);
//    }

}
