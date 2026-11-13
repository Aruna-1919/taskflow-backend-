package com.taskflow.tasks.dto;

import com.taskflow.tasks.entity.Priority;
import com.taskflow.tasks.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record TaskRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 200, message = "Title must be at most 200 characters")
        String title,

        String description,

        TaskStatus status,      
        Priority priority,     
        LocalDate dueDate,      
        Long categoryId          
) {}