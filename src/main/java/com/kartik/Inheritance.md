
# Inheritance
```
1. whatever we have studied about inheritance is about the accessiblity part 
    like is it accessible or not. that is access modifier decides.
    1.1 **weather it is exists in the memory of object or not is not decided by access modifier.**
    
    memory wil always get inherited. 
```
whatever modifierm, **whenever we extends any class like we take class A & extends it to class B
          B will always be bigger then A** because everything that exists inside object of A will exists inside object of B.
```
conditions 
    any code inside B will not be able to access things which are private in A.
```
### PRIVATE 
```
        means only I internally can access it.
            but if it is private on my parent that means i don't know it exists. 
                but it exists, EXISTENCE IS NEVER PREVENTED BY ACCESS MODIFIER.
```

### PUBLIC
```
        means people outside the class can access it.
```
**acces modifier all about accessiblity not about the existence.**

#### BEST EXAMPLE
```
    assume your father gives you a shirt (PUBLIC INHERITANCE) means we are wearing it so public 
    can see it. now your father gives you a money in your bank (PROTECTED  INHERITANCE) means we don't know
    now your father put a box which have jwellery inside hidden chamber in wall of your house and when you inherit the house 
    we even don't know that jwellery we have inherited. but it exists. (PRIVATE INHERITANCE)

    parents keep that jwellery private but when you inherited parents don't tell you but we still inherited
```
**if we not defined any access modifier then it has package level access modifier.** 
```
    package level access modifier means if we have two class in same package then they can access each other.
```

### ACCESS LEVEL 
```
                    class   package   sub class   world
    1. public       Y       Y         Y           Y
    2. protected    Y       Y         Y           N
    3. no modifier  Y       Y         N           N
    4. private      Y       N         N           N
    
EXPLAINATION:- 
    1. within the class things are private, protected, public, no modifier
     all var of these modifiers are accessible by all other 
     functions inside the class. 

    2. within the package things are protected, public, no modifier
     all var of these modifiers are accessible by all other 
     functions inside the package.
     if var are private either it is inherited with the same package but 
        it Won't be able to access private var of parent class.

    
    3. within the sub class (B is inherited from A) things are protected, public
        all var of these modifiers are accessible by all other 
        functions inside the sub class.
        if var are private either it is inherited with the same package but 
            it Won't be able to access private var of parent class.
      
      Example for 2 & 3 
        com.kartik.Fruit
        com.kartik.Mango (extends com.kartik.Fruit)
                public, protected, no modifier (var of com.kartik.Fruit are accessible by com.kartik.Mango)
        
        com.kartik.Fruit
        com.gaur.Mango (extends com.kartik.Fruit)
                public, protected (var of com.kartik.Fruit are accessible by com.gaur.Mango)
   
    4. within the world things are public means outside the class  
        like we create Fruit f in main function then we can access only public var of Fruit class.  
        
        outside the world means the project should be same means they have to be inside the same jar file. 
            across the project we can't access. 
```
