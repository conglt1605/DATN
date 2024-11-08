/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietAnhGiay;
import com.example.RunFlex.model.ChiTietDanhMuc;
import com.example.RunFlex.repository.ChiTietAnhGiayRepository;
import com.example.RunFlex.repository.ChiTietDanhMucRepoSitory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietAnhGiayService {
       @Autowired
    private ChiTietAnhGiayRepository chiTietAnhGiayRepository;

    public List<ChiTietAnhGiay> getAll() {
        return chiTietAnhGiayRepository.getAll();
    }

    public ChiTietAnhGiay add(ChiTietAnhGiay chiTietAnhGiay) {
        chiTietAnhGiay.setTrangThai(1);
        return chiTietAnhGiayRepository.save(chiTietAnhGiay);
    }

    public ChiTietAnhGiay update(long id, ChiTietAnhGiay chiTietAnhGiay) {
        ChiTietAnhGiay chiTietAnhGiayUpdate = chiTietAnhGiayRepository.findById(id).orElseThrow();

        chiTietAnhGiayUpdate.setChiTietSanPham(chiTietAnhGiay.getChiTietSanPham());
        chiTietAnhGiayUpdate.setAnhGiay(chiTietAnhGiay.getAnhGiay());
        return chiTietAnhGiayRepository.save(chiTietAnhGiayUpdate);
    }

    public void delete(long id) {
        ChiTietAnhGiay chiTietAnhGiayUpdate = chiTietAnhGiayRepository.findById(id).orElseThrow();
        chiTietAnhGiayUpdate.setTrangThai(0);
        chiTietAnhGiayRepository.save(chiTietAnhGiayUpdate);
    }
}
