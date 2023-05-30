

```
Ques1: WHY JAVAC IS NOT SUFFICIENT TO RUN JAVA PROGRAM & WHY WE NEED BUILD TOOL?
ANS:    javac can compile one file at a time. but if our project go bigger then having build tool is useful.
            because "It Can Compile All The Files Put Them On Together Into A Single Jar File
                        & Make The Jar File Executable For Us."

QUES2: BUILD.GRADLE VS POM.XML
ANS:    In gradle file we can write pices of logic so we can customise the build code here, 
        In Maven file there is only xml code so we can only set tools but we can't write custom build logic here.
            so we have to use build plugin for that.
       
        If a gradle project then we can run the project using command line. 
            C:\MicroS\Backend_JAVA> ./gradlew.bat build         ==> make the jar file
               then open build folder inside libs folder we will get jar file.
        
        make the new gradle project like npm 
            install gradle from gradle.org
            then run command in cmd
                C:\MicroS\Backend_JAVA> gradle init --type java-application || gradle init
                    then it will ask for project name, package name, version, etc.
                         select type of project to generate:
                            1. basic
                         select build script DSL:
                            1. groovy
                         .
                         .
                         .
                         P rroject name (default: Backend_JAVA):
                         
                         create the project. 
                         
                         if we want the jar project then instead of basic go for 
                            application. follow the steps (mostly ans is 1) and create the project. 
                         
                       
QUES3: java -version VS javac -version
ANS:   java -version ==> if it is able to run java that means JRE is installed.
        javac -version ==> means we are using java compiler so JDK is installed.

