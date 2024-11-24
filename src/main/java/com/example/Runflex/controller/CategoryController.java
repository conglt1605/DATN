package com.example.Runflex.controller;

import com.example.Runflex.entity.Category;
import com.example.Runflex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return categoryService.getAll();
    }
    
    @GetMapping("/active")
    public ResponseEntity<?> getCategoryWithStatusActive() {
        return categoryService.getCategoryWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }
}
