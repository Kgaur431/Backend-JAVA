package com.kartik.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Building a "Task Manager API" that does the following things:
    1. Create a Task with the following fields:
        - Title
        - Due Date
        - Status (Pending, In Progress, Done)
    2. Update a Task
    3. Delete a Task
    4. List all Tasks
*/

@RestController
@RequestMapping("/task")
public class TaskControllers {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}

/*
    Before implementing the API, we need to think like:-
        - what should be the design of the API || how do we send the task || what format do we send the task || what root should we use to create the task
        - Rest Api:- https://github.com/scaleracademy/Project-Module-Jul-2022

        -Post Request:- Create a new task with body.
                        we do not send Post Request with specific id. means we do not implement post request on entities directly
        -Put Request:-  Put & Post are very similar
                        if we send Put Request with body like /task/12 then it will create a new task with id 12 (here Client is generating the id)
                        but if we send the Post Request then it will create a new task on whatever next id is available (here server will generate the id).
        -Patch Request:- Update a task with body.
                         we send req with id 12, in body we have only status = "Done" then if task 12 exists then it will update the status of task 12 to "Done"
                            but if task 12 does not exists then Patch Request will failed.
        -Delete Request:- Delete a task with id.

        Put Vs Patch
            Put:- when we send put req along with body(contains object) then it will create new task or override the existence object with  whatever object we passed.
                    so put will never update the object, it will always override the object.
            Patch:- in Patch Req whatever fields we send in body, it will update those fields only. & whatever we do not send in body, it will not update those fields. they will remain same.
                    so patch will never override the object, it will always update the object.
        Idempotence:-
                    means if we send same req multiple times then it will not create multiple tasks. it will create only one task.
                    it means that "the change that happened to the resource is saved once if req goes once or multiple times"
                    so  Put, Delete are idempotent.
         Example:-  if we want to submit that payment has happened successfully kind of thing.
                     that a common implementation where most payment gateway is use Put Endpoint, becoz they generate unique payment id's already before making the payment.
                        & then weather the payment successes or failure they make a Put Endpoint.
                     the reason being Put is that it is idempotent.
                        like user can click on the button multiple times, but we do not want to create multiple payments. so by using Put we can make sure that we are not creating multiple payments.
                         even if user clicks multiple times, we will create only one payment. the second request will override the first request. & not trigger something new.
                   idempotent endpoints are those where instead of sending req once, if we send req by mistake two times quickly then the end result would be same.
                        like if we send delete req twice then it will delete the task only once & at second time it will show the message that task does not exists.
                        so delete is idempotent.
                   POST is not idempotent.
                        like if we send post req twice then it will create two tasks with different id's.
                        so post is not idempotent.
                   Patch is not idempotent.
                         Becoz it's depend on the existence data & what we are sending in body.
                          like if we send the patch req first then it will update the task with status "Done". suppose if someone else change done to not done. then we will update the task with status "Done"
                            but now the status has changes so we will know that the value has changed so we can't predict the end result.
                  Get is not idempotent.
                          becoz we are not changing anything. we are just reading the data.
 */