/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Brand;
import com.example.Runflex.repository.BrandRepository;
import com.example.Runflex.service.impl.IBrandService;
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
public class BrandService implements IBrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Brand> brands = brandRepository.findAll();
        if (brands.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sach Trong"));
        }
        return ResponseEntity.ok(Map.of("Succes", brands));
    }

    @Override
    public ResponseEntity<?> getBrandWithStatusActive() {
        List<Brand> brands = brandRepository.getBrandWithStatusActive();
        if (brands.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Succes", brands));
    }

    @Override
    public ResponseEntity<?> saveBrand(Brand brand) {
        if (brand.getBrandName().equals("") || brand.getBrandName() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Ten Hang K Duoc De Trong"));
        }
        brand.setStatus(Status.active);
        brandRepository.save(brand);
        return ResponseEntity.ok(Map.of("Succes", "Them Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> deleteBrand(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        if (brand == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        brand.setStatus(Status.delete);
        brandRepository.save(brand);
        return ResponseEntity.ok(Map.of("Succes", "Xoa Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> updateBrand(Long id, Brand brand) {
        Brand existingBrand = brandRepository.findById(id).orElseThrow();
        if (brand == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        existingBrand.setBrandName(brand.getBrandName());
        brandRepository.save(existingBrand);
        return ResponseEntity.ok(Map.of("Succes","Sua Thanh Cong"));
    }

}
