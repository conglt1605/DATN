package com.example.Runflex.service;

import com.example.Runflex.entity.Category;
import com.example.Runflex.repository.CategoryRepository;
import com.example.Runflex.service.impl.ICategoryService;
import com.example.Runflex.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", categories));
    }

    @Override
    public ResponseEntity<?> getCategoryWithStatusActive() {
        List<Category> categories = categoryRepository.getCategoryWithStatusActive();
        if (categories.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", categories));
    }

    @Override
    public ResponseEntity<?> saveCategory(Category category) {
        if (category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tên danh mục không được để trống"));
        }
        category.setStatus(Status.active);
        categoryRepository.save(category);
        return ResponseEntity.ok(Map.of("Success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        if (category == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy danh mục"));
        }
        category.setStatus(Status.delete);
        categoryRepository.save(category);
        return ResponseEntity.ok(Map.of("Success", "Xóa thành công"));
    }

    @Override
    public ResponseEntity<?> updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        if (existingCategory == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy danh mục"));
        }
        existingCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(existingCategory);
        return ResponseEntity.ok(Map.of("Success", "Sửa thành công"));
    }


}
