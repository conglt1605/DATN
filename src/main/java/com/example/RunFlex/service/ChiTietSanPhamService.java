/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.repository.ChiTietSanPhamRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        chiTietSanPham.setTrangThai(1);
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public ChiTietSanPham update(long id, ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham chiTietSanPhamUpdate = chiTietSanPhamRepository.findById(id).orElseThrow();
        // Cập nhật các trường
        return chiTietSanPhamRepository.save(chiTietSanPhamUpdate);
    }

    public void delete(long id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElseThrow();
        chiTietSanPham.setTrangThai(0);
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public List<Object[]> getTongSLSP() {
        return chiTietSanPhamRepository.getTongSLSP();
    }
    
    public List<ChiTietSanPham> getCTSPByID(long id){
        return chiTietSanPhamRepository.getCTSPByID(id);
    }
}
