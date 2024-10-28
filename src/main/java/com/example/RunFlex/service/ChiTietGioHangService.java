/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietGioHang;
import com.example.RunFlex.repository.ChiTietGioHangRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietGioHangService {
    @Autowired
    private ChiTietGioHangRepository chiTietGioHangRepository;

    public List<ChiTietGioHang> getAll() {
        return chiTietGioHangRepository.getAll();
    }

    public ChiTietGioHang add(ChiTietGioHang chiTietGioHang) {
        chiTietGioHang.setTrangThai(1);
        return chiTietGioHangRepository.save(chiTietGioHang);
    }

    public ChiTietGioHang update(long id, ChiTietGioHang chiTietGioHang) {
        ChiTietGioHang chiTietGioHangUpdate = chiTietGioHangRepository.findById(id).orElseThrow();

        chiTietGioHangUpdate.setGioHang(chiTietGioHang.getGioHang());
        chiTietGioHangUpdate.setChiTietSanPham(chiTietGioHang.getChiTietSanPham());
        chiTietGioHangUpdate.setSoLuong(chiTietGioHang.getSoLuong());
        chiTietGioHangUpdate.setNgayTao(new Date());
        chiTietGioHangUpdate.setTrangThai(chiTietGioHang.getTrangThai());
        return chiTietGioHangRepository.save(chiTietGioHangUpdate);
    }

    public void delete(long id) {
        ChiTietGioHang chiTietGioHangUpdate = chiTietGioHangRepository.findById(id).orElseThrow();
        chiTietGioHangUpdate.setTrangThai(0);
        chiTietGioHangRepository.save(chiTietGioHangUpdate);
    }
}
