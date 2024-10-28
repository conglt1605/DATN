/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ThuocTinh;
import com.example.RunFlex.model.ThuocTinhSanPham;
import com.example.RunFlex.repository.ThuocTinhRepository;
import com.example.RunFlex.repository.ThuocTinhSanPhamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ThuocTinhSanPhamService {

    @Autowired
    private ThuocTinhSanPhamRepository thuocTinhSanPhamRepository;

    public List<ThuocTinhSanPham> getAll() {
        return thuocTinhSanPhamRepository.getAll();
    }

    public ThuocTinhSanPham add(ThuocTinhSanPham thuocTinhSanPham) {
        thuocTinhSanPham.setTrangThai(1);
        return thuocTinhSanPhamRepository.save(thuocTinhSanPham);
    }

    public ThuocTinhSanPham update(long id, ThuocTinhSanPham thuocTinhSanPham) {
        ThuocTinhSanPham ThuocTinhSanPhamUpdate = thuocTinhSanPhamRepository.findById(id).orElseThrow();

        ThuocTinhSanPhamUpdate.setChiTietSanPham(thuocTinhSanPham.getChiTietSanPham());
        ThuocTinhSanPhamUpdate.setChiTietThuocTinh(thuocTinhSanPham.getChiTietThuocTinh());
        return thuocTinhSanPhamRepository.save(ThuocTinhSanPhamUpdate);
    }

    public void delete(long id) {
        ThuocTinhSanPham ThuocTinhSanPhamUpdate = thuocTinhSanPhamRepository.findById(id).orElseThrow();
        ThuocTinhSanPhamUpdate.setTrangThai(0);
        thuocTinhSanPhamRepository.save(ThuocTinhSanPhamUpdate);
    }
}
