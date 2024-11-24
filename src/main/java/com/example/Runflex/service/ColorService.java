/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Color;
import com.example.Runflex.repository.ColorRepository;
import com.example.Runflex.service.impl.IColorService;
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
public class ColorService implements IColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Color> colors = colorRepository.findAll();
        if (colors.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", colors));
    }

    @Override
    public ResponseEntity<?> getColorWithStatusActive() {
        List<Color> colors = colorRepository.getColorWithStatusActive();
        if (colors.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", colors));
    }

    @Override
    public ResponseEntity<?> saveColor(Color color) {
        if (color.getColorName() == null || color.getColorName().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tên màu không được để trống"));
        }
        color.setStatus(Status.active);
        colorRepository.save(color);
        return ResponseEntity.ok(Map.of("Success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> deleteColor(Long id) {
        Color color = colorRepository.findById(id).orElseThrow();
        if (color == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy"));
        }
        color.setStatus(Status.delete);
        colorRepository.save(color);
        return ResponseEntity.ok(Map.of("Success", "Xóa thành công"));
    }

    @Override
    public ResponseEntity<?> updateColor(Long id, Color color) {
        Color existingColor = colorRepository.findById(id).orElseThrow();
        if (existingColor == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy"));
        }
        existingColor.setColorName(color.getColorName());
        colorRepository.save(existingColor);
        return ResponseEntity.ok(Map.of("Success", "Sửa thành công"));
    }
}
