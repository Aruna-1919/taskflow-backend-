package com.taskflow.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.tasks.dto.CategoryRequest;
import com.taskflow.tasks.dto.CategoryResponse;
import com.taskflow.tasks.service.CategoryService;


@RestController 
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired 
    private CategoryService catsService;


    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable Long id){
        return catsService.getCategory(id);
    }


    @GetMapping("")
    public List<CategoryResponse> getAll(){
        return catsService.getAll();
    }

    @PostMapping("")
    public CategoryResponse create(@RequestBody CategoryRequest catRequest){
        return catsService.create(catRequest);
    }


}
