# Spring Boot

#### Why Should we not write code in Controller || what could be the responsibilities of Controller?
```  
    assume we build a server. think like a box is a server. 
    all application have their own Backend Interface and Frontend Interface. 
    
                                Presentation Layer          Domain Layer                           Data Layer   
                                -----------------------|--------------------------------------|-------------------------------------
                                |                      |                                      /  Task SQL Repository               |
          REST                  |                      |                                    / |                                    |
                                |   Task Controller\   |                                  /   |                                    |
                                |                   \  |                                /     |                                    |
                                |                    \ |                              /       |                                    |
                                |                     \                             /         |                                    |
          GraphQL               |  Task GraphQL Cont.---           Task   Service./           |                                    |
                                |                      /                           \          |                                   |
                                |                     /                              \        |                                   |
                                |                    / |                               \      |                                   |
                                |                   /  |                                 \    |                                   |
                                |                  /   |                                   \  |                                   |
          HTML                  |   Task HTML Cont/    |                                      \   Task Redis Repository            |
                                -----------------------|--------------------------------------|-------------------------------------
                                |    Controllers                 Services                               Repositories               |
                                                                                                  
                                                                                                        
   
   - from almost 25 years, this general thing is going on that we are doing 3-Layer Split.
        as project size increase then we split it into 5 layer split and then 7 layer split.... so on.  
   - by 3-Layer Split, MVC is born.
        1. Presentation Layer       (In Node js, it called as Route)
        2. Business Layer || domain layer || service layer
        3. Data Layer
   - In Springboot project the terms that we used mostly 
        1. Controller
        2. Service
        3. Repository
   - our server might have multiple way which frontend interact. 
         1. REST API       :-  
         2. GraphQL API    :-
         3. HTML Endpoint. :-  where browser can directly fetch data from server.
         
      Lets say, Task Manager application.       || different ways to create api's for Task Manager application.
                we might have Task-REST-Controller, Task-GraphQL-Controller, Task-HTMller. three seprate controller which deal with tasks
                = Task-REST-Controller:- here the logic is written that GET, PUT, POST (body in JSON), DELETE, PATCH, etc. req will happen then return the response as JSON body.
                = Task-GraphQL-Controller:- here the Req & Response happen through POST method only. & response happen in GraphQL-Query Language. 
                = Task-HTML-Controller:- here we have machanism that if browser send the req then we directly return the HTML page where all the task has return 
                                                means server not send the JSON Data. 
                we have to save data somewhere like in database or in file.        
                    whenever we do save it. there could be certain common things:-
                        1. Create a new task
                        2. Add a new task
                        3. Update a task
                        4. Delete a particular task
                    for these operation we can't depend upon weather the command came from REST or GraphQL or HTML. these things we need to do. 
                Why should we implement the storing logic three times. How we can define one single place.
logic Segregation   that's where the logic Segregation comes into picture. 
                    means, we will create one Task Service in Domain Layer. so when somebody add new task via REST API that will call Task Service, 
                            if somebody add new task via GraphQL API that will call Task Service, if somebody add new task via POST Req through HTML Endpoint that will call Task Service.
                            but "The Service is where it define the steps will happpen".  
                            after Service, we can save the data in service it is possible but it is not a good practice. like we are store in ArrayList but it store in RAM. 
                            so we will save in database. so the code to interact with db where do we write. 
                              suppose if we write in Service then,
                                  Ques:- Will data be stored in same place ?
                                  Ans :- like in SQL db, all task are saved. but people fetch mostly Top 10 task when app open then first GET Req would be to fetch Top 10 Task 
                                            so we have cached that data using Redis.(if data exists in redis then we will fetch from redis else we will fetch from db)
                                            if we do this then we have two datasource. one is db and another is redis. so we have to write code to interact with db and redis. 
                                            both have different way to interact. so we have to write code for both. sometimes we store some part in SQL Db & some part in NoSQL Db.
                                                like :- In Zomato app, the reviews are stored in Cassandra Db and other data is stored in SQL Db.    
                              it could happen that, 
                                  we split our backend code in such a way that multiple services which talk to seprate service where data is getting stored.
                                    like Db-Service where task related data is stored. & we written Task Service that will not directly write SQL query means 
                                    there is another REST API to fetch data like we have decentralised db where the Master DB is in centrally (one location) and Task related API is distributed 
                                    depending on the country. in every country we setup a server. all the server have their own Redis Cache. but they don't have their own local db.
                                    they are making remote call. & to make remote call they have to call another serivce. so the data layer could be talking to SQL DB, NoSQL DB. or talking to another service.
                                  In Services What Happen 
                                    Backend & Frontend are relative task, means clients talk to service1 & service1 talk to service2 & service2 stores data in db.
                                        so for service1 Frontend is client & service2 is backend. 
                                        but for service2 service1 is frontend & db is backend.   
                                    For every layer we can have Frontend & Backend. 
                                        it does not means that Frontend is always a browser. or Backend is always a db.
                    so, we create two data source in data layer.
                      Task Service will talk to Task SQL Repository & Task Redis Repository. 
                        first it will make req to Task Redis Repo to check if data exists in redis or not. if exists then return the data else make req to Task SQL Repo to fetch data from db.
                        while doing this sepration then we have to keep in mind that what kind of error do we have to handle on which place.
                        Ques:- Which Layer will handle which error see with Example?
                        Ans:- 
                            Error 1:- creating a task the status will capture Boolean value but we are sending String value. 
                            Ques:- In which layer we will handle Error 1?
                            Ans :- Presentation Layer. means at the controller. 
                                    becoz the serialization & deserialization happen at the controller level. like if someone wants to create a task 
                                     & they send the info about the task which they want to create. like completed fields. that happens in controller level.
                                     SpringBoot handels Serialization & D  eserialization automatically using Jackson Library. so when the deserialization happen at that layer itself we need to 
                                     handle the error. like we are expecting Boolean value but we are getting String value.
                            
                            Error 2:- in Service of Task Manager if we want to add task the due date after has to be today. can't be before the current date.
                            Ques:- In which layer we will handle Error 2?
                            Ans :- Business Layer, this is part of business logic. so we will handle in Service Layer. 
                                     Why this is Business Logic ?
                                        becoz, this is part of my project that due date should be after today date. suppose other might be like they create task of past date.
                                        my task manager logic says that such things not allowed.
                            
                            Error 3:- task with given id does not exist.
                            Ques:- In which layer we will handle Error 3?
                            Ans :- Data Layer
                           
                            Conclusion:-
                                    Controller is all about the presentation layer.
                                     like the req is coming. here we check like format is correct or not.
                                            if its contain API key or not. 
                                     but not to enforce any logic on it. like we are not checking that due date should be after today date or not. it will handle by service layer. 
                                    If there is problem related to how to store data. 
                                        like I want to store Notes inside task & suppose Notes contain Wrong Task Id. 
                                        then we will handle this error in Data Layer. 
                    Case Study:-
                        Assume Task Id does not exit happen in data layer.
                          then we get error like in java we get SQLException. 
                        Will we send te SQLException to end user ?
                            No, why user should know the internal things so we have to format it "Task not found" with status code 404. to presentation layer.
                        all these layers among them they would technically API only.
                            but internally these are function 
                            assume Service Layer & Controller Layer have contract like Controller say this this thing i will ask you to do. 
                            Service Layer say i will do this this & respond to you. 
                           means, while desgin Software we should not only desgin correct usecases. like what format service send data to controller. 
                                    but also we have to desgin incorrect usecases. like what format error would be read by controller from service layer.   

   API Gateway:-
                 In Front of my Application (Backend Application) || Server there is an API Gateway, it will act as load balancer. 
                 like multiple requests coming from diff apps. assume if an api request comes that not contain api key then it will reject it before calling the app logic\
                      that is the job of API Gateway.
                 we can put this logic in our app also but if we have multiple backend like microservices then we have to write this logic in every service.
                    so we can write this logic in API Gateway.
                 more things it will do.
   Logging:-
            which layer we implements Logs generally ?
                we have to implement logs in every layer. becoz we want to know what happen with our request in every layer.
                    like Request Body logging at controller layer.
                         Command logging at service layer.
                         SQL Logging at data layer.
                Means, Logging is not layer specific.
                we have to desgin traceability of logs. 
                    like on AWS, there is Xray service. 
                      every req has request ID. that gets passed on to the service command then that gets passed to the sql command. 
                      so we can trace the log like this error is generated becoz of this request that came from the controller
            
            How to make universally traceable logs across a system.
                if we use UUI then no two req will have same id once the id attached then the id will carry through the req 
                sometimes the Req come to API Gateway might lead two diff operation. may be one task is Synchronous like to create a task so we have to send to db 
                & send back the response that task is created. another operation also happen like a user how many task create daily kind of thing. user does not know 
                it happen in background. 
                "We will attach the req id to both the operation means both the operation contain same req id"
                In future if we trace bug then based on req id we can trace that what user did becoz of which bug is generated. 
                    if we generate the req id from client level then it's very good so that we can trace it easily but if we generate
                    req id from API Gateway then we can also trace it.
   Add Dependencies in build.gradle :-
                      if we want to use JPA then we have to add dependency in build.gradle
                      like:-
                        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
   Application.properties:-
                     - here we write certain configuration for our project. 
                     - Prefered way to write configuration is in application.yaml file.
                     - both properties & yml file are Markup Language. both are serve same thing. but syntax is different. 
                       Example:- 
                            Application.properties:- 
                                server.port=8081
                                server.address=localhost
                                spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
                                spring.datasource.username=root
                                spring.datasource.password=root
                            
                            Application.yaml:- here, server. in every line is not needed. files become more readable.
                                server:
                                    port: 8081
                                    address: localhost
                                spring:
                                    datasource:
                                        url: jdbc:mysql://localhost:3306/task_manager
                                        username: root
                                        password: root
   Package by Layer || Feature :-
                                Package by Layer means "Old Software does this"
                                 - we create package by layer like controller, service, data.
                                   Example:- 
                                        com.example.taskmanager.controller
                                        com.example.taskmanager.service
                                        com.example.taskmanager.data
                                Package by Feature means "Modern Software does this becoz it's easier to split things into services || microservices"
                                 - we create package by feature like task, user, note.
                                   Example:-
                                         com.example.taskmanager.task
                                             TaskController.java
                                             TaskService.java
                                             TaskRepository.java
                                         com.example.taskmanager.user
                                             UserController.java
                                             UserService.java
                                             UserRepository.java
                                         com.example.taskmanager.note
                                             NoteController.java
                                             NoteService.java
                                             NoteRepository.java
   Lombok:- 
            if we use annotation like @Getter, @NoArgsConstructor, @AllArgsConstructor, 
            then we don't have to code for those things. lombok will generate code for us.
            "At Compilation time it will generate these methods into my class"
            becoz writing these things we called as boilerplate code.
            Lombok is a Compile Time library that helps us to reduce boilerplate code.
            also a Development tool.
            
            those annotation are Source level annotation. means, they are not available at runtime.
   Approach:- to write code.        
            Bottom to Top:- (if we know how we store data. hence Repository layer look like, hence service layer look like, hence controller layer look like)
                    - first we write data layer then service layer then controller layer.
                        
            Top to Bottom:- We start from Requirements side. (like my api suppose to look, hence the logic i need to write, hence this is how i store data)
                    - first we write controller layer then service layer then data layer.
   Autowiring:- 
               Means we don't have to create object of class. spring will create object for us.
                How interanlly Happened ?
                    - spring will create object of class & store it in container.
                    - when we need that object then spring will give us that object from container.
                    - spring will create object of class by calling default constructor.
                    - if we want to create object of class by calling parameterized constructor then we have to use @Autowired annotation.
                      autowired annotation will tell spring to create object of class by calling parameterized constructor.
                        Example:-
                                @Autowired
                                private TaskService taskService;
                                
                                public TaskController(TaskService taskService) {
                                    this.taskService = taskService;
                              }
   Test:-
              if we want to test the code that we have written in Service layer then we have to write Controller layer also.
                so that we can make API call & test the code.
              but if we don't want to write Controller layer then we can write Unit Test. 
   JPATest V/s Web Test :-
                JPA Test:-
                            - JPATest will create a DB layer & test. 
                            - JPA Test will not start the server.
                            - JPA Test will not hit the API.
                Web Test:-
                            - Web Test will start the server. & test.
                SpringBootTest:-
                            - SpringBootTest will start the server. & test.
                            - it will take more time to test.
                            - it will test the whole application.
                                    
                        
    
        
        
        
        
        
        
        
        
```
### Serialization & Deserialization
``` 
             means, we serialize an object to send over network to store in file.
                 like:- what can we store in file & what can we send over the network.
                        Bytes, we can store in file & send over the network.
                        But when we are working with Java or any other language then we are working with Objects not with Bytes.
                             lets we create Person class in Java or any other language. these language have their own way to memory management.
                             like Java Has JVM(Heap Based Memory Management) & C++ will create Pointer Based Native Memory Management.
                                   all language they way they represents this person is all differnet 
                                   means, in JVM how java stores a Person if we try to take raw bytes out of JVM & give it to JS, Python ... so on. 
                                      they will not understand. becoz java has own way to storing. 
                                 Real World:-
                                        assume we have to program one is Java(Backend) & another inm Python(Frontend). they both read & write the same file. or they talk with each other via network. 
                                        so the data  that need to be store, need to be transfered.
                                        then we come up with Data Representation Mechanism. like JSON, XML, YAML, etc. 
                                        they are more language independent. like JSON can be read by Java, Python, JS or human. 
                                        so "the process of when Java progrma wants to send JSON data they have to take Java object & turn into JSON String which can send as bytes somewhere & if they get back 
                                            some JSON  String as bytes then we converted back into Java Object."
                "The Process of Turning Programmin Language level Memory into transferable or storable bytes is called Serialization."
                  the opposite process of Serialization is Deserialization.

```
### Think like Backend Engineer
```  
    if we learn anything NodeJS, Golang ... so on. concepts how we will build server || backend are all same.
    may be some other framework call the presentation layer with other name called Route in NodeJS.
    like in many language the concept of class is not exist. like JS. But OOPs concept is exist in JS.
         object can be created directly, prototype existis. 
    like some language call the function as method || procedure but this will not change the concept of function.
        we call the function & give some input if required & get some output.
```
### **When we build Backend, Service we split into 3 parts.**
1. one which will deal with Presentation which is other services that call my service it handles that means reply to that. 
2. there is a part that handles how we store the data. it is called as Data Layer.
3. In between we write our logic 

### When we make projects always remember **What is the responsibility of that layer** means we should not make a layer that takes care of errors || logic which is not supposed to be in that layer. 