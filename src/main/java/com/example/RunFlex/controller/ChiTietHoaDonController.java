/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChiTietGioHang;
import com.example.RunFlex.model.ChiTietHoaDon;
import com.example.RunFlex.service.ChiTietGioHangService;
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
@RequestMapping("/chitiethoadon")
public class ChiTietHoaDonController {
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping()
    public List<ChiTietHoaDon> getAll() {
        return chiTietHoaDonService.getAll();
    }

    @PostMapping()
    public ChiTietHoaDon add(@RequestBody ChiTietHoaDon chiTietHoaDon) {
        return chiTietHoaDonService.add(chiTietHoaDon);
    }

    @PutMapping("/{id}")
    public ChiTietHoaDon update(@RequestBody ChiTietHoaDon chiTietHoaDon, @PathVariable Long id) {
        return chiTietHoaDonService.update(id, chiTietHoaDon);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietHoaDonService.delete(id);
    }
}