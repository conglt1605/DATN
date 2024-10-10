/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.KhuyenMai;
import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.service.KhuyenMaiService;
import com.example.RunFlex.service.KichCoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/khuyenmai")
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping()
    public List<KhuyenMai> getAll() {
        return khuyenMaiService.getAll();
    }

    @PostMapping()
    public KhuyenMai add(@RequestBody KhuyenMai khuyenMai) {
        return khuyenMaiService.add(khuyenMai);
    }

    @PutMapping("/{id}")
    public KhuyenMai update(@RequestBody KhuyenMai khuyenMai, @PathVariable Long id) {
        return khuyenMaiService.update(id, khuyenMai);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        khuyenMaiService.delete(id);
    }
}
