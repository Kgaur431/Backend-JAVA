package com.kartik.backend.tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
@NoArgsConstructor                       // this act as there is a constructor with no args in task entity
@AllArgsConstructor                     // this act as there is a constructor with all args in task entity
@Getter
@Setter
@Entity(name = "tasks")                 // This annotation is used to tell Spring that this class is an entity and should be mapped to a database table.
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // we use SEQUENCE generator like 1, 2, 3 ... so on.
    private Long id;

    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;

}

/*
   - if we use NoArgsConstructor then everything would be null & id should not be null,
       when we create a new task, then internal serializer uses the NoArgsConstructor & then set (all the fields) everything one by one
       using setter methods.
       so we need NoArgsConstructor & Setter instead of AllArgsConstructor.
       means, when we create a new task, we will create a task without id, we will set the other fields by using setter. becoz when we save in db then db will
         generate the id for us.

   - here no-args constructor is useful because we create a task without id, we will create task obj then we will set the other fields by using setter. becoz when we save in db then db will
         generate the id for us.
 */
