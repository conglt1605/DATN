/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.Material;
import com.example.Runflex.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return materialService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getMaterialWithStatusActive() {
        return materialService.getMaterialWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Material material) {
        return materialService.saveMaterial(material);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Material material) {
        return materialService.updateMaterial(id, material);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return materialService.deleteMaterial(id);
    }
}

