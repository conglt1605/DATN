/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.repository.DanhMucRepository;
import com.example.RunFlex.repository.SanPhamRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cong
 */
@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private DanhMucRepository danhMucRepository;

    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    public SanPham add(SanPham sanPham) {
        sanPham.setTrangThai(1);
        return sanPhamRepository.save(sanPham);
    }

    public SanPham update(long id, SanPham sanPham) {
        SanPham sanPhamUpdate = sanPhamRepository.findById(id).orElseThrow();

        sanPhamUpdate.setThuongHieu(sanPham.getThuongHieu());
        sanPhamUpdate.setDanhMuc(sanPham.getDanhMuc());
        sanPhamUpdate.setTenSanPham(sanPham.getTenSanPham());
        sanPhamUpdate.setGioiTinh(sanPham.getGioiTinh());
        return sanPhamRepository.save(sanPhamUpdate);
    }

    public void delete(long id) {
        SanPham sanPhamUpdate = sanPhamRepository.findById(id).orElseThrow();
        
        sanPhamUpdate.setTrangThai(0);
        sanPhamRepository.save(sanPhamUpdate);
    }
    
        public List<SanPham> locSanPhamTheoDanhMuc(List<Long> danhMucIds) {
        // Lấy danh sách danh mục từ các id
        List<DanhMuc> danhMucs = danhMucRepository.findAllById(danhMucIds);
        // Tìm tất cả sản phẩm thuộc các danh mục
        return sanPhamRepository.findByDanhMucIn(danhMucs);
    }
}
