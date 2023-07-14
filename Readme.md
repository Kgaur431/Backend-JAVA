### SpringBoot
## Dependency Injection
``` 

    - Think of Dependency Injection as a Design Pattern. don't think of it as a Feture of SpringBoot.
        suppose we build a simple project there we just write Class & Constructor  
                Class Person {
                    int age;
                    String name;
                    Person(int age, String name){
                        this.age = age;
                        this.name = name;
                    }
                }
                    Person p = new Person(20, "Rahul");
              from the above code we have another situation like we have PersonBuilder & from PersonBuilder we can create a Person Classes.
              Ques:- In what situation we have to create PersonBuilder class ?
              Ans :- we are creating PersonBuilder, we have to create 10 Person of same age but different name.
                     we can do like this:-
                        PersonBuilder pb = new PersonBuilder();
                        pb.setAge(20);   
                        setName("Rahul").build();    //not sure about this syntax
                        
                        assume, instead of 2 args there is 10 args & from that 8 args are same for 10 person. 
                               now the code will be very less
                                  Code;
                        this is the advantages.
                        so, we can create PersonBuilder class.
                     now, we have created two classes Student & Teacher. that inherits Person class.
                          then we create PersonFactory class.  
                            PersonFactory has some static methods like createStudent(), createTeacher() ... so on.
                            those methods are creating Student & Teacher objects.
              Ques:- Why do we create PersonFactory class ?      
              Ans :- To avoid Tight Coupling 
              Builder:- (we have lots of attribute & most of are templated & some of them are change) (validation) (checking Duplication)    
              Factory:- (createCollegePerson is a Factory method here we check if age > 25 then it will create Teacher object else Student object)
                         means like which kind of object we want to create that will be decided by Factory method. 
                                "Which type of Object that dependent on runtime", based on runtime we can create object. 
                         like sometime we need to create Student object & sometime we need to create Teacher object. that's why we used Factory method here.                            
    - Dependency Graph:-
                  Example:-
                            we want to build Vehicle class. 
                            Vehicle class needs Engine, body, wheel. 
                            wheels class needs Tyre, hub, tube.
                            Engine class needs IC engine needs fuelTank, Electrical engine needs battery.
                            Body class needs seats... so on.
                                
                                                                           Vehicle
                                                                              |
                                               -------------------------------| -------------------------------------------
                                               |                              |                                           |
                                            Body                           Wheel                                        Engine
                                               |                              |                                           |
                                               |                              |                                           |        
                                                               ------------------------------             -------------------------------
                                                               |             |              |             |                             |
                                                               hub           tyre           tube         IC                            Electrical
                                                                                                          |                             |
                                                                                                       fuelTank, CC                     Battery, KiloWatt.
                                                                                                         
                                                                                                         
                                    Class Vehicle {                                             Class Wheel {                                         Class Engine {            
                                        Engine engine;                                           Tyre;                                                   horcePower;;                         
                                        Body body;                                               Hub;                                                     torque;       
                                        Wheel wheel;                                             Tube;                                                  }
                                        Vehicle(Engine engine, Body body, Wheel wheel){          Wheel(Tyre tyre, Hub hub, Tube tube){
                                            this.engine = engine;                                   this.tyre = tyre;
                                            this.body = body;                                       this.hub = hub;                                
                                            this.wheel = wheel;                                     this.tube = tube;
                                        }                                                         }
                                    }                                                           }      
                     
                     we want to create a new vechicle. so we need to create wheel & engine. 
                     Ques:- Where we will create wheel & engine ?
                     Ans :-  inside the public Vehcile() constructor.
                              like:-
                                    public Vehicle(){
                                       Wheel wheel = new Wheel();
                                       Engine engine = new Engine();
                                    }
                             then inside Wheel we need hub, tyre, tube. & inside Engine we need fuelTank, CC.
                               somewhere has the logic which descide weather we will use tube in the tyre or not.
                     Ques:- How we will descide that ?  becoz some vehicle has tubeless tyre & some vehicle has not.
                            What type of Tyres we are using. either when constructing the vehicle does user have to pass some arg to vehicle 
                             & then that arg will be passed to wheel constructor.
                             inside Wheel Constructor we will descide that tyre will be tubeless or not.  
                     Ques:- if we creating new vehicle then we have parameter type like IC || EV. so when we create new vehicle then we add Vehicle Type.
                            based on that it will call constructor of IC engine or Electrical engine. || it might call EngineFactory class. (EngineFactory will decide which type of engine we need to create based on Vehicle Type)
                             
                  Summary:-
                        When we create a vehicle we need to pass lots of args inside Vehicle constructor.
                        based on that lots of code will be written in Vehicle Constructor. also in Wheel Constructor. & also in Engine Constructor.
                       this can be reduced. 
                           In Vehicle Class, instead of calling Engine like Engine engine = new Engine(); we use another approach.
                               Old Approach:-
                                  Public Class Vehicle{
                                   Engine engine;
                                   public Vehicle(){
                                       Engine engine = new Engine();
                                    } 
                                 } 
                               New Approach:- 
                                   Interface Vehicle{
                                     @Inject
                                     Engine engine;
                                      
                                     } 
                                      
                               How this will Inject ?
                                  here the Dependency Injection framework comes into the picture.
                                    1. Juice
                                    2. Dagger
                                    3. Spring
                                      ... so on. they are the Dependency Injection framework. which used to Inject the dependency.
                                        we will use Spring becoz its also an Dependency Injection framework.
                                  
                                  I have Engine Class. from which I extends IC engine & Electrical engine.
                                    like this:-
                                                                        Interface Engine {
                                                                            int horsePower;
                                                                            int torque;
                                                                        }
                                                  @EV                                          @IC                        
                                      Class EVEngine extends Engine{                        Class ICEngine extends Engine{
                                            int battery;                                         int fuelTank;
                                            int kiloWatt;                                        int CC;
                                         }                                                      }
                                         
                                       I created a custom annotation which has some scope. like @ICEngine & @EVEngine.
                                         now, in Vehicle instead of creating directly Engine engine = new Engine();
                                              I am creating Vehicle as Interface. & then create two classes like ICEngineVehicle & EVEngineVehicle.                            
                                                 like:-
                                                                                       Interface Vehicle{
                                                                                           @Inject
                                                                                           Engine engine;
                                                                                       }
                                                                   @IC                                      @EV 
                                                             ICVEhicle extends Vehicle{                 EVVehicle extends Vehicle{
                                                               
                                                                 ICEngine ICengine;                           EVEngine EVengine;
                                                             }                                            }
                                                      Now, we construct the object of ICVEhicle.
                                                          the Dependency Injection framework will see "To construct an object of ICVEhicle class we need an Engine".
                                                          but, Where DI can get the Engine ?
                                                                  Engine is an Interface 
                                                                  so we get the Engine from the class which implements Engine Interface.
                                                                    like ICVEhicle class implements Engine Interface. || EVVehicle class implements Engine Interface.
                                                          How DI will indentify that which vehicle class get engine from which implementing engine class ?
                                                            Then DI notice that ICVEhicle class has @IC annotation & EVVehicle class has @EV annotation.
                                                                so, DI will see engine class which has @IC annotation rather than @EV annotation.
                                                                    so, DI will create an object of ICEngine class & then it will inject that object into ICVEhicle class.
                                                      "DI will automatically mapped whenever we try to create an object of ICVEhicle class then it will pic engine from ICEngine class & inject that object into ICVEhicle class."
                                                       & "DI will automatically mapped whenever we try to create an object of EVVehicle class then it will pic engine from EVEngine class & inject that object into EVVehicle class."
                                                       
                                                      Becoz we need to Inject Engine into Vehicle class. & there is only two places where Engine object is created.
                                                         then DI has to identify that which vehicle class get engine from which implementing engine class.
                                                      How it will Pic ?
                                                         DI will see that parent object has (ICVEhicle class) @IC annotation so DI will pic child object (ICEngine class) which has @IC annotation.
                                                      
                                                      These are the @Qualifier annotation. which used to identify that which class get object from which class. 
                                                 Benefits :-
                                                            In the Constructor of EVVehicle class we don't have to write a code 
                                                                like If Vehicle type is IC then EngineFactory.createICEngine() else EngineFactory.createEVEngine().                   
                                                            so the kind of things that Builder & Factory Patter has solve. DI also trying to solve similar things.
                                                       In Oop's DI is also a desgin pattern.       
                                                       
                  Ques:- Where would we use something like DI rather than using Builder or Factory Pattern ?  
                  Ans :-  when we need to build certain object. 
                            like:- 
                                                                Obj1
                                                                  |
                                                                  |
                                                  ----------------|--------------------------
                                                  |               |                         |
                                                Obj2            Obj3                        Obj4
                                                 |                |                         |    
                                                 |                |                         |
                                            -----|------    ------|------             ------|---------
                                            |           |    |           |             |               | 
                                           Obj5        Obj6 Obj7        Obj8          Obj9            Obj10          
                            
                            creating these kind of object we have to think into Two ways.
                                1. Top Down Approach
                                      Step 1:- I have to create obj 1
                                      Step 2:- I have to create obj 2 
                                      Step 3:- I have to create obj 3
                                      Step 4:- I have to create obj 4
                                      Step 5:- I have to create obj 5  ... so on.
                                               then i have to also see "To Construct these objects basically Obj 3 & Obj 4 are not step 3 & step 4."    
                                                we have to build Obj 5 & Obj 6 in step 3 & step 4.  then we can move to create Obj 3 as step 5 & so on.        (DFS Approach)  
                                      Step 1:- I have to create obj 1
                                      Step 2:- I have to create obj 2
                                      Step 3:- I have to create obj 5
                                      Step 4:- I have to create obj 6
                                      Step 5:- I have to create obj 3
                                      Step 6:- I have to create obj 7
                                      Step 7:- I have to create obj 8   ... so on.  
                                                this is how i can create these kind of object. 
                                                    ![img.png](img.png)                                                                           
                                
                                2. Bottom Up Approach  
                                        In this, we create some logic by writing some function || class which has some static methods, to generate these kind of object.
                                            like:-
                                                  there is an way to which we can create Obj 5, Obj 6, Obj 7, Obj 8, Obj 9, Obj 10, Obj 2, Obj 3, Obj 4.
                                                    suppose we have to build the Obj 2. then we know that to build Obj 2 we need Obj 5 & Obj 6.
                                                             & the Obj 5 & Obj 6 are already available. 
                                                             so, I don't have to build in the Constructor of Obj 2 by calling Obj 5 & Obj 6 Constructor.    
                                                                   becoz there is an mechanism to build Obj 5 & Obj 6.
                                                                    Mechanism like:1
                                                                        Approach 1:- it is Memory Intensive & Bad for Memory
                                                                                       - we create all objects that exist in my code. so I create them & store them in the memory.
                                                                                           then whenever I need them I just pick them from the memory.
                                                                                           
                                                                        Approach 2:- In the Project, somewhere we write the logic that "How we can generate any obj of any type" 
                                                                                        then whenever we building an obj.
                                                                                            to build the Obj 2, we need Obj 5 & Obj 6. 
                                                                                        How we will get those Obj. that code is also written (how to generate obj)
                                                                                        How the Objects Created ?
                                                                                              (there is a place in my project where Generating Objects logic has written)
                                                                                                In DI frameworks we don't have to define manually as long as Objects can be created using default variable ... etc.
                                                                                                    DI frameworks genrate code generation logic also.
                                                                                            so, we have defined the way to create all objects in the code. 
                                                                                     Whenever we want to create Object for Vehicle, to create we need Wheels & Engine. <==  just need to tell the DI framework & done.  
                                                                                       means we have seprated the dependencies from the Process of creation.
                                                                                            1. One Part is how the object is created. like How the Vehicle is created, Engine is created, Wheels is created.
                                                                                       we just need to tell "Which things are needed in Which things".                                  *******************************************************************
                                                                                        so the constructor code is not getting large. 
                                                                                       Example:- What we have done it ?
                                                                                                    The process of actual cooking & the Recipe are seprated. 
                                                                                                    
                                                                                       If there is an Class, creating object for those class is more complex. we can write our own Class Generating logic somewhere in the code to create those objects.
                                                                                     we are just seprating the creation of Dependency Tree from the actual process of creating the object(putting so much logic in the constructor).     
                                                                                     
    DI framework is creating those repository object & injecting it in TaskService class. then creating TaskService object & injecting it in TaskController class.
        then creating the TaskController object, for us. 
        
        Reason DI framework generating the Service Class Ojbect automatically becoaz we use @Service annotation in the Service Class.
        Reason DI framework generating the Repository Class Ojbect automatically becoaz we use @Repository annotation in the Repository Class.
        Reason DI framework generating the Controller Class Ojbect automatically becoaz we use @Controller annotation in the Controller Class.
        ... so on. 
        if we not annotated the class with @Service, @Repository, @Controller then DI framework will not generate the object for those class.
    @Bean       (means we are defing the code generation logic (to create obj) for that class )
         - if we annotate the method with @Bean then DI framework will try to create the object with the default values. otherwise it won't.  
         - DI framework won't create any variable wherever we have asked inside the constructor, unless we specify with the @Bean annotation.
         - A simple class with default value inside it. & we want to initialize the object of that class with the default value. then we have to set it as @Bean.
             like:-
                    public class MyBean {
                        private String property1;
                        private String property2;
                     }
                     this below Bean method i can create anywhere in the code.
                        @Configuration
                        public class MyConfiguration {
                            @Bean
                            public MyBean myBean() {
                                MyBean bean = new MyBean();
                                // Set default values for the bean properties
                                bean.setProperty1("default1");
                                bean.setProperty2("default2");
                                return bean;
                            }
                        }

                       so whenever we want to create the object of MyBean class then spring will create the object with the default value.
                         These default values will be used by the DI framework unless overridden by explicit configuration elsewhere.  
                        It's important to note that the @Bean annotation doesn't guarantee that the DI framework will use default values.
                        The actual values used to configure the bean can vary depending on the configuration of the DI framework and the specific implementation of the method annotated with @Bean.
                        If you want to provide default values for the bean configuration, you can specify them within the method annotated with @Bean.
                                                                             
                                                                                     
                                                                                     
                                                                                     
                                                                                     
                                                                                     
                                                                                     
                                                                                     
                                                                                     
```