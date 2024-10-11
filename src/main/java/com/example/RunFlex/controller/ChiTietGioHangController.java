/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChatLieu;
import com.example.RunFlex.model.ChiTietGioHang;
import com.example.RunFlex.service.ChatLieuService;
import com.example.RunFlex.service.ChiTietGioHangService;
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
@RequestMapping("/chitietgiohang")
public class ChiTietGioHangController {
    @Autowired
    private ChiTietGioHangService chiTietGioHangService;

    @GetMapping()
    public List<ChiTietGioHang> getAll() {
        return chiTietGioHangService.getAll();
    }

    @PostMapping()
    public ChiTietGioHang add(@RequestBody ChiTietGioHang chiTietGioHang) {
        return chiTietGioHangService.add(chiTietGioHang);
    }

    @PutMapping("/{id}")
    public ChiTietGioHang update(@RequestBody ChiTietGioHang chiTietGioHang, @PathVariable Long id) {
        return chiTietGioHangService.update(id, chiTietGioHang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietGioHangService.delete(id);
    }
}
