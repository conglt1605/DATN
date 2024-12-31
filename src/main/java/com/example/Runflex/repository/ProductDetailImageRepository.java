/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.Brand;
import com.example.Runflex.entity.ProductDetailImage;
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
public interface ProductDetailImageRepository extends JpaRepository<ProductDetailImage, Long>{
    @Query(value = "SELECT * FROM PRODUCTDETAILIMAGE WHERE STATUS = 1",nativeQuery = true)
    List<Map<Object,String>> getProductDetailImageWithStatusActive();    
    @Query(value = "SELECT * FROM PRODUCTDETAILIMAGE",nativeQuery = true)
    List<Map<Object,String>> getAll();    
    @Query(value = "SELECT * FROM PRODUCTDETAILIMAGE WHERE ProductDetailID = :id",nativeQuery = true)
    List<Map<Object,String>> getImageWithProductDetailId(@Param("id") long id);    
}
