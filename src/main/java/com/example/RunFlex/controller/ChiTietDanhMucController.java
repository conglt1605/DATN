/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChiTietDanhMuc;
import com.example.RunFlex.model.ChiTietHoaDon;
import com.example.RunFlex.service.ChiTietDanhMucService;
import com.example.RunFlex.service.ChiTietHoaDonService;
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
@RequestMapping("/chitietdanhmuc")
public class ChiTietDanhMucController {
       @Autowired
    private ChiTietDanhMucService chiTietDanhMucService;

    @GetMapping()
    public List<ChiTietDanhMuc> getAll() {
        return chiTietDanhMucService.getAll();
    }

    @PostMapping()
    public ChiTietDanhMuc add(@RequestBody ChiTietDanhMuc chiTietDanhMuc) {
        return chiTietDanhMucService.add(chiTietDanhMuc);
    }

    @PutMapping("/{id}")
    public ChiTietDanhMuc update(@RequestBody ChiTietDanhMuc chiTietDanhMuc, @PathVariable Long id) {
        return chiTietDanhMucService.update(id, chiTietDanhMuc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietDanhMucService.delete(id);
    }
}
