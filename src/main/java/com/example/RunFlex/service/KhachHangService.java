/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.KhachHang;
import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.repository.KhachHangRepository;
import com.example.RunFlex.repository.NhanVienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class KhachHangService {
       @Autowired 
    private KhachHangRepository khachHangRepository;
   
   public List<KhachHang> getAll(){
       return khachHangRepository.getAll();
   }
   
   public KhachHang add(KhachHang khachHang){
       khachHang.setTrangThai(1);
       return khachHangRepository.save(khachHang);
   }
   
   public KhachHang update(Long id,KhachHang khachHang){
       KhachHang khachHangUpdate = khachHangRepository.findById(id).orElseThrow();
       
       khachHangUpdate.setMaKhachHang(khachHang.getMaKhachHang());
       khachHangUpdate.setTenKhachHang(khachHang.getTenKhachHang());
       khachHangUpdate.setMatKhau(khachHang.getMatKhau());
       khachHangUpdate.setTenTaiKhoan(khachHang.getTenTaiKhoan());
       khachHangUpdate.setEmail(khachHang.getEmail());
       khachHangUpdate.setSoDienThoai(khachHang.getSoDienThoai());
       khachHangUpdate.setDiaChi(khachHang.getDiaChi());
       khachHangUpdate.setNgaySinh(khachHang.getNgaySinh());
       khachHangUpdate.setNgayTao(khachHang.getNgayTao());
       return khachHangRepository.save(khachHangUpdate);
   }
   
   public void delete(Long id){
       KhachHang khachHangUpdate = khachHangRepository.findById(id).orElseThrow();
       khachHangUpdate.setTrangThai(0);
       khachHangRepository.save(khachHangUpdate);
   }
}
