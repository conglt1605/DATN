/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

}
