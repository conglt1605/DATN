/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietAnhGiay;
import com.example.RunFlex.repository.ChiTietAnhGiayRepository;
import java.util.ArrayList;
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

    public List<ChiTietAnhGiay> add(List<ChiTietAnhGiay> chiTietAnhGiays) {
        List<ChiTietAnhGiay> addChiTietAnhGiay = new ArrayList<>();
        for (ChiTietAnhGiay chiTietAnhGiay : chiTietAnhGiays) {
            chiTietAnhGiay.setTrangThai(1);
            addChiTietAnhGiay.add(chiTietAnhGiayRepository.save(chiTietAnhGiay));
        }
        return addChiTietAnhGiay;
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
    
    public List<ChiTietAnhGiay> getAllByIdCTSP(Long id){
        return chiTietAnhGiayRepository.getAllByIdCTSP(id);
    }
}
