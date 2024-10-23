/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.service.NhanVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author admin
 */
@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {
    
    @Autowired
    private NhanVienService nhanvienService;
    
    @GetMapping("/all")
    public List<NhanVien> getAll(){
        return nhanvienService.getAll();
    }
    
    @GetMapping("/hoatdong")
    public List<NhanVien> getNhanVienHoatDong(){
        return nhanvienService.getNhanVienHoatDong();
    }
    
    @GetMapping("/nghiviec")
    public List<NhanVien> getNhanVienNghiViec(){
        return nhanvienService.getNhanVienNghiViec();
    }
    
    @GetMapping("/quanly")
    public List<NhanVien> getQuanLy(){
        return nhanvienService.getQuanLy();
    }
    
    @GetMapping("/nhanvien")
    public List<NhanVien> getNhanVien(){
        return nhanvienService.getNhanVien();
    }
    
    @PostMapping()
    public NhanVien add(@RequestBody NhanVien nhanVien){
        return nhanvienService.add(nhanVien);
    }
    
    @PutMapping("/{id}")
    public NhanVien update(@RequestBody NhanVien nhanVien, @PathVariable Long id){
        return nhanvienService.update(id, nhanVien);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         nhanvienService.delete(id);
    }
}