package com.codewithashith.springbootshopping.dto;

import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.request.CategoryRequest;
import com.codewithashith.springbootshopping.request.RegisterRequest;
import com.codewithashith.springbootshopping.response.AuthResponse;
import com.codewithashith.springbootshopping.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto {

    public CategoryResponse mapToCategoryResponse(List<Category> categories) {
        CategoryResponse categoryResponse = new CategoryResponse();

        ArrayList<CategoryRequest> categoryRequests = new ArrayList<>();
        for (Category category : categories) {
            categoryRequests.add(new CategoryRequest(category.getId(), category.getTitle()));
        }

        categoryResponse.setCategories(categoryRequests);
        return categoryResponse;
    }

    public Category mapToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        if (categoryRequest.getId() != null) {
            category.setId(categoryRequest.getId());
        }
        category.setTitle(categoryRequest.getTitle());
        return category;
    }
}
