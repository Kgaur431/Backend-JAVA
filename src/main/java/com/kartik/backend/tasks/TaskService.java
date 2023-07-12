package com.kartik.backend.tasks;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(String title, String description, Date dueDate) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(false);  // By default, a task is not completed.

        return taskRepository.save(task);
    }




}




















/*
   - taskRepository is a dependency of TaskService. We need to inject it into TaskService.
        It should be initialized via constructor of TaskService.
 */
