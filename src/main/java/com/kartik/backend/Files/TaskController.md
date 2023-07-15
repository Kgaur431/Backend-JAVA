

``` 
        public TaskResponseDto createTask(@RequestBody CreateTaskDto createTaskDto) {
        return taskService.createTask(createTaskDto);
           }
              instead of using above code we used below code
      
        public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto createTaskDto) {
            TaskResponseDto TaskResponse = taskService.createTask(createTaskDto);
            return ResponseEntity.created(URI.create("http://localhost:8383/tasks/" + TaskResponse.getId())).body(TaskResponse);
        }

           The reason why we are using below code is because instead of sending back the normal response 
              we are sending back the response with the status code and the response body
              so that we send formatted respone to the client with the location:- URI of the created task
              like cliend will get to know that "is the task created or not & if yes then where the task has been created"    
      ---------------------------------------------------------------------------------------------------------------------------------------      
        * by using this ExceptionHandler Client will never know the Tech Stack like in which technology the project is build. 
    - ExceptionHandler:-
                " When any of my code(any method) apart from ExceptionHandler fun encounters an exception then 
                   this handlingException method will be called. "
                - this is common exception handing fun which handle all exception that happens accross the controller.

         Case 1:- if we not use the below ExceptionHanler in the Controller Class then we get very Huge Error with unnecessary details 
                    Code:-
                            @ExceptionHandler({ TaskNotFoundException.class, DueDateException.class })
                            public ResponseEntity<String> handlingException(Exception e){
                                return ResponseEntity.badRequest().body(e.getMessage());
                            }
                
                Output:-      
                    "timestamp": "2023-07-15T09:22:22.169+00:00",
                    "status": 500,
                    "error": "Internal Server Error",
                    "trace": "com.kartik.backend.tasks.exceptions.TaskNotFoundException:
                     Task with id 55 not found\r\n\tat com.kartik.backend.tasks.TaskService.lambda$getTask$0(TaskService.java:
                     48)\r\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:403)\r\n\tat ... so on. 
         
         Case 2:- if we use the Exception (above code) then we get meaningfull error. we already calling the exception in the TaskService class. 
                      means if we comment this code & then if we get the error then the error message will not be meaningfull.
              Output:-  
                    Task with id 55 not found.          Status Code 400 Bad Request.
                       
         Case 3:  if we use the below code like this
                    Code:-
                             @ExceptionHandler({ TaskNotFoundException.class, DueDateException.class })
                                public ResponseEntity<String> handlingException(Exception e){
                                    if(e instanceof TaskNotFoundException)
                                        return ResponseEntity.notFound().build();
                                    return ResponseEntity.badRequest().body(e.getMessage());
                                }
                             it will return the status code 400 bad request. that was not the correct status code
                                for this error.
                    Output:-
                            then it will not return the error message. but it will return the correct status code.
                                like 404 not found.
                                
    - Using our Syntax to send Error Response to the client.
           Old Code:-
                        @ExceptionHandler({ TaskNotFoundException.class, DueDateException.class })
                            public ResponseEntity<String> handlingException(Exception e){
                                if(e instanceof TaskNotFoundException)
                                    return ResponseEntity.notFound().build();
                                return ResponseEntity.badRequest().body(e.getMessage());
                            }
           New Code:-
                   @ExceptionHandler({ TaskNotFoundException.class, DueDateException.class })
                        public ResponseEntity<ErrorResponseDto> handlingException(Exception e){
                            if(e instanceof TaskNotFoundException)
                                return ResponseEntity.status(HttpStatusCode.valueOf(404)).body( new ErrorResponseDto(e.getMessage()));
                               // return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ErrorResponseDto(e.getMessage()));
                            return ResponseEntity.badRequest().body( new ErrorResponseDto(e.getMessage()));
                        }
           Output:-
                    Now, it will return the error message. & correct status code.
                        like 404 not found.







    - We can have a Project Level Exception Handler as well which handle all errors that happens accross the project.
        - for that we need to create a class with @ControllerAdvice annotation.
        - and we need to add @ExceptionHandler annotation on top of the method.
        - and we need to add @ResponseBody annotation on top of the method.
        - and we need to add @ResponseStatus annotation on top of the method.
        - and we need to add Excep
        like:-
            @ControllerAdvice
            public class ProjectExceptionHandler {
                @ExceptionHandler
                @ResponseBody
                @ResponseStatus(HttpStatus.BAD_REQUEST)
                public ErrorResponseDto handleException(Exception exception) {
                    return new ErrorResponseDto(exception.getMessage());
                }
            }
            - this will handle all the exception that happens accross the project.
            - we can also add @ExceptionHandler annotation on top of the method in controller class || service class
                to handle the exception that happens in that particular class.
        - Exception like:- Database not connected which we can handle at the project level.    
    - 




















```