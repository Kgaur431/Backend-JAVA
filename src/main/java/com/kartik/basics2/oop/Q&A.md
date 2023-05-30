
```
    1. If we remove the @Override annotation from the start() in Tesla class then code will work?
       ==> Yes, it will work. no warning will come.
    
        1.1 If we remove the @Override annotation & add one argument to the start method then code will work?
            ==> start method will not be override. it will be new method in Tesla class.
                 & tesla.start() will call the start method of vehicle class. 
       
    2. Puropose of @Override annotation?
       ==> I
```

### Points to be remember 
```
    1. @Override annotation are the Policy.SOURCE type so in the runtime it will not be available.
        it is just for the compile time. & in the byte code it will not come. 