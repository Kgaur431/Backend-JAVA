package com.kartik.backend.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    // we have not written any code. JpaRepository provides all the methods we need

//    @Transactional
//    <S extends TaskEntity> S save(S entity);



}

/*
    - by default save method is not Transactional.
        To make save method transactional, we need to annotate it with @Transactional.
        || we can make all methods transactional by annotating TaskService with @Transactional
 */
