/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Brand;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cong
 */
public interface IBrandService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getBrandWithStatusActive();
    ResponseEntity<?> saveBrand(Brand brand);
    ResponseEntity<?> updateBrand(Long id,Brand brand);
    ResponseEntity<?> deleteBrand(Long id);
}
