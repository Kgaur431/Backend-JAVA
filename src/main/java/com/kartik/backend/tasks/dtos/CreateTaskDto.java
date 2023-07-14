package com.kartik.backend.tasks.dtos;

import lombok.Data;
import org.springframework.lang.NonNull;


import java.util.Date;

@Data
public class CreateTaskDto {
 //   @NonNull
    String title;
    String description;
//   @NonNull
    Date dueDate;
}





/*
    Think Like when create Dto class

    1. What are the fields that are required to create a task?
        - we need title, description, dueDate.


    Data Annotation:-
        -  Data annotation is used to validate the data that is coming from the client side.
        -  with this annotation we can generate getters and setters, constructors, toString() method ... etc.


 */