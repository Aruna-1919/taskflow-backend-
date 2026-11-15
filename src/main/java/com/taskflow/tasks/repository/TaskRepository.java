package com.taskflow.tasks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskflow.tasks.entity.Tasks;

@Repository 
public interface TaskRepository extends JpaRepository<Tasks,Long> {

    // all tasks of one user -> where user_id = ?
    List<Tasks> findByUserId(Long userId);

    // one task, only if it belongs to that user -> where id = ? and user_id = ?
    Optional<Tasks> findByIdAndUserId(Long id, Long userId);
}
