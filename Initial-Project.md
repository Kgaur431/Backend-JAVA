
```
    0. add the require dependencies in build.gradle file
    1. We configure the project in application.yaml file
    2. we create the feature 
        
        2.1. create the tasks
            2.1.1. create the TaskRepository
            2.1.2. create the TaskService
            2.1.3. create the TaskController
            2.1.4. create the TaskEntity
                    - add the annotation @Entity
                    - add the fields like id, name, description, status, createdAt, updatedAt ... so on. 
        2.2 create the notes
            2.2.1. create the NoteRepository
            2.2.2. create the NoteService
            2.2.3. create the NoteController
            2.2.4. create the NoteEntity
    3. we created the Taskentity class.
    4. we used Bottom to Top Approach for writing code.
        4.1 we created the TaskRepository class.
            -  when we extending the JpaRepository then we have to make the TaskRepository interface instead of class.
            - extemds JpaRepository<TaskEntity, Long>   // two generic types T as data type and ID as primary key 
                means when we want to set JPA repository then we need to set Data type and primary key of repository.
                      based on that we can perform the CRUD operation.
            - @Repository 
                    we annotate the class with @Repository 
            - initially we are not writing any code in TaskRepository interface. 
                becoz "In SpringBoot we have concept calle SimpleJpaRepository class which has the implementation of 
                    how to implement a Repository. & SpringBoot automatically will use SimpleJpaRepository class to 
                    define our TaskRepository `if we just create/convert it to TaskRepository interface & extend the  JpaRepository`"
                like:-
                    Save a task
                    Retrieve a task by id
                    Retrieve all tasks
                    Delete a task by id ... so on. 
                        these methods automatically will generated for us with the actual code also.  
                        How that happens ?
                            becoz the code for methods are already written in JpaRepository interface.
                            so, when we extends the JpaRepository as an interface then those methods will be created for us.
        4.2 we created the TaskService class.
            - @Service
                    we annotate the class with @Service 
            - we created TaskRepository variable as internal variable. & passed it in constructor.
            
            - we not create TaskService manually 
                like TaskService taskService = new TaskService();
                becoz Spring will  automatically create the TaskService class for us.
                & when it creational then spring will inject the TaskRepository object. 
                "Spring will does by using Autowiring concept"
            - we created createTask() 
                   * we create TaskEntity object.
                   * we set the values in TaskEntity object using setter methods.
                   * we call the save() method of TaskRepository interface.
            - after doing this much we should test the code that we wrote for that 
                we need to create the TaskServiceTest class. in test folder.
                we used JPA test for testing the code.
                
            - @Autowired
                    we annotate the TaskRepository variable with @Autowired 
                    so, spring will inject the TaskRepository object in TaskService class.