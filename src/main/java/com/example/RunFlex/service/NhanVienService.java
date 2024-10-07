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
       return nhanvienRepository.findAll();
   }
   
   public NhanVien add(NhanVien nhanVien){
       return nhanvienRepository.save(nhanVien);
   }
   
   public NhanVien update(Long id,NhanVien nhanVien){
       NhanVien nhanVienUpdate = nhanvienRepository.findById(id).orElseThrow();
       
       nhanVienUpdate.setMaNhanVien(nhanVien.getMaNhanVien());
       nhanVienUpdate.setTenNhanVien(nhanVien.getTenNhanVien());
       nhanVienUpdate.setMatKhau(nhanVien.getMatKhau());
       nhanVienUpdate.setTenTaiKhoan(nhanVien.getTenTaiKhoan());
       nhanVienUpdate.setEmail(nhanVien.getEmail());
       nhanVienUpdate.setSoDienThoai(nhanVien.getSoDienThoai());
       nhanVienUpdate.setDiaChi(nhanVien.getDiaChi());
       nhanVienUpdate.setNgaySinh(nhanVien.getNgaySinh());
       nhanVienUpdate.setNgayTuyenDung(nhanVien.getNgayTuyenDung());
       nhanVienUpdate.setNgayNghiViec(nhanVien.getNgayNghiViec());
       nhanVienUpdate.setTrangThai(nhanVien.getTrangThai());
       return nhanvienRepository.save(nhanVienUpdate);
   }
   
   public void delete(Long id){
       nhanvienRepository.deleteById(id);
   }
}
