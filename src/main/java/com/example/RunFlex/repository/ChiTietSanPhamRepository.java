/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.ChiTietSanPham;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, Long> {
    @Query(value = "select * from ChiTietSanPham where trangthai=1", nativeQuery = true)
    List<ChiTietSanPham> getAll();

    //Tổng số lượng ctsp theo id sản phẩm
    @Query(value = "SELECT ID_SanPham,SUM(SoLuong) AS TongSoLuong FROM [ChiTietSanPham] GROUP BY ID_SanPham", nativeQuery = true)
    List<Object[]> getTongSLSP();
    
    //Lấy ds ctsp theo id sanpham 
    @Query(value = "SELECT * FROM chitietsanpham WHERE ID_SanPham = :id", nativeQuery = true)
    List<ChiTietSanPham> getCTSPByID(@Param("id") Long id);
    
    //Lấy (giá thấp nhất) - (Giá cao nhất) trong ctsp theo id sản phẩm
        @Query(value = "SELECT MIN(ctsp.giaBan) AS giaThapNhat, MAX(ctsp.giaBan) AS giaCaoNhat " +
                   "FROM ChiTietSanPham ctsp " +
                   "WHERE ctsp.ID_SanPham = :sanPhamId",nativeQuery = true)
    List<Object[]> findMinMaxPriceBySanPhamId(Long sanPhamId);
}

