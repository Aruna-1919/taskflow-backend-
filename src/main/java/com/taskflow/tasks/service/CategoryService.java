package com.taskflow.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.tasks.dto.CategoryRequest;
import com.taskflow.tasks.dto.CategoryResponse;
import com.taskflow.tasks.entity.Category;
import com.taskflow.tasks.repository.CategoryRepository;

@Service 
public class CategoryService {

    @Autowired 
    private CategoryRepository catRepo;

    // helper function converts Category to categoryResponse
    private CategoryResponse convertToCR(Category cat){
        CategoryResponse catRes=new CategoryResponse(cat.getId(),cat.getName());
        return catRes;
    }


    // helper function converts categoryRequest to Category 
    private Category convertToC(CategoryRequest catres){
        Category cat=new Category();
        cat.setName(catres.name());
        return cat;
    }

    public CategoryResponse getCategory(Long id) {
        Category category=catRepo.getReferenceById(id);
        return convertToCR(category);
    }


    public List<CategoryResponse> getAll() {
       return catRepo.findAll().stream().map(cat->this.convertToCR(cat)).toList();
    }


    public CategoryResponse create(CategoryRequest catRequest) {
        Category category=this.convertToC(catRequest);
        catRepo.save(category);
        return this.convertToCR(category);
    }

}
