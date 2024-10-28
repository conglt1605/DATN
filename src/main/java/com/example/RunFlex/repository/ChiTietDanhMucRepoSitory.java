/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.ChiTietDanhMuc;
import com.example.RunFlex.model.ChiTietGioHang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ChiTietDanhMucRepoSitory extends JpaRepository<ChiTietDanhMuc, Long> {

    @Query(value = "SELECT ctdm.* \n"
            + "FROM ChiTietDanhMuc ctdm\n"
            + "JOIN ChiTietSanPham ctsp ON ctdm.ID_ChiTietSanPham = ctsp.ID\n"
            + "JOIN DanhMuc dm ON ctdm.ID_DanhMuc = dm.ID\n"
            + "WHERE ctdm.TrangThai = 1;", nativeQuery = true)
    List<ChiTietDanhMuc> getAll();
}
