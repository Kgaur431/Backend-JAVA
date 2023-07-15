``` 

    In the Previous section we just learned about DI framework & about Bean. 
        -  Created Bean & Tested it. Defined Bean in Main Class.
        -  Work on Notes Controller only. 
 --------------------------------------------------------------------------------------------------------
    
    In this section we will learn about 
        -  Learned about DTO 
    1. Created DTO for Task
    2. Created TaskResponseDto.
    3. In TaskController added endpoint 
        3.1 getTasks
        3.2 createTasks
        3.3. getTaskById
    4. added the ModalMapper functionality in createTask method in TaskService class.
    5. add Exception Package in Task.
        5.1 added Custom Exception for handling due date in Exception Package.
        5.2 used this exception in TaskService class while creating task.
    6. Added getTaskById() in TaskService class.
        6.1 added custom exception for handling task not found in Exception Package.
        6.2 used this exception in TaskService class while getting task by id.
    7. add Error Handler in TaskContoller becoz all of these errors can happend in controller class 
        * we can add ExceptionHandler for our project as well. read readme.md file for more info.
    8. add Common Exception Syntax (Custom Syntax) for the project in common package.
        8.1 added ErrorResponseDto class in common package.
        8.2 used this ErrorResponseDto class in TaskController class in ExceptionHandler method.
    













```