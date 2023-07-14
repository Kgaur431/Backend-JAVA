

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
            



























```