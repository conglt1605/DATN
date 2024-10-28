/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChiTietThuocTinh;
import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.service.ChiTietThuocTinhService;
import com.example.RunFlex.service.DanhMucService;
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
@RequestMapping("/chitietthuoctinh")
public class ChiTietThuocTinhController {
    @Autowired
    private ChiTietThuocTinhService chiTietThuocTinhService;

    @GetMapping()
    public List<ChiTietThuocTinh> getAll() {
        return chiTietThuocTinhService.getAll();
    }

    @PostMapping()
    public ChiTietThuocTinh add(@RequestBody ChiTietThuocTinh chiTietThuocTinh) {
        return chiTietThuocTinhService.add(chiTietThuocTinh);
    }

    @PutMapping("/{id}")
    public ChiTietThuocTinh update(@RequestBody ChiTietThuocTinh chiTietThuocTinh, @PathVariable Long id) {
        return chiTietThuocTinhService.update(id, chiTietThuocTinh);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietThuocTinhService.delete(id);
    }
}
