package com.kartik.backend.notes;

import com.kartik.backend.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "notes")
public class NotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // we use SEQUENCE generator like 1, 2, 3 ... so on.
    private Long id;
    private String title;
    private String description;

    @ManyToOne(targetEntity = TaskEntity.class)
    private TaskEntity task;        // if we want that while fetching notes the taskid should be present, then only we have to write this relationship.
                                    // if we don't define this relationship then also the mapping table will create by Hibernate.

}

/*
    Task --> Notes:- have 1:N relationship.
    How we can do this?
    - In TaskEntity we have list of Notes. so we create a list of NotesEntity in TaskEntity.
    - then annotate the list of NotesEntity with @OneToMany.
           we can set like "How both entities will connect to each other?"
              targetEntity = NotesEntity.class
           defining mappedby field, Mapping table will not be created by hibernate. (In ManyToOne relationship, mapping table required)
                mappedby = "task" // mappedby is used to tell that this is the field in NotesEntity which is mapped to this field.

           How it will cascade?
              it means if we delete a task then all the notes related to that task will also be deleted.
                cascade = CascadeType.ALL
    - In NotesEntity Class.
            ManyToOne relationship.
            TaskEntity --> TaskEntity // has many notes.
    - If there is one to one relationship bw task & notes then we don't have to specify column name.

 */
