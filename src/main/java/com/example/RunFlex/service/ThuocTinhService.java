/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ThuocTinh;
import com.example.RunFlex.repository.ThuocTinhRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ThuocTinhService {
          @Autowired
    private ThuocTinhRepository thuocTinhRepository;

    public List<ThuocTinh> getAll() {
        return thuocTinhRepository.getAll();
    }

    public ThuocTinh add(ThuocTinh thuocTinh) {
        thuocTinh.setNgayTao(new Date());
        thuocTinh.setTrangThai(1);
        return thuocTinhRepository.save(thuocTinh);
    }

    public ThuocTinh update(long id, ThuocTinh thuocTinh) {
        ThuocTinh thuocTinhUpdate = thuocTinhRepository.findById(id).orElseThrow();

        thuocTinhUpdate.setTenThuocTinh(thuocTinh.getTenThuocTinh());
        thuocTinhUpdate.setMoTa(thuocTinh.getMoTa());
        return thuocTinhRepository.save(thuocTinhUpdate);
    }

    public void delete(long id) {
        ThuocTinh thuocTinhUpdate = thuocTinhRepository.findById(id).orElseThrow();
        thuocTinhUpdate.setTrangThai(0);
        thuocTinhRepository.save(thuocTinhUpdate);
    }
}
