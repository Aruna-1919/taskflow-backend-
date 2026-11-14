package com.taskflow.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.tasks.dto.TaskRequest;
import com.taskflow.tasks.dto.TaskResponse;
import com.taskflow.tasks.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET /api/tasks -> all tasks of the logged-in user
    @GetMapping("")
    public List<TaskResponse> getAllTasks(@AuthenticationPrincipal UserDetails principal) {
        return taskService.getAllTasks(principal.getUsername());
    }

    // POST /api/tasks -> create a task for the logged-in user
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@AuthenticationPrincipal UserDetails principal,
                               @Valid @RequestBody TaskRequest request) {
        return taskService.create(principal.getUsername(), request);
    }

    // GET /api/tasks/{id} -> one task (only if it belongs to the user)
    @GetMapping("/{id}")
    public TaskResponse getTask(@AuthenticationPrincipal UserDetails principal,
                                @PathVariable Long id) {
        return taskService.getTask(principal.getUsername(), id);
    }

    // PUT /api/tasks/{id} -> update a task
    @PutMapping("/{id}")
    public TaskResponse update(@AuthenticationPrincipal UserDetails principal,
                               @PathVariable Long id,
                               @Valid @RequestBody TaskRequest request) {
        return taskService.update(principal.getUsername(), id, request);
    }

    // DELETE /api/tasks/{id} -> delete a task
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal UserDetails principal,
                       @PathVariable Long id) {
        taskService.delete(principal.getUsername(), id);
    }
}