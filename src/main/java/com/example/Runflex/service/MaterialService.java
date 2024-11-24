/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Material;
import com.example.Runflex.repository.MaterialRepository;
import com.example.Runflex.service.impl.IMaterialService;
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
public class MaterialService implements IMaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Material> materials = materialRepository.findAll();
        if (materials.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", materials));
    }

    @Override
    public ResponseEntity<?> getMaterialWithStatusActive() {
        List<Material> materials = materialRepository.getMaterialWithStatusActive();
        if (materials.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", materials));
    }

    @Override
    public ResponseEntity<?> saveMaterial(Material material) {
        if (material.getMaterialName() == null || material.getMaterialName().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tên chất liệu không được để trống"));
        }
        material.setStatus(Status.active);
        materialRepository.save(material);
        return ResponseEntity.ok(Map.of("Success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> deleteMaterial(Long id) {
        Material material = materialRepository.findById(id).orElseThrow();
        if (material == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy"));
        }
        material.setStatus(Status.delete);
        materialRepository.save(material);
        return ResponseEntity.ok(Map.of("Success", "Xóa thành công"));
    }

    @Override
    public ResponseEntity<?> updateMaterial(Long id, Material material) {
        Material existingMaterial = materialRepository.findById(id).orElseThrow();
        if (existingMaterial == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy"));
        }
        existingMaterial.setMaterialName(material.getMaterialName());
        materialRepository.save(existingMaterial);
        return ResponseEntity.ok(Map.of("Success", "Sửa thành công"));
    }
}
