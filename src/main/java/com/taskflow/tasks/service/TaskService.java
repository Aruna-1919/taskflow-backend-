package com.taskflow.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskflow.tasks.dto.TaskRequest;
import com.taskflow.tasks.dto.TaskResponse;
import com.taskflow.tasks.entity.Tasks;
import com.taskflow.tasks.entity.User;

import com.taskflow.tasks.repository.CategoryRepository;
import com.taskflow.tasks.repository.TaskRepository;
import com.taskflow.tasks.repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private UserRepository userRepo;

    // helper: finds the logged-in user from the email stored in the token
    private User currentUser(String email) {
        return userRepo.findByEmail(email);
    }

    // helper: finds a task only if it belongs to this user, else 404
    private Tasks findOwnedTask(Long taskId, Long userId) {
        return (Tasks) taskRepo.findByIdAndUserId(taskId, userId);
    }

    // helper: Tasks entity -> TaskResponse DTO
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

    // helper: copies values from TaskRequest into a Tasks entity
    // (used for both create and update)
    private void applyRequest(Tasks t, TaskRequest req) {
        t.setTitle(req.title());
        t.setDescription(req.description());
        t.setDueDate(req.dueDate());
        t.setPriority(req.priority());
        t.setStatus(req.status());
        t.setCategory(req.categoryId() != null
                ? catRepo.getReferenceById(req.categoryId())
                : null);
    }

    // GET all tasks of the logged-in user
    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks(String email) {
        Long userId = currentUser(email).getId();
        return taskRepo.findByUserId(userId).stream()
            .map(this::toResponse)
            .toList();
    }

    // CREATE a task for the logged-in user
    @Transactional
    public TaskResponse create(String email, TaskRequest req) {
        Tasks task = new Tasks();
        applyRequest(task, req);
        task.setUser(currentUser(email));
        return toResponse(taskRepo.save(task));
    }

    // GET one task (only if owned by the user)
    @Transactional(readOnly = true)
    public TaskResponse getTask(String email, Long id) {
        Long userId = currentUser(email).getId();
        return toResponse(findOwnedTask(id, userId));
    }

    // UPDATE a task (only if owned by the user)
    @Transactional
    public TaskResponse update(String email, Long id, TaskRequest req) {
        Long userId = currentUser(email).getId();
        Tasks task = findOwnedTask(id, userId);
        applyRequest(task, req);
        return toResponse(taskRepo.save(task));
    }

    // DELETE a task (only if owned by the user)
    @Transactional
    public void delete(String email, Long id) {
        Long userId = currentUser(email).getId();
        Tasks task = findOwnedTask(id, userId);
        taskRepo.delete(task);
    }
}