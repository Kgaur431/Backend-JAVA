
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
    Grouping Exception:-
            @ExceptionHandler(value = {ExceptionA.class, ExceptionB.class})
            ResponseEntity<ErrorDto> notFound(Exception ex, WebRequest request) {
                return ResponseEntity.notFound().build();
            } 
            
            @ExceptionHandler(value = {ExceptionC.class, ExceptionD.class})
            ResponseEntity<ErrorDto> notFound(Exception ex, WebRequest request) {
                return ResponseEntity.badRequest().body().build();
            }  
            
                here we are grouping exception like 404 so that we group all 404 exception in one method.
                same with if we have 400 exception then we group all 400 exception in one method.
                    so don't need to write if else condition for each exception.
                  
           
                
```
#### Real Time Usecase of Using Bean, In which cases we have to use Bean.
``` 
     When we used ModalMapper in TaskService class then we are creating a ModelMapper object in TaskService class. 
        but how spring will know that "How to create ModalMapper" ?
            becoz it's not an service, controller, repository, component, configuration, etc.
        so for that we will create a Bean for ModalMapper in the Main Class.
            then spring will create a ModalMapper object & inject it where ever we want.
```
### [Exception Handler at Project Level ](https://www.baeldung.com/exception-handling-for-rest-with-spring)

### Best Practices
1. we have to handle error as early as possible as we should handle error in controller class.

# Defensive Programming.
## **Think like Real Software Engineers** || **Reality of Software Engineer While Writing a Code**
``` 
    -   always imagine when we write any line of code. the nearest abstract level. like why we are writing a code if its inside a function, if its inside a package, if its inside a class, if its inside a module, if its inside a particular class. 
          imagine always weather or not may be the entire project we are alone writing, may the other team members are also writing that project together.
          but imagine that the particular function || class in which i am writitng code "You are responsible for that function || class anything else is somebody else is writing".
         
         Means:- When we write the controller layer then we should think like that Service & Data-Layer written by other member, like if we write the service layer then we should think like that controller & data-layer written by other member. so on. 
                 so by using this flow like at controller layer the HTTP Errors are getting handled. does not means that at data layer we don't need to handle the HTTP Errors.
                  becoz tomorrow somebody else is creating GraphQL controllere where they forgot to handle the HTTP Error then GraphQL controller will also pass null value to data layer 
                 Best Case is that data layer also checks for HTTP Error.
                 So, the top layer checks for the HTTP Errors is happening or not, it does not matter becoz we also check for the HTTP Errors at data layer.   
 

```
