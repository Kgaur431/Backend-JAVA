## JAVA
### Build System
    In Javascript world there is an term called NPM which is used to manage the dependency. & for building we probably used webpack
    In Java World there is common two build system called MAVEN & GRADLE.
        these are build tool which define in which order all of our files will be compiled & then class files will be put together into jar files
    (Because in JAVA World, we write code in multiple files they all are compiled into multiple . class files & all . class files are put together into folder &
    the folder is done into a zip file this zip file is called jar. or which is a java arctypes.) these jar files contains meta data which tells the jvm,
    which files inside the jar file is where export execution start like main file of the jar.
    
    the steps of compiling 
    & put into a jar & 
    distributing it.
    we prefer some tools to automate this task for us.

**JDK --> https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html**

#### Information 
    1. .idea folder is used for ide specific configuration.
    2. .gradle folder is used for gradle specific configuration.
        like caches for gradle which helps to building the project 
    3. build.gradle file where our project has been created.
        this file will tell how the project will be build.
        3.1 syntax 
            plugins {
                id 'java'
            }
                if we add this plugin then gradle know that "this has to be build has a 
                    common java project"
        3.2 syntax
            group 'com.kartik'       ==> package name of the project
            version '1.0-SNAPSHOT'   ==> version of the project

        3.3 syntax
            repositories {
                mavenCentral()     ==> this is a repository website. Maven & Gradle both use this repository. 
            }
                this will tell where we download the libraries from. 
                if our poject wants to use some library. 
                libraries like junit, spring, hibernate, etc.
                we can download these libraries from maven central repository.
                    this is a repository where all the libraries are stored.
                for this project we don't have any libraries to download. 
                    below libraries are dummy libraries. 

        3.4 syntax
            dependencies {
                testCompile group: 'junit', name: 'junit', version: '4.12'
            }
                this will tell which libraries we want to use in our project.
                here we are using junit library.
                we are not using this library right now. 

### How our project can run even if we don't have the ide. || if we connect with remote pc with terminal then we have to run our project
    1. go to terminal, type "./gradlew build" & hit enter.
        this will build our project.
        this will create a folder called build.
        inside build folder there is a folder called libs.
        inside libs folder there is a jar file called "java-1.0-SNAPSHOT.jar"
        this is our jar file which we can run.

    2. go to terminal, type "java -jar build/libs/java-1.0-SNAPSHOT.jar" & hit enter.