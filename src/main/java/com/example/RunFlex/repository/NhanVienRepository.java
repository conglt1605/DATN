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
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
        @Query(value = "Select * From NhanVien where TrangThai = 1",nativeQuery = true)
    List<NhanVien> getAll();
}
