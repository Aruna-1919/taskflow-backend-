package com.taskflow.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskflow.tasks.entity.Tasks;

@Repository 
public interface TaskRepository extends JpaRepository<Tasks,Long> {

}
