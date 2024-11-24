/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.UsageObject;
import com.example.Runflex.repository.UsageObjectRepository;
import com.example.Runflex.service.impl.IUsageObjectService;
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
public class UsageObjectService implements IUsageObjectService {

    @Autowired
    private UsageObjectRepository usageObjectRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<UsageObject> usageObjects = usageObjectRepository.findAll();
        if (usageObjects.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", usageObjects));
    }

    @Override
    public ResponseEntity<?> getUsageObjectsWithStatusActive() {
        List<UsageObject> usageObjects = usageObjectRepository.getUsageObjectsWithStatusActive();
        if (usageObjects.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", usageObjects));
    }

    @Override
    public ResponseEntity<?> saveUsageObject(UsageObject usageObject) {
        if (usageObject.getUsageObjectName() == null || usageObject.getUsageObjectName().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tên đối tượng sử dụng không được để trống"));
        }
        usageObject.setStatus(Status.active);
        usageObjectRepository.save(usageObject);
        return ResponseEntity.ok(Map.of("Success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> deleteUsageObject(Long id) {
        UsageObject usageObject = usageObjectRepository.findById(id).orElse(null);
        if (usageObject == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy đối tượng sử dụng"));
        }
        usageObject.setStatus(Status.delete);
        usageObjectRepository.save(usageObject);
        return ResponseEntity.ok(Map.of("Success", "Xóa thành công"));
    }

    @Override
    public ResponseEntity<?> updateUsageObject(Long id, UsageObject usageObject) {
        UsageObject existingUsageObject = usageObjectRepository.findById(id).orElse(null);
        if (existingUsageObject == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy đối tượng sử dụng"));
        }
        existingUsageObject.setUsageObjectName(usageObject.getUsageObjectName());
        usageObjectRepository.save(existingUsageObject);
        return ResponseEntity.ok(Map.of("Success", "Sửa thành công"));
    }
}
