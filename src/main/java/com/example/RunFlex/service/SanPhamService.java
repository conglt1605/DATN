/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.repository.SanPhamRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    public SanPham add(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public SanPham update(long id, SanPham sanPham) {
        SanPham sanPhamUpdate = sanPhamRepository.findById(id).orElseThrow();

        sanPhamUpdate.setTenSP(sanPham.getTenSP());
        sanPhamUpdate.setSoLuong(sanPham.getSoLuong());
        return sanPhamRepository.save(sanPhamUpdate);
    }

    public void delete(long id) {
        SanPham sanPhamUpdate = sanPhamRepository.findById(id).orElseThrow();
        
        sanPhamUpdate.setTrangThai(0);
        sanPhamRepository.save(sanPhamUpdate);
    }
}
