/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.GioHang;
import com.example.RunFlex.repository.GioHangRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    public List<GioHang> getAll() {
        return gioHangRepository.getAll();
    }

    public GioHang add(GioHang gioHang) {
        gioHang.setTrangThai(1);
        return gioHangRepository.save(gioHang);
    }

//    public GioHang update(long id, GioHang gioHang) {
//        GioHang deGiayUpdate = gioHangRepository.findById(id).orElseThrow();
//        return gioHangRepository.save(deGiayUpdate);
//    }

//    public void delete(long id) {
//        GioHang gioHangUpdate = gioHangRepository.findById(id).orElseThrow();
//        gioHangUpdate.setTrangThai(0);
//        gioHangRepository.save(gioHangUpdate);
//    }
}
