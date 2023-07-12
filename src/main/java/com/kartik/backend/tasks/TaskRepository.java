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

    - Why do we define TaskRepository as interface not class ?
        Becoz spring boot will use SimpleJpaRepository class as implementation of TaskRepository. so we defined it as an interface.
         the interface is just marked that what all repository i want. means every entity that I want to turn into repository
         I will have to just write this "public interface TaskRepository extends JpaRepository<TaskEntity, Long> {}"
         assume we create notes entity but I don't want NotesRepository to be created.

      How we will tell to SpringBoot that what all Entities we want to be turned into repository.
        by doing this "public interface TaskRepository extends JpaRepository<TaskEntity, Long> {}"
        we tell to springboot that whichever classes I extends JPAREPOSITORY, & mark it as @Repository, for those generate the Repository implementation.
      It is an interface becoz, so we don't need to define anything it will take all the defination from SimpleJpaRepository.


 */
