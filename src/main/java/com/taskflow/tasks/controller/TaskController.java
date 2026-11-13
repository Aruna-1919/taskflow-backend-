package com.taskflow.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.tasks.service.TaskService;
import com.taskflow.tasks.dto.*;

@RestController 
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired 
    private TaskService taskService;

    @GetMapping("")
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@RequestBody TaskRequest task){
        return taskService.create(task);
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

}
