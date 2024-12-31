/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.Brand;
import com.example.Runflex.entity.ProductDetailImage;
import com.example.Runflex.service.ProductDetailImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/ProductDetailImage")
public class ProductDetailImageController {
    @Autowired
    private ProductDetailImageService productDetailImageService;
    
        @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return productDetailImageService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getProductDetailImageWithStatusActive() {
        return productDetailImageService.getProductDetailImageWithStatusActive();
    }
    
    @GetMapping("/imageWithID")
    public ResponseEntity<?> getImageWithProductDetailId(@Param("id") long id) {
        return productDetailImageService.getImageWithProductDetailId(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductDetailImage productDetailImage) {
        return productDetailImageService.saveProductDetailImage(productDetailImage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDetailImage productDetailImage) {
        return productDetailImageService.updateProductDetailImage(id, productDetailImage);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return productDetailImageService.deleteProductDetailImage(id);
    }
}
