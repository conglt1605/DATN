/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Brand;
import com.example.Runflex.entity.ProductDetailImage;
import com.example.Runflex.repository.ProductDetailImageRepository;
import com.example.Runflex.repository.ProductDetailRepository;
import com.example.Runflex.service.impl.IProductDetailImage;
import com.example.Runflex.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ProductDetailImageService implements IProductDetailImage{
    @Autowired
    private ProductDetailImageRepository productDetailImageRepository;
    

    @Override
    public ResponseEntity<?> getAll() {
        List<Map<Object,String>> productDetailImages = productDetailImageRepository.getAll();
        if (productDetailImages.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Succes", productDetailImages));
    }

    @Override
    public ResponseEntity<?> getProductDetailImageWithStatusActive() {
        List<Map<Object,String>> productDetailImages = productDetailImageRepository.getProductDetailImageWithStatusActive();
        if (productDetailImages.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", productDetailImages));
    }

    @Override
    public ResponseEntity<?> saveProductDetailImage(ProductDetailImage productDetailImages) {
        if (productDetailImages.getProductDetail() == null || productDetailImages.getImageURL() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không được để trống"));
        }
        productDetailImages.setStatus(Status.active);
        productDetailImageRepository.save(productDetailImages);
        return ResponseEntity.ok(Map.of("Succes", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> updateProductDetailImage(Long id, ProductDetailImage productDetailImage) {
        ProductDetailImage existingProductDetailImage = productDetailImageRepository.findById(id).orElseThrow();
        if (existingProductDetailImage == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        existingProductDetailImage.setImageURL(productDetailImage.getImageURL());
        existingProductDetailImage.setProductDetail(productDetailImage.getProductDetail());
        productDetailImageRepository.save(existingProductDetailImage);
        return ResponseEntity.ok(Map.of("Succes","Sua Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> deleteProductDetailImage(Long id) {
        ProductDetailImage productDetailImage = productDetailImageRepository.findById(id).orElseThrow();
        if (productDetailImage == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        productDetailImage.setStatus(Status.delete);
        productDetailImageRepository.save(productDetailImage);
        return ResponseEntity.ok(Map.of("Succes", "Xoa Thanh Cong"));
    } 

    @Override
    public ResponseEntity<?> getImageWithProductDetailId(long id) {
        List<Map<Object,String>> images = productDetailImageRepository.getImageWithProductDetailId(id);
        if (images.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", images));
    }
}
