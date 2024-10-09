/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.model.ThuongHieu;
import com.example.RunFlex.repository.ThuongHieuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ThuongHieuService {
       @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.getAll();
    }

    public ThuongHieu add(ThuongHieu thuongHieu) {
        thuongHieu.setTrangThai(1);
        return thuongHieuRepository.save(thuongHieu);
    }

    public ThuongHieu update(long id, ThuongHieu thuongHieu) {
        ThuongHieu thuongHieuUpdate = thuongHieuRepository.findById(id).orElseThrow();

        thuongHieuUpdate.setTenThuongHieu(thuongHieu.getTenThuongHieu());
        return thuongHieuRepository.save(thuongHieuUpdate);
    }

    public void delete(long id) {
        ThuongHieu thuongHieuUpdate = thuongHieuRepository.findById(id).orElseThrow();
        thuongHieuUpdate.setTrangThai(0);
        thuongHieuRepository.save(thuongHieuUpdate);
    }
}
