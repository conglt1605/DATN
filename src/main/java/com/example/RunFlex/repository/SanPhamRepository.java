/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.SanPham;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>{
    @Query(value = "Select sp.* From SanPham sp join ThuongHieu th on sp.ID_ThuongHieu=th.id where sp.TrangThai = 1",nativeQuery = true)
    List<SanPham> getAll();
}
