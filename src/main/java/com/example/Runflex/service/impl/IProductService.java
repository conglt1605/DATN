/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.dto.ProductFilterDto;
import com.example.Runflex.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cong
 */
public interface IProductService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getProductWithStatusActive();
    ResponseEntity<?> saveProduct(Product product);
    ResponseEntity<?> updateProduct(Long id, Product product);
    ResponseEntity<?> deleteProduct(Long id);
    Page<ProductFilterDto> filterProducts(
            Pageable pageable,
            List<Long> categoryIds, 
            List<Long> brandIds, 
            List<Long> usageObjectIds, 
            List<Long> sizeIds, 
            List<Long> colorIds, 
            List<Long> materialIds, 
            String productName);
    Page<ProductDto> getPageProducts(Pageable pageable); 
}

