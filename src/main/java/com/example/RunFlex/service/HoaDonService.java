/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.HoaDon;
import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.repository.HoaDonRepository;
import com.example.RunFlex.repository.NhanVienRepository;
import java.util.Date;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class HoaDonService {
     @Autowired 
    private HoaDonRepository hoaDonRepository;
   
   public List<HoaDon> getAll(){
       return hoaDonRepository.getAll();
   }
   
   public List<Map<String,Object>> getDoanhThu(){
       return hoaDonRepository.getDoanhThu();
   }
   
   public HoaDon taoHoaDonTrong(){
       HoaDon hoaDonTrong = new HoaDon();
       hoaDonTrong.setHinhThucMuaHang(1);
       hoaDonTrong.setTrangThai(1);
       hoaDonTrong.setNgayTao(new Date());
       return hoaDonRepository.save(hoaDonTrong);
   }
   
   public HoaDon updateHoaDon(Long id, HoaDon hd) {
    HoaDon existingHoaDon = hoaDonRepository.findById(id).orElseThrow();

    // Cập nhật các thuộc tính của thực thể
    existingHoaDon.setVoucher(hd.getVoucher());
    existingHoaDon.setPhuongThucThanhToan(hd.getPhuongThucThanhToan());
    existingHoaDon.setHinhThucMuaHang(hd.getHinhThucMuaHang());
    existingHoaDon.setPhiShip(hd.getPhiShip());
    existingHoaDon.setNgayHoanTra(hd.getNgayHoanTra());
    existingHoaDon.setNgayGiaoHang(hd.getNgayGiaoHang());
    existingHoaDon.setDiaChiGiaoHang(hd.getDiaChiGiaoHang());
    existingHoaDon.setTongSoTien(hd.getTongSoTien());
    existingHoaDon.setMoTa(hd.getMoTa());
    existingHoaDon.setTrangThai(hd.getTrangThai());
    
    return hoaDonRepository.save(existingHoaDon);
   }
}
