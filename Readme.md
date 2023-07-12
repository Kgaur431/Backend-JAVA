# Spring Boot

#### Terms that should know before working with Spring Boot
```
     Spring Boot Dev Tools:-
                    it is used to restart the application automatically & faster when any changes occur in the classpath.
     
     Spring Boot 3.0.0 (M2):-
                    it means  "whenever new version is created then they released these M1, M2 ... version is created 
                        basically M1 means new features are not added in this version but bugs found in the previous version that are fixed in this version"
     
     Spring Boot 2.7.4 Snapshot:-
                    it means "latest development version of the Spring Boot is available".
                     - if we go to spring boot open source repository at 2.7 branch assume yesterday latest commit has come for that they released Lightly-build version
                     - Snapshot builds means "is more possible that bugs inside them becoz this version is not tested".
                     - version which are not have like M1 or Snapshot then it means that version is stable version.
     
     Spring Web Dependency:-
                    it is used to create "REST Api based application".
                    
            Why we use Spring Web ?
                 "it allow us to create http server which response to the http request".   
                 "it also used to create command line project or non-http based project".
     
     Template Engine Dependency:-               
                    if we want that our backend generate HTML files(means not write any code in frontend) so we can use "Thymeleaf" dependency or "JSP" dependency.
                        means our backend server should generate HTML files.
     Spring Boot Actuator Dependency:-
                    it is used to "monitor our application".
                        means we can monitor our application like
                           how many request are coming,
                           how many request are failed,
                           how many request are success,
                           how many request are in queue,
                           how many request are in process, 
                           how many request are in waiting, 
                           how many request are in sleeping, 
                           how many request are in running,
                           how many request are in terminated,
                           how many request are in blocked,           
                              ... so on.
     @SpringBootApplicationa :-
                         "it has run time retention policy. it means it will be available at run time". 
                            like it available in Jar file, byte code, class file.
                         - this annotation is composed of multiple annotations
                            1. @SpringBootConfiguration
                            2. @ComponentScan
                                ... so on.
     SpringApplication.run():- 
                        this method is used to run our application.
                             Tomcat server is started on port 8080.
                             Spring app by default use Tomcat to run HTTP server.
        HTTP server    -What does it mean by "HTTP server" ?
                            Means, "running a program that can listen for requests coming on any port. on that port TCP/IP request comes of HTTP Packet Format
        Consumer OS                then the server can listen for these such request and respond to such request".
                                  by default when we run Computer, its run on consumer Operating System like Windows, Linux, Mac OS ... so on.
                                        Means by default there are no server running on our computer. there are no ports on which some app is running & waiting 
                                              for other computer over the network to send any FTP, HTTP or any request"
                                  Http Server is basically a S/w that start listening to a port. 
        Port                    the reason we called a ports becoz thery are "analogus" means Hardware ports.
                                    like USB Ports, 
                                                so if we have 4 USB Ports on our computer then we can connect 4 USB devices at a time.   
                                    Similarly when "computer connects with network then that computer would haveports from 0 to 65535". 
                                            that are range of ports that computer can have. 
                                            non of the ports are open by default. 
                                              means server is not running on our computer that means it has 0 ports.
                                                 certain software when they started they can say that "we are listening for a request which are coming to the port"
                                                   when we make request to the another computer(server) from my computer(client) then we have to specify both
                                                    "location(Ip address) of the network" & "port number on which server is listening".
                                                        like "http://localhost:8080" here 8080 is the port number.
                                                   when we search www.google.com then we don't write the port number 
                                                        "Because we accessing the google.com over a some protocol which is like HTTP(80), HTTP's(443), 
                                                            all protocol having default port number". we can run HTTP application on non-empty ports as well
                                                            like 0 to 1024 ports are reserved for some portocols like HTTP, FTP, SMTP, POP3, IMAP, ... so on.
                                                            from 1025 to 65535 ports are available for us to run our application. so we can run our application on that port.
                                                   when server start from that port it look like command line app where it's awaiting user inputs from the console & it is giving user output to console.  
                                                   similarly we have GUI app, in Gui app, it renders something on the screen & it wait for people interact via UI.
        Backend Project                                  here, we are building Backend Project like where classes name is "BackendApplication" this is also an Application. 
                                                               its not like GUI app or CLI app. its a network app. so that input & output happens via HTTP request, via certain IP address & port number.
                                                                means any other computer or any person reach this computer via IP address & port number.
                                                                    so they can interact with this software only thing is input & output is not console, not a UI. Now the Input & Output is HTTP request & HTTP response.
                                                        after studing these concept very well, now its easy to develop any software becoz software could be sotre data somewhere like db, files. & software 
                                                            will be interacting with other user || other computer via some interface. means this is the only thing we are doing & if we know these concepts then we can build 
                                                                any software easily.      
     In Java Ecosystem, 
                  -we have bunch of libraries using which "HTTP server can run".
                       JBoss, Tomcat ... so on. are one of them.
                            Tomcat is very old HTTP Based library. 
     Annotations:-
                  - Annotations can be read at either "run time" level or "compile time" level by the compiler using annotation processor. 
                  - runtime process happens through "reflection API". it means how we read at run time.        
                  - annotation processor is how we read at compile time.
     Controllers:-
                  - it is an convention.
                  - controller is generally the "code which defines how Http request would be receive then how we send back the responses" that is 
                        the responsibility of controllers.
                  - contoller can call a repository if it want to store the data, it can call services if it want to run some logic.
                  - In this controller what we will do ?
                       when Http req first hits the server, the class inside which define what will happen to the request & what will happen with the response.
                        like every Http req that will come that would come on certain URL(ip-address of server : port /path) 
                            so if we map the requestingMapping with the "/tasks" & inside that we write an fun then this fun will trigger when we access it.
                              here we doing prefix by /tasks.
                  -  Get Request is the mostly use, whenever we write any url on browser & send the request basically sending a get request.  
     How to prefix api/v1 ... something with every api of the project /
                  - now, we want to entire server prefix by api/v1 ... then best way is to do that outside the server logical tool.
                        like server || load-balancer level. by using Ngnix,Apache... they are (low level Http Servers) used at load balancer level to mount the entire server on /api/v1 path.
                            Ngnix wil run two complete seprate server 
                            1. Node js server, it would be on /app path   means app is an node js app
                            2. Java server, it would be on /api/v1 path   means /api/v1 is an api written in springboot. 
     How does Request routed to the controllers in spring ?  || Usecase of Tree Traversal in SpringBoot 
                 - in the main class where @SpringBootApplication annotation has something called as @ComponentScan annotation, it does "whichever packages our backend app have, it will 
                          search for all classes inside that when the app is starting, inside that it will get a class where @RestController then it will see the @RequestMapping have or not.  
                          (this is where tree like traversal happen actually & it will create an interanl HashMap. in HashMap it will make a path to "function which is run". 
                           like /task/hello) it will map this path to hello(). so when actually req come then it will see what is the url of the req & call the respective fun).
                 - if we create a package that are not under the com.kartik.backend then at the time of ComponentScan stage springBoot will not scan that package. 
                     so either we have to put that package under com.kartik.backend or we have to mentioned that package name in the @ComponentScan annotation. 
                     like @ComponentScan({"com.kartik.backend","controller"})
     REST API:-
                 - Rest is just an guideline || convention || standard. 
                 - Rest just tell us that "which type of http method & which type of url should lead what type of action"
                 - Rest does not specify the format of the response || format of the body should be. 
                 - It does not say that the response has to be in JSON format.          
      
     
                              
      
                              
                              
                              
                              
                              
                              
                              
                              
                              
                              
                              
                              
     Points:-
          1. In our Main folder whatever name we give to our project that becomes the name of the class. inside that main method.   
          2. How Tree Traversal Happens ?
                - if we have to design how components can work ?
                    then we have to talk about how to traverse springboot project as file tree. read only components & capture their allocation, based on that 
                        create the controller & services for that. so we have to do Tree Traversal.
                - components are in files. dir are tree's. that's how Springboot project is like src ==> main ==> java ==> package ... so on. 
                   everything would be in tree formate.             
                              
                              
``` 

### lIFE LESSON as a Software Engineer
#### don't try to find an answer to a question like this **if we have two controllers & both have the same @RequestMapping("/task") then what will happen**
```
    * As a Software Engineer, in the world that we are working the two thing is "Breaking Things is Very Cheap" 
    Cheap means "Time, Energy & Money" wasted.
        like:- if we write something & we missed to put ; in our project then it will not work. 
                so we have to go back & put ;                                                           :- Doing This is Very Cheap  
                Example:- if we make circuit board & we connect positive to negative by mistake & suppose this board is Rasberry Pi which cost is 3000
                            by doing this mistake we loss the 3000 rs. 
    In Software Engineer Field "doing experiment is fairly cheap comapre to other engineering fields".
    if we have thought like "what will happen if we do this".
        testing is also very easy becoz making mistake is cheap. like what is the cost of trying it out, just time.  
        
    Summary:-
            if we have this kind of question then we have to make another class then try it out that what will happen. "try it out & see".    
                this story is about "how to think like a software engineer".
                "Trying Things Out more is Extremely Important" means after writing some piece of code then we have to test it so that 
                    we can see what is the output of that code. & if we get any error then we can fix it. but instead of that if we test it after 
                   building the entire feature then it will be very hard to find the bug.
```

### must read
1. [Annotation_Processor](https://www.baeldung.com/java-annotation-processing-builder)
2. [ Reflection_API](https://www.baeldung.com/java-get-field-annotations)