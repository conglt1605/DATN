/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.model.ThuongHieu;
import com.example.RunFlex.repository.DanhMucRepository;
import com.example.RunFlex.repository.ThuongHieuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class DanhMucService {
       @Autowired
    private DanhMucRepository danhMucRepository;

    public List<DanhMuc> getAll() {
        return danhMucRepository.getAll();
    }

    public DanhMuc add(DanhMuc danhMuc) {
        danhMuc.setTrangThai(1);
        return danhMucRepository.save(danhMuc);
    }

    public DanhMuc update(long id, DanhMuc danhMuc) {
        DanhMuc danhMucUpdate = danhMucRepository.findById(id).orElseThrow();

        danhMucUpdate.setTenDanhMuc(danhMuc.getTenDanhMuc());
        return danhMucRepository.save(danhMucUpdate);
    }

    public void delete(long id) {
        DanhMuc danhMucUpdate = danhMucRepository.findById(id).orElseThrow();
        danhMucUpdate.setTrangThai(0);
        danhMucRepository.save(danhMucUpdate);
    }
}
