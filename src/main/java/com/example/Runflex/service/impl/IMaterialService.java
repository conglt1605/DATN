/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Material;
import org.springframework.http.ResponseEntity;

public interface IMaterialService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getMaterialWithStatusActive();
    ResponseEntity<?> saveMaterial(Material material);
    ResponseEntity<?> updateMaterial(Long id, Material material);
    ResponseEntity<?> deleteMaterial(Long id);
}

