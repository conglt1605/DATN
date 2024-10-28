/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.model.ThuocTinh;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ThuocTinhRepository extends JpaRepository<ThuocTinh, Long>{
    
    @Query(value = "Select * From ThuocTinh where TrangThai = 1", nativeQuery = true)
    List<ThuocTinh> getAll();
}
