/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.ProductDetail;
import com.example.Runflex.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/productdetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return productDetailService.getAll();
    }
    @GetMapping("/active")
    public ResponseEntity<?> getProductDetailWithStatusActive() {
        return productDetailService.getProductDetailWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody List<ProductDetail> productDetails) {
        return productDetailService.saveProductDetails(productDetails);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody List<ProductDetail> productDetails) {
        return productDetailService.updateProductDetails(productDetails);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody List<Long> ids) {
        return productDetailService.deleteProductDetails(ids);
    }
}
