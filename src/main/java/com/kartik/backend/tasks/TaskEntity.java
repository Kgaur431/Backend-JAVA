package com.kartik.backend.tasks;

import com.kartik.backend.notes.NotesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@NoArgsConstructor                       // this act as there is a constructor with no args in task entity
@AllArgsConstructor                     // this act as there is a constructor with all args in task entity
@Getter
@Setter
@Entity(name = "tasks")                 // This annotation is used to tell Spring that this class is an entity and should be mapped to a database table.
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // we use SEQUENCE generator like 1, 2, 3 ... so on.
    private Long id;
    @Column(nullable = false)  // this annotation is used to tell Spring that this field is a column in the database table. which is not null.
    private String title;
    private String description;
    @Column(nullable = false)
    private Boolean completed;
    private Date dueDate;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = NotesEntity.class, mappedBy = "task")
    private List<NotesEntity> notes;  // if we want that inside task array of notes should be present, then only we have to write this relationship.
                                     // if we don't define this relationship then also the mapping table will create by Hibernate.
}
