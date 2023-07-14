
#### Separate Classes to handle Data Coming over HTTP, Data that is stored in DB.
``` 
    Why should be have it ?
                        below classes are Modal Classes.
        - User Object that we stored in db.             // Entity Classes
            User {
                    name
                    email
                    password
                    age
                    username    
                 }
        - When somebody does Sign up, that time User Object is created with the below fields.
            SignUP:-    
            -->
                User {
                        name
                        email
                        password    // Hash Password
                        age
                        username    
                     }
        - When somebody does Login, that time send the below fields.
            Login:-    
            -->
                User {
                        email
                        password    
                     }
            Response:-  that we send after login.           // DTO Classes
             <--
                User {
                        name
                        email
                        age
                        username 
                        authToken   
                     }
        Conclusion:-
                - we never send the User Object exactly as it is stored in DB as response becoz it contains password.
                - means creating seprate JAVA Class (for User Object that we send as response)  
                    & creating seprate JAVA Class (for User Object that we stored in DB) is better way of working on project. 
                  * we should have seprate Modal Classes that deals with HTTP Layer like Request & Response ... etc. 
                            separate Modal Classes that deals with db. which is called Entity Classes.
                -  Modal Classes that deals with HTTP Layer called DTO Classes.
                -  Modal Classes that deals with db called Entity Classes.
                
        Entity V/s Dao V/s Dto:-
                   - Entity Classes are the classes that we store in DB.
                            like  data is stored.
                    - Dao Classes are the classes that we use to interact with DB. 
                            like SQL data is fetched.
                    - Dto Classes are the classes that we use to send over HTTP. 
                            Dto class have never logic in it. just fields & getter & setter.
                            purpose of creating Dto class is used to create JSON Object that we send over HTTP || Microservices || any other place.
                            like Data is transferred between one layer to another layer of our software.        
        Modal Mapper:-
                      link:- modalmapper.org/getting-started/
                   -  This library is used to convert one object to another object. 
                                                   CreateTaskDto to TaskEntity     
                   -  read more about TaskService.md file
                
```
#### Real Time Usecase of Using Bean, In which cases we have to use Bean.
``` 
     When we used ModalMapper in TaskService class then we are creating a ModelMapper object in TaskService class. 
        but how spring will know that "How to create ModalMapper" ?
            becoz it's not an service, controller, repository, component, configuration, etc.
        so for that we will create a Bean for ModalMapper in the Main Class.
            then spring will create a ModalMapper object & inject it where ever we want.
```