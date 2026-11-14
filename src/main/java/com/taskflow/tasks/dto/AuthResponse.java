package com.taskflow.tasks.dto;

public record AuthResponse(String token, UserResponse user) {}