/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ThuocTinh;
import com.example.RunFlex.model.ThuocTinhSanPham;
import com.example.RunFlex.service.ThuocTinhSanPhamService;
import com.example.RunFlex.service.ThuocTinhService;
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
@RequestMapping("/thuoctinhsanpham")
public class ThuocTinhSanPhamController {
           @Autowired
    private ThuocTinhSanPhamService thuocTinhSanPhamService;

    @GetMapping()
    public List<ThuocTinhSanPham> getAll() {
        return thuocTinhSanPhamService.getAll();
    }
    
        @PostMapping()
    public ThuocTinhSanPham add(@RequestBody ThuocTinhSanPham thuocTinhSanPham) {
        return thuocTinhSanPhamService.add(thuocTinhSanPham);
    }

    @PutMapping("/{id}")
    public ThuocTinhSanPham update(@RequestBody ThuocTinhSanPham thuocTinhSanPham, @PathVariable Long id) {
        return thuocTinhSanPhamService.update(id, thuocTinhSanPham);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        thuocTinhSanPhamService.delete(id);
    }
}
