## INTERFACE
```
    1. interface use to model behaviour of an object. means what an object can do.
    
       QUES 1 WHY ABSTRACT CLASS?
       ANS: Interface can't have attributes but abstract class can have attributes.
            but we can't create object of abstract class directly.
            
            
       EXAMPLE
                Person {age, name}
                
               abstract class PeopleStorage {     // assume this is an libraray which will be used by other people
                    List<Person> people;          // logic to store people data
                    addPerson(){
                       logic defined here to add person in list
                    
                    }
                    removePerson(){
                     ==> logic defined here to remove person from list
                    }
                    save()
                    restore() 
                                // these two functions we have not defined here 
                                   becoz we don't know how other people want to save & restore the data.                  
                    
                    }
                    PepplDBStorage extends PeopleStorage {
                        save() { // logic to save in DB }
                    }
                    
                    PeopleFileStorage extends PeopleStorage {
                        save() { // logic to save in File }
                    }
                    
                    Why PeopleStorage class has abstract class. 
                       because it has certain data & certain internal logic defined
                       but we can't create an obj of PeopleStorage class directly. 
                        because we have to implements save() & restore() function.
                       
                       whoever create the PeopleStroage they just wanted to create the basic logic of 
                            how people data structure is & how to add & remove people from list.
                     
                    so whoever is using the PeopleStorage class 
                        they will implements how to store data either in db or in file. 
                        THEY JUST HAVE TO EXTENDS PeopleStorage class & then implements save() & restore() function.
                        like PeopleDBStorage & PeopleFileStorage class. ==> concreate class. 
                       
       This situation can't solved by Interface because in Interface "EVERYTHING WOULD BE ABSTRACT 
                            & RE-IMPLEMENTATION OF addPerson(), removePerson(), save(), restore() functions 
                            people List we can't implements in interface."
       so we can use abstract class here. 
       

    2. abstract class Car {
        defined code ;
        undefined code;
        }
        
        class BMW extends Car {
            undefined code;
        } 
    
    3. interface Car {
        // can't defined code here
        undefined code;
        }
        
        class BMW implements Car {
            // everything would be re-implemented here 
            undefined code;
        }              
```
