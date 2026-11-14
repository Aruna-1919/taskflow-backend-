package com.taskflow.tasks.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskflow.tasks.entity.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
