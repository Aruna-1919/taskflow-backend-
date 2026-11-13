package com.taskflow.tasks.dto;

import com.taskflow.tasks.entity.Priority;
import com.taskflow.tasks.entity.TaskStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate,
        LocalDateTime createdAt,
        Long categoryId,
        String categoryName
) {}