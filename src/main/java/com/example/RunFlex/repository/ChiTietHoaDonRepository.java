/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.ChiTietHoaDon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Long>{
    @Query(value = "select * from ChiTietHoaDon where trangthai=1", nativeQuery = true)
    List<ChiTietHoaDon> getAll();
    
    @Query(value = "select * from ChiTietHoaDon where ID_HoaDon = :id and trangthai=1",nativeQuery = true)
    List<ChiTietHoaDon> getChiTietHoaDonById(@Param("id") Long id);
}
