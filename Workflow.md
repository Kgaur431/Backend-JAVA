


``` 
    - Request first comes to controller & here some errors can be handled. 
        like:-
                JSON format is not correct. means required field is missing.
                not null. 
        so the response back to the user from the controller itself becoz of if we use Global Exception Handler using @ControllerAdvice
        otherwise req will go to service layer. if there is some error can happen in service layer
            like:-
                    due date is not correct. 
                    title has more characters than required.
        so we can Throw an exception from service layer & then we can handle that ExceptionHandler in Controller layer.
        if service layer have to access the repository layer, there can be some error can happen in repository layer.
            like:-
                    Foreign key constraint.
                    Id does not exist.
        then Repository Layer can through SQLException from repository layer send to Controller layer directly. at controller layer we have the ExceptionHandler that will handle that exception.
         Or may be we have added some extra logic in service class.
            Why might we do that ? 
              suppose there is some error happen at Repository layer that is part of our usecase || business Logic.
                like:-
                        we are finding a user by Email. if it's not found then we are finding by username.
                        so when we are finding by Email then there is some exception happened. 
                        if the this exception happened then its part of my logic || usecase
                        therefore we have to handle that by using Try Catch block & then move to find by username in service layer itself. 
                so it means not all the exception throwing by Repository layer will be error, it can be part of our logic || usecase.        
        

```