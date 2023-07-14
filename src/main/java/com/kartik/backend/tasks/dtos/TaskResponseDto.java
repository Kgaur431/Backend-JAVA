package com.kartik.backend.tasks.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;

}


/*

     - Response Dto have such thing called Success & Failure that we handle in our controller

 */
