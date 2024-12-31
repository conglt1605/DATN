/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.dto.ProductFilterDto;
import com.example.Runflex.entity.Category;
import com.example.Runflex.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Cong
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCT WHERE STATUS = 1", nativeQuery = true)
    List<Product> getProductWithStatusActive();

    @Query("SELECT new com.example.Runflex.dto.ProductDto("
            + "p.id, "
            + "p.productCode, "
            + "p.productName, "
            + "c.categoryName, "
            + "b.brandName, "
            + "ub.usageObjectName, "
            + "p.imageURL, "
            + "p.status) "
            + "FROM Product p "
            + "JOIN p.category c "
            + "JOIN p.brand b "
            + "JOIN p.usageObject ub WHERE p.status = 1")
    Page<ProductDto> getPageProducts(Pageable pageable);

    @Query("SELECT new com.example.Runflex.dto.ProductFilterDto(p.id, p.productCode, p.productName, c.categoryName,ub.usageObjectName,b.brandName,p.imageURL,p.imageURL2, p.status) FROM Product p "
            + "JOIN p.productDetails pd "
            + "JOIN p.category c "
            + "JOIN p.brand b "
            + "JOIN p.usageObject ub "
            + "WHERE (:categoryIds IS NULL OR p.category.id IN :categoryIds) "
            + "AND (:brandIds IS NULL OR p.brand.id IN :brandIds) "
            + "AND (:usageObjectIds IS NULL OR p.usageObject.id IN :usageObjectIds) "
            + "AND (:sizeIds IS NULL OR pd.size.id IN :sizeIds) "
            + "AND (:colorIds IS NULL OR pd.color.id IN :colorIds) "
            + "AND (:materialIds IS NULL OR pd.material.id IN :materialIds) "
            + "AND (:productName IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :productName, '%'))) "
            + "AND p.status = 1 "
            + "GROUP BY p.ID")
    Page<ProductFilterDto> filterProducts(
            Pageable pageable,
            @Param("categoryIds") List<Long> categoryIds,
            @Param("brandIds") List<Long> brandIds,
            @Param("usageObjectIds") List<Long> usageObjectIds,
            @Param("sizeIds") List<Long> sizeIds,
            @Param("colorIds") List<Long> colorIds,
            @Param("materialIds") List<Long> materialIds,
            @Param("productName") String productName);
}
