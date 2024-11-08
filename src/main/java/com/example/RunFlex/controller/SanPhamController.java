/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.service.DanhMucService;
import com.example.RunFlex.service.NhanVienService;
import com.example.RunFlex.service.SanPhamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
    @RestController
@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
  @Autowired
    private SanPhamService sanPhamService;
  @Autowired
    private DanhMucService danhMucService;
    
    @GetMapping()
    public List<SanPham> getAll(){
        return sanPhamService.getAll();
    }
    
    @PostMapping()
    public SanPham add(@RequestBody SanPham sanPham){
        return sanPhamService.add(sanPham);
    }
    
    @PutMapping("/{id}")
    public SanPham update(@RequestBody SanPham sanPham, @PathVariable Long id){
        return sanPhamService.update(id, sanPham);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         sanPhamService.delete(id);
    }
    
@GetMapping("/loc")
public ResponseEntity<List<SanPham>> locSanPham(@RequestParam List<Long> danhMucIds) {
    List<SanPham> sanPhams = sanPhamService.locSanPhamTheoDanhMuc(danhMucIds);
    return ResponseEntity.ok(sanPhams);
}


}
