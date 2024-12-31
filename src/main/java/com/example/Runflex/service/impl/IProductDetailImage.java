/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Brand;
import com.example.Runflex.entity.ProductDetailImage;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cong
 */
public interface IProductDetailImage {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getProductDetailImageWithStatusActive();
    
    ResponseEntity<?> getImageWithProductDetailId(long id);

    ResponseEntity<?> saveProductDetailImage(ProductDetailImage productDetailImage);

    ResponseEntity<?> updateProductDetailImage(Long id, ProductDetailImage productDetailImage);

    ResponseEntity<?> deleteProductDetailImage(Long id);
}
