/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Size;
import org.springframework.http.ResponseEntity;

public interface ISizeService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getSizeWithStatusActive();
    ResponseEntity<?> saveSize(Size size);
    ResponseEntity<?> updateSize(Long id, Size size);
    ResponseEntity<?> deleteSize(Long id);
}

