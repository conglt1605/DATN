/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.ThuocTinh;
import com.example.RunFlex.model.ThuocTinhSanPham;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ThuocTinhSanPhamRepository extends JpaRepository<ThuocTinhSanPham, Long>{
        @Query(value = "Select * From ThuocTinhSanPham where TrangThai = 1", nativeQuery = true)
    List<ThuocTinhSanPham> getAll();
}
