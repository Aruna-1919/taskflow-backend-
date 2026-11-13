package com.taskflow.tasks.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Setter 
@Getter 
@AllArgsConstructor @NoArgsConstructor 

@Table (name="tasks")
public class Tasks {

    //id, title, description, status, priority, dueDate, createdAt, category (ManyToOne), user (ManyToOne)
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TaskStatus status;


    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Priority priority;

    @Column (nullable = false)
    private LocalDate dueDate;

    @Column (nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne 
    @JoinColumn(name="category_id")
    private Category category;


    @ManyToOne 
    @JoinColumn(name="user_id")
    private User user;


    @PrePersist 
    void onCreate(){
        this.createdAt=LocalDateTime.now();
        if(this.status==null) this.status=TaskStatus.TODO;  
        if (this.priority==null) this.priority=Priority.LOW;


    }






}
