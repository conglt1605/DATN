/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietHoaDon;
import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.repository.ChiTietHoaDonRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietHoaDonService {
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    

    public List<ChiTietHoaDon> add(List<ChiTietHoaDon> chiTietHoaDons) {
        List<ChiTietHoaDon> savedChiTietHoaDons = new ArrayList<>();
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
            chiTietHoaDon.setTrangThai(1);
            
            savedChiTietHoaDons.add(chiTietHoaDonRepository.save(chiTietHoaDon));
        }
        
        return savedChiTietHoaDons;
    }

    public ChiTietHoaDon update(long id, ChiTietHoaDon chiTietHoaDon) {
        ChiTietHoaDon chiTietHoaDonUpdate = chiTietHoaDonRepository.findById(id).orElseThrow();

        chiTietHoaDonUpdate.setHoaDon(chiTietHoaDon.getHoaDon());
        chiTietHoaDonUpdate.setChiTietSanPham(chiTietHoaDon.getChiTietSanPham());
        chiTietHoaDonUpdate.setSoLuong(chiTietHoaDon.getSoLuong());
        chiTietHoaDonUpdate.setTrangThai(chiTietHoaDon.getTrangThai());
        return chiTietHoaDonRepository.save(chiTietHoaDonUpdate);
    }

    public void delete(long id) {
        ChiTietHoaDon chiTietHoaDonUpdate = chiTietHoaDonRepository.findById(id).orElseThrow();
        chiTietHoaDonUpdate.setTrangThai(0);
        chiTietHoaDonRepository.save(chiTietHoaDonUpdate);
    }
    
    public List<ChiTietHoaDon> getCTSPById(Long id){
        return chiTietHoaDonRepository.getChiTietHoaDonById(id);
    }
}
