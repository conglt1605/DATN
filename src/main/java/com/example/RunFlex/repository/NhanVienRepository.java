/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.NhanVien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    //Hiển thị tất cả các nhân viên
    @Query(value = "Select * From NhanVien where TrangThai = 1 or TrangThai = 2", nativeQuery = true)
    List<NhanVien> getAll();
    
    //Hiển thị nhân viên đang hoạt động
    @Query(value = "Select * From NhanVien where TrangThai = 1", nativeQuery = true)
    List<NhanVien> getNhanVienHoatDong();
    
    //Hiển thị nhân viên đã nghỉ việc
    @Query(value = "Select * From NhanVien where TrangThai = 2", nativeQuery = true)
    List<NhanVien> getNhanVienNghiViec();
    
    //Hiển thị quản lý
    @Query(value = "Select * From NhanVien where vaitro = 0", nativeQuery = true)
    List<NhanVien> getQuanLy();
    
    //Hiển thị quản lý
    @Query(value = "Select * From NhanVien where vaitro = 1", nativeQuery = true)
    List<NhanVien> getNhanVien();
}
