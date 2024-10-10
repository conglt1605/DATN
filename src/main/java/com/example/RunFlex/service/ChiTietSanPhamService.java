/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.repository.ChiTietSanPhamRepository;
import com.example.RunFlex.repository.DanhMucRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietSanPhamService {
       @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        chiTietSanPham.setTrangThai(1);
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public ChiTietSanPham update(long id, ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham chiTietSanPhamUpdate = chiTietSanPhamRepository.findById(id).orElseThrow();

        chiTietSanPham.setSanPham(chiTietSanPham.getSanPham());
        chiTietSanPham.setNhanVien(chiTietSanPham.getNhanVien());
        chiTietSanPham.setMauSac(chiTietSanPham.getMauSac());
        chiTietSanPham.setThuongHieu(chiTietSanPham.getThuongHieu());
        chiTietSanPham.setDanhMuc(chiTietSanPham.getDanhMuc());
        chiTietSanPham.setChatLieu(chiTietSanPham.getChatLieu());
        chiTietSanPham.setDeGiay(chiTietSanPham.getDeGiay());
        chiTietSanPham.setKichCo(chiTietSanPham.getKichCo());
        chiTietSanPham.setXuatXu(chiTietSanPham.getXuatXu());
        chiTietSanPham.setAnhGiay(chiTietSanPham.getAnhGiay());
        chiTietSanPham.setKhuyenMai(chiTietSanPham.getKhuyenMai());
        chiTietSanPham.setMaSanPham(chiTietSanPham.getMaSanPham());
        chiTietSanPham.setSoLuong(chiTietSanPham.getSoLuong());
        chiTietSanPham.setGiaBan(chiTietSanPham.getGiaBan());
        chiTietSanPham.setGiaNhap(chiTietSanPham.getGiaNhap());
        chiTietSanPham.setDoiTuongSuDung(chiTietSanPham.getDoiTuongSuDung());
        chiTietSanPham.setMoTa(chiTietSanPham.getMoTa());
        chiTietSanPham.setNgayTao(new Date());
        chiTietSanPham.setMoTa(chiTietSanPham.getMoTa());
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public void delete(long id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElseThrow();
        chiTietSanPham.setTrangThai(0);
        chiTietSanPhamRepository.save(chiTietSanPham);
    }
}
