/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Product;
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
}

