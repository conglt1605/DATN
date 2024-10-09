/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.KhachHang;
import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.service.KhachHangService;
import com.example.RunFlex.service.NhanVienService;
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
@RequestMapping("/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    
    @GetMapping()
    public List<KhachHang> getAll(){
        return khachHangService.getAll();
    }
    
    @PostMapping()
    public KhachHang add(@RequestBody KhachHang khachHang){
        return khachHangService.add(khachHang);
    }
    
    @PutMapping("/{id}")
    public KhachHang update(@RequestBody KhachHang khachHang, @PathVariable Long id){
        return khachHangService.update(id, khachHang);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         khachHangService.delete(id);
    }
}
