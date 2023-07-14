
``` 
  public TaskEntity createTask(String title, String description, Date dueDate) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(false); 

        return taskRepository.save(task);
    }

        - in the above code we are expecting CreateTaskDto object as a parameter, like CreateTaskDto createTaskDto. 
            but we have to do manual mapping of the fields from CreateTaskDto to TaskEntity. (although the fields are same in both the classes)
            like:-
                 public TaskEntity createTask(CreateTaskDto createTaskDto) {
                        TaskEntity task = new TaskEntity();
                        task.setTitle(createTaskDto.getTitle());
                        task.setDescription(createTaskDto.getDescription());
                        task.setDueDate(createTaskDto.getDueDate());
                        task.setCompleted(false); 
                
                        return taskRepository.save(task);
                    }
            -  if the Dto class have more fields then we have to do more manual mapping. like above so we are using ModelMapper.   
                    for using ModelMapper we have to add dependency in build.gradle file.
                        "implementation 'org.modelmapper:modelmapper:3.0.0'"  
                          
                    -  code:- 
                            createTask() {
                              ModelMapper modelMapper = new ModelMapper();
                              TaskEntity task = modelMapper.map(createTaskDto, TaskEntity.class);
                              .... so on. 
                            }
                            
  -  Every fun that I write inside TaskServiceClass then Why should I create ObjectMapper object every time?  
        becoz One ModelMapper object is used everywhere. 
        that is where the role of DI is coming in picture.
            -  we will create a ModelMapper modalmapper object in the TaskService class. & inject it via constructor.
                but we can't inject Modalmapper object directly & we can't annotate it with @Autowired.                 *******************************************
        
        *  How will spring know that "How to create ModalMapper" ?
             becoz it's not an service, controller, repository, component, configuration, etc. then How spring will indentify & create the Object for ModalMapper.
           - we Will create a Bean for ModalMapper in the Main Class.
                -  @Bean
                   public ModelMapper modelMapper() {
                       return new ModelMapper();
                   }
                   
  -  TaskService class should not provide the TaskEntity to backend 
        means we have to remove "any use of TaskEntity from the controller layer".  let the service layer handle the TaskEntity.
            let the service layer only provide the dto's.  
                -  so we will use a TaskResponseDto class instead of TaskEntity.
                    like:-  In TaskService class.
                    
                            public TaskEntity createTask(CreateTaskDto createTaskDto) {
                                TaskEntity task = modelMapper.map(createTaskDto, TaskEntity.class);
                                task.setCompleted(false);  // By default, a task is not completed.
                        
                                return taskRepository.save(task);
                            } 
                                                    ||
                            public TaskResponseDto createTask(CreateTaskDto createTaskDto) {
                                    TaskEntity task = modelMapper.map(createTaskDto, TaskEntity.class);
                                    task.setCompleted(false);  // By default, a task is not completed.
                                    TaskEntity tasks = taskRepository.save(task);
                                    return modelMapper.map(tasks, TaskResponseDto.class);
                            }
                         



```