

```  
    public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;                --> 2.
            ||
    private final TaskRepository taskRepository;                --> 1.
    public TaskEntity createTask(String title, String description, Date dueDate) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title); ... so on. 
        return taskRepository.save(task);
    } }

There are two way to create object & inject it. 
   1. by constructor
        here, Spring see that there is an variable(taskRepository) which required in constructor of TaskService class.
                so whenever it will build TaskService class then it will see that  "Is there any way to build TaskRepository object ?" 
                if yes then it will build TaskRepository.
                TaskRepository is an interface so How can Spring build TaskRepository
                    it extends JpaRepository so SB knows anything which extends JpaRepository Spring will build it using SimpleJpaRepository class. 
                    that's how Spring will able to construct TaskRepository object & put it in TaskService constructor.
                    these step we don't do manually. (like TaskRepository taskRepository = new TaskRepository();)
                    we just take it from constructor & use it.
                    How it will come to Constructor ?
                        DI picture comes in the picture.
                        DI framework can build our class which we defined in SB. becoz they have default ways of creating the object. unless we want specific fun.
                          so such a way we can create the repository object that can be inserted in TaskService class. 
                             that's way we can create the TaskService object. becoz there was only one dependency in TaskService class. 
                             so we can create the TaskService object. 
   2. using @Autowired annotation.
                     













```