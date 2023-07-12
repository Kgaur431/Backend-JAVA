package com.kartik.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Building a "Task Manager API" that does the following things:
    1. Create a Task with the following fields:
        - Title
        - Due Date
        - Status (Pending, In Progress, Done)
    2. Update a Task
    3. Delete a Task
    4. List all Tasks
*/

@RestController
@RequestMapping("/task")
public class TaskControllers {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}

