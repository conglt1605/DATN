package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Category;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getCategoryWithStatusActive();
    ResponseEntity<?> saveCategory(Category category);
    ResponseEntity<?> updateCategory(Long id, Category category);
    ResponseEntity<?> deleteCategory(Long id);
}
