/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.KhachHang;
import com.example.RunFlex.model.KichCo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    @Query(value = "select * from KhachHang where trangthai=1", nativeQuery = true)
    List<KhachHang> getAll();
}