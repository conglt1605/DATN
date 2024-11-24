/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.ProductDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *
 * @author Cong
 */
public interface IProductDetailService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> saveProductDetails(List<ProductDetail> productDetails);
    ResponseEntity<?> updateProductDetails(List<ProductDetail> productDetails);
    ResponseEntity<?> deleteProductDetails(List<Long> ids);
    ResponseEntity<?> getProductDetailWithStatusActive();
    
}

