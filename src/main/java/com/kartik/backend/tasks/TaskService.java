package com.kartik.backend.tasks;

import com.kartik.backend.beans.TestBean;
import com.kartik.backend.tasks.dtos.CreateTaskDto;
import com.kartik.backend.tasks.dtos.TaskResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    TestBean testBean;
    private final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }
/*
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
     public TaskService(TaskRepository taskRepository, TestBean testBean) {
        this.taskRepository = taskRepository;
        this.testBean = testBean;
    }

 */
    public TaskResponseDto createTask(CreateTaskDto createTaskDto) {
        TaskEntity task = modelMapper.map(createTaskDto, TaskEntity.class);
        task.setCompleted(false);  // By default, a task is not completed.
        TaskEntity tasks = taskRepository.save(task);
        return modelMapper.map(tasks, TaskResponseDto.class);
    }

    public String getTestBeanName() {
        return testBean.getName();
    }

}






















/*
   - taskRepository is a dependency of TaskService. We need to inject it into TaskService.
        It should be initialized via constructor of TaskService.
 */
