/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.model.ChiTietThuocTinh;
import com.example.RunFlex.repository.AnhGiayRepository;
import com.example.RunFlex.repository.ChiTietThuocTinhRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietThuocTinhService {
       @Autowired
    private ChiTietThuocTinhRepository chiTietThuocTinhRepository;

    public List<ChiTietThuocTinh> getAll() {
        return chiTietThuocTinhRepository.getAll();
    }

    public ChiTietThuocTinh add(ChiTietThuocTinh chiTietThuocTinh) {
        chiTietThuocTinh.setTrangThai(1);
        return chiTietThuocTinhRepository.save(chiTietThuocTinh);
    }

    public ChiTietThuocTinh update(long id, ChiTietThuocTinh chiTietThuocTinh) {
        ChiTietThuocTinh chiTietThuocTinhUpdate = chiTietThuocTinhRepository.findById(id).orElseThrow();

        chiTietThuocTinhUpdate.setThuocTinh(chiTietThuocTinh.getThuocTinh());
        chiTietThuocTinhUpdate.setLoai(chiTietThuocTinh.getLoai());
        return chiTietThuocTinhRepository.save(chiTietThuocTinhUpdate);
    }

    public void delete(long id) {
        ChiTietThuocTinh chiTietThuocTinhUpdate = chiTietThuocTinhRepository.findById(id).orElseThrow();
        chiTietThuocTinhUpdate.setTrangThai(0);
        chiTietThuocTinhRepository.save(chiTietThuocTinhUpdate);
    } 
}
