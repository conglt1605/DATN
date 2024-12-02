/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Color;
import org.springframework.http.ResponseEntity;

public interface IColorService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getColorWithStatusActive();
    ResponseEntity<?> saveColor(Color color);
    ResponseEntity<?> updateColor(Long id, Color color);
    ResponseEntity<?> deleteColor(Long id);
}

