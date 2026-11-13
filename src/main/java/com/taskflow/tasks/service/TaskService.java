package com.taskflow.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.tasks.dto.TaskRequest;
import com.taskflow.tasks.dto.TaskResponse;
import com.taskflow.tasks.entity.Tasks;
import com.taskflow.tasks.repository.CategoryRepository;
import com.taskflow.tasks.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class TaskService {

    @Autowired 
    private TaskRepository taskRepo;
    @Autowired 
    private CategoryRepository catRepo;

    //helper function which translating Tasks object to TaskResponse 
    private TaskResponse toResponse(Tasks t) {
    return new TaskResponse(
            t.getId(),
            t.getTitle(),
            t.getDescription(),
            t.getStatus(),
            t.getPriority(),
            t.getDueDate(),
            t.getCreatedAt(),
            t.getCategory() != null ? t.getCategory().getId() : null,
            t.getCategory() != null ? t.getCategory().getName() : null
    );
}


    //helper function which translating TaskResponse object to Tasks object
    private Tasks apply(TaskRequest taskreRequest){
        Tasks t=new Tasks();
        t.setTitle(taskreRequest.title());
        t.setDescription(taskreRequest.description());
        t.setCategory(
            catRepo.getReferenceById(taskreRequest.categoryId())
        );
        t.setDueDate(taskreRequest.dueDate());
        t.setPriority(taskreRequest.priority());
        t.setStatus(taskreRequest.status());
        return t;
    }


    // getting all records
    public List<TaskResponse> getAllTasks() {
        return taskRepo.findAll().stream()
                .map(task -> this.toResponse(task))
                .toList();
        
    }


    // creating a task record 
    public TaskResponse create(TaskRequest taskrequest) {
        Tasks task=this.apply(taskrequest);
        taskRepo.save(task);
        return toResponse(task);
    }


    // getting a single task record 
    public TaskResponse getTask(Long id) {
        Tasks task=taskRepo.getReferenceById(id);
        return toResponse(task);
    }

}
