/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.HoaDon;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    @Query(value = "Select * from HoaDon", nativeQuery = true)
    List<HoaDon> getAll();

    @Query(value = "SELECT \n"
            + "YEAR(NgayTao) AS Nam, \n"
            + "MONTH(NgayTao) AS Thang,\n"
            + "SUM(CAST(TongSoTien AS NUMERIC(18,2))) AS TongTien \n"
            + "FROM HoaDon \n"
            + "GROUP BY YEAR(NgayTao), MONTH(NgayTao)\n "
            + "ORDER BY Nam, Thang;", nativeQuery = true)
    List<Map<String, Object>> getDoanhThu();
    
    
}
