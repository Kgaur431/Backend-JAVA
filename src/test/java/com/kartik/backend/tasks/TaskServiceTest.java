package com.kartik.backend.tasks;

import com.kartik.backend.beans.TestBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TaskServiceTest {
    @Autowired
  TaskRepository taskRepository;    // we are using @DataJpaTest, so we can only Autowire repositories not service classes || controller classes
    @Autowired
    TestBean testBean;

//    @Test                 // commented becoz we changed the constructor of TaskService
//    public void testCreateTask() {
//        TaskService taskService = new TaskService(taskRepository);
//        TaskEntity task = taskService.createTask("Test Title", "Test Description", new Date());
//        System.out.println(task);
//    }


//    @Test
//    public void  testBeanName() {
//        TaskService taskService = new TaskService(taskRepository, testBean);
//        System.out.println("**********************************************************"+taskService.getTestBeanName());
//    }

}
