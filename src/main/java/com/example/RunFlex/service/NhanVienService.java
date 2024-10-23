/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.repository.NhanVienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NhanVienService {
   @Autowired 
    private NhanVienRepository nhanvienRepository;
   
   public List<NhanVien> getAll(){
       return nhanvienRepository.getAll();
   }
   
   public List<NhanVien> getNhanVienHoatDong(){
       return nhanvienRepository.getNhanVienHoatDong();
   }
   
   public List<NhanVien> getNhanVienNghiViec(){
       return nhanvienRepository.getNhanVienNghiViec();
   }
   
   public List<NhanVien> getQuanLy(){
       return nhanvienRepository.getQuanLy();
   }
   
   public List<NhanVien> getNhanVien(){
       return nhanvienRepository.getNhanVien();
   }
   
   public NhanVien add(NhanVien nhanVien){
       nhanVien.setTrangThai(1);
       return nhanvienRepository.save(nhanVien);
   }
   
   public NhanVien update(Long id,NhanVien nhanVien){
       NhanVien nhanVienUpdate = nhanvienRepository.findById(id).orElseThrow();
       
       nhanVienUpdate.setMaNhanVien(nhanVien.getMaNhanVien());
       nhanVienUpdate.setTenNhanVien(nhanVien.getTenNhanVien());
       nhanVienUpdate.setMatKhau(nhanVien.getMatKhau());
       nhanVienUpdate.setTenTaiKhoan(nhanVien.getTenTaiKhoan());
       nhanVienUpdate.setCccd(nhanVien.getCccd());
       nhanVienUpdate.setEmail(nhanVien.getEmail());
       nhanVienUpdate.setSoDienThoai(nhanVien.getSoDienThoai());
       nhanVienUpdate.setDiaChi(nhanVien.getDiaChi());
       nhanVienUpdate.setNgaySinh(nhanVien.getNgaySinh());
       nhanVienUpdate.setNgayTuyenDung(nhanVien.getNgayTuyenDung());
       nhanVienUpdate.setNgayNghiViec(nhanVien.getNgayNghiViec());
       nhanVienUpdate.setVaiTro(nhanVien.getVaiTro());
       return nhanvienRepository.save(nhanVienUpdate);
   }
   
   public void delete(Long id){
       NhanVien nhanVienUpdate = nhanvienRepository.findById(id).orElseThrow();
       nhanVienUpdate.setTrangThai(0);
       nhanvienRepository.save(nhanVienUpdate);
   }
}
