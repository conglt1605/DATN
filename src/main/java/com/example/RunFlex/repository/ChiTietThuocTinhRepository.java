/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.model.ChiTietThuocTinh;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ChiTietThuocTinhRepository extends JpaRepository<ChiTietThuocTinh, Long>{
            @Query(value = "select cttt.id,ID_ThuocTinh,Loai,cttt.TrangThai from ChiTietThuocTinh cttt join ThuocTinh tt on cttt.ID_ThuocTinh=tt.id where cttt.trangthai=1", nativeQuery = true)
    List<ChiTietThuocTinh> getAll();
}
