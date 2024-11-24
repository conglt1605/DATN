/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.Size;
import com.example.Runflex.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/size")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return sizeService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getSizeWithStatusActive() {
        return sizeService.getSizeWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Size size) {
        return sizeService.saveSize(size);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Size size) {
        return sizeService.updateSize(id, size);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return sizeService.deleteSize(id);
    }
}

