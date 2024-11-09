/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.repository.ChiTietSanPhamRepository;
import com.example.RunFlex.repository.KichCoRepository;
import com.example.RunFlex.repository.MauSacRepository;
import com.example.RunFlex.repository.SanPhamRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;

    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

public List<ChiTietSanPham> add(List<ChiTietSanPham> chiTietSanPhams) {
    List<ChiTietSanPham> savedChiTietSanPhams = new ArrayList<>();
    
    for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
        SanPham sanPham = sanPhamRepository.findById(chiTietSanPham.getSanPham().getId())
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        MauSac mauSac = mauSacRepository.findById(chiTietSanPham.getMauSac().getId())
                .orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại"));
        KichCo kichCo = kichCoRepository.findById(chiTietSanPham.getKichCo().getId())
                .orElseThrow(() -> new RuntimeException("Kích cỡ không tồn tại"));
        
        chiTietSanPham.setTrangThai(1);
        chiTietSanPham.setNgayTao(LocalDateTime.now());
        
        // Tạo tên chi tiết sản phẩm theo định dạng yêu cầu
        chiTietSanPham.setTenChiTietSanPham(sanPham.getTenSanPham() + ", Màu " + mauSac.getTenMauSac() + ", Size " + kichCo.getSoKichCo());
        
        // Lưu chi tiết sản phẩm
        savedChiTietSanPhams.add(chiTietSanPhamRepository.save(chiTietSanPham));
    }
    
    return savedChiTietSanPhams;
}


    public ChiTietSanPham update(long id, ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham chiTietSanPhamUpdate = chiTietSanPhamRepository.findById(id).orElseThrow();
        // Cập nhật các trường
        return chiTietSanPhamRepository.save(chiTietSanPhamUpdate);
    }

    public void delete(long id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElseThrow();
        chiTietSanPham.setTrangThai(0);
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public List<Object[]> getTongSLSP() {
        return chiTietSanPhamRepository.getTongSLSP();
    }

    public List<ChiTietSanPham> getCTSPByID(long id) {
        return chiTietSanPhamRepository.getCTSPByID(id);
    }
}
