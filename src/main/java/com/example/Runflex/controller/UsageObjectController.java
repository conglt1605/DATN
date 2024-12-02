/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.UsageObject;
import com.example.Runflex.service.UsageObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usageobject")
public class UsageObjectController {

    @Autowired
    private UsageObjectService usageObjectService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return usageObjectService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getUsageObjectsWithStatusActive() {
        return usageObjectService.getUsageObjectsWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UsageObject usageObject) {
        return usageObjectService.saveUsageObject(usageObject);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UsageObject usageObject) {
        return usageObjectService.updateUsageObject(id, usageObject);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return usageObjectService.deleteUsageObject(id);
    }
}

