/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.KhuyenMai;
import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.repository.KhuyenMaiRepository;
import com.example.RunFlex.repository.KichCoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class KhuyenMaiService {
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }

    public KhuyenMai add(KhuyenMai kichCo) {
        kichCo.setTrangThai(1);
        return khuyenMaiRepository.save(kichCo);
    }

    public KhuyenMai update(long id, KhuyenMai khuyenMai) {
        KhuyenMai khuyenMaiUpdate = khuyenMaiRepository.findById(id).orElseThrow();

        khuyenMaiUpdate.setMaKhuyenMai(khuyenMai.getMaKhuyenMai());
        khuyenMaiUpdate.setTenKhuyenMai(khuyenMai.getTenKhuyenMai());
        khuyenMaiUpdate.setNgayBatDau(khuyenMai.getNgayBatDau());
        khuyenMaiUpdate.setNgayKetThuc(khuyenMai.getNgayKetThuc());
        khuyenMaiUpdate.setMoTa(khuyenMai.getMoTa());
        return khuyenMaiRepository.save(khuyenMaiUpdate);
    }

    public void delete(long id) {
        KhuyenMai khuyenMaiUpdate = khuyenMaiRepository.findById(id).orElseThrow();
        khuyenMaiUpdate.setTrangThai(0);
        khuyenMaiRepository.save(khuyenMaiUpdate);
    }
}
