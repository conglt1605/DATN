/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Size;
import com.example.Runflex.repository.SizeRepository;
import com.example.Runflex.service.impl.ISizeService;
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
public class SizeService implements ISizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Size> sizes = sizeRepository.findAll();
        if (sizes.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", sizes));
    }

    @Override
    public ResponseEntity<?> getSizeWithStatusActive() {
        List<Size> sizes = sizeRepository.getSizeWithStatusActive();
        if (sizes.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", sizes));
    }

    @Override
    public ResponseEntity<?> saveSize(Size size) {
        if (size.getSizeNumber() <= 0) {
            return ResponseEntity.badRequest().body(Map.of("error", "Số kích cỡ phải lớn hơn 0"));
        }
        size.setStatus(Status.active);
        sizeRepository.save(size);
        return ResponseEntity.ok(Map.of("Success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> deleteSize(Long id) {
        Size size = sizeRepository.findById(id).orElse(null);
        if (size == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy kích cỡ"));
        }
        size.setStatus(Status.delete);
        sizeRepository.save(size);
        return ResponseEntity.ok(Map.of("Success", "Xóa thành công"));
    }

    @Override
    public ResponseEntity<?> updateSize(Long id, Size size) {
        Size existingSize = sizeRepository.findById(id).orElse(null);
        if (existingSize == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy kích cỡ"));
        }
        existingSize.setSizeNumber(size.getSizeNumber());
        sizeRepository.save(existingSize);
        return ResponseEntity.ok(Map.of("Success", "Sửa thành công"));
    }
}

