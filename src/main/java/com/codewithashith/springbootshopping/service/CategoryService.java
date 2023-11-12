package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.dto.CategoryDto;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.repository.CategoryRepository;
import com.codewithashith.springbootshopping.request.CategoryRequest;
import com.codewithashith.springbootshopping.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryDto categoryDto;

    public CategoryResponse findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryDto.mapToCategoryResponse(categories);
    }

    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse update(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse deleteById(Integer id) {
        categoryRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
