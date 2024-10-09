/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.model.ThuongHieu;
import com.example.RunFlex.service.DanhMucService;
import com.example.RunFlex.service.ThuongHieuService;
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
@RequestMapping("/danhmuc")
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping()
    public List<DanhMuc> getAll() {
        return danhMucService.getAll();
    }

    @PostMapping()
    public DanhMuc add(@RequestBody DanhMuc danhMuc) {
        return danhMucService.add(danhMuc);
    }

    @PutMapping("/{id}")
    public DanhMuc update(@RequestBody DanhMuc danhMuc, @PathVariable Long id) {
        return danhMucService.update(id, danhMuc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        danhMucService.delete(id);
    }
}
