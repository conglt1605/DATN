/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietDanhMuc;
import com.example.RunFlex.model.ChiTietGioHang;
import com.example.RunFlex.repository.ChiTietDanhMucRepoSitory;
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
public class ChiTietDanhMucService {
    @Autowired
    private ChiTietDanhMucRepoSitory chiTietDanhMucRepoSitory;

    public List<ChiTietDanhMuc> getAll() {
        return chiTietDanhMucRepoSitory.getAll();
    }

    public ChiTietDanhMuc add(ChiTietDanhMuc chiTietDanhMuc) {
        chiTietDanhMuc.setTrangThai(1);
        return chiTietDanhMucRepoSitory.save(chiTietDanhMuc);
    }

    public ChiTietDanhMuc update(long id, ChiTietDanhMuc chiTietDanhMuc) {
        ChiTietDanhMuc chiTietDanhMucUpdate = chiTietDanhMucRepoSitory.findById(id).orElseThrow();

        chiTietDanhMucUpdate.setChiTietSanPham(chiTietDanhMuc.getChiTietSanPham());
        chiTietDanhMucUpdate.setDanhMuc(chiTietDanhMuc.getDanhMuc());
        return chiTietDanhMucRepoSitory.save(chiTietDanhMucUpdate);
    }

    public void delete(long id) {
        ChiTietDanhMuc chiTietDanhMucUpdate = chiTietDanhMucRepoSitory.findById(id).orElseThrow();
        chiTietDanhMucUpdate.setTrangThai(0);
        chiTietDanhMucRepoSitory.save(chiTietDanhMucUpdate);
    }
}
