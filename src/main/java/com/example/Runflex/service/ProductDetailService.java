/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.dto.ColorDto;
import com.example.Runflex.dto.MaterialDto;
import com.example.Runflex.dto.ProductDetailDto;
import com.example.Runflex.dto.SizeDto;
import com.example.Runflex.entity.ProductDetail;
import com.example.Runflex.repository.ProductDetailRepository;
import com.example.Runflex.service.impl.IProductDetailService;
import com.example.Runflex.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Cong
 */
@Service
public class ProductDetailService implements IProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<ProductDetail> productDetails = productDetailRepository.findAll();
        if (productDetails == null || productDetails.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sách Trống"));
        }
        return ResponseEntity.ok(Map.of("Success", productDetails));
    }

    @Override
    public ResponseEntity<?> saveProductDetails(List<ProductDetail> productDetails) {
        if (productDetails.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sách Sản Phẩm Chi Tiết Trống"));
        }
        for (ProductDetail productDetail : productDetails) {
            if (productDetail.getProductDetailName() == null || productDetail.getProductDetailName().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Tên Sản Phẩm Chi Tiết Không Được Để Trống"));
            }
            productDetail.setStatus(Status.active);
        }
        productDetailRepository.saveAll(productDetails);
        return ResponseEntity.ok(Map.of("Success", "Thêm Thành Công"));
    }

    @Override
    public ResponseEntity<?> updateProductDetails(List<ProductDetail> productDetails) {
        if (productDetails.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sách Sản Phẩm Chi Tiết Trống"));
        }
        for (ProductDetail productDetail : productDetails) {
            if (productDetail.getId() == 0) {
                return ResponseEntity.badRequest().body(Map.of("error", "ID Sản Phẩm Chi Tiết Không Hợp Lệ"));
            }
            ProductDetail existingProductDetail = productDetailRepository.findById(productDetail.getId()).orElseThrow();
            existingProductDetail.setProductDetailName(productDetail.getProductDetailName());
            existingProductDetail.setProductDetailCode(productDetail.getProductDetailCode());
            existingProductDetail.setImageURL(productDetail.getImageURL());
            existingProductDetail.setPrice(productDetail.getPrice());
            existingProductDetail.setQuantity(productDetail.getQuantity());
            existingProductDetail.setDescription(productDetail.getDescription());
            existingProductDetail.setStatus(productDetail.getStatus());
            existingProductDetail.setProduct(productDetail.getProduct());
            existingProductDetail.setSize(productDetail.getSize());
            existingProductDetail.setColor(productDetail.getColor());
            existingProductDetail.setMaterial(productDetail.getMaterial());
            productDetailRepository.save(existingProductDetail);
        }
        return ResponseEntity.ok(Map.of("Success", "Cập Nhật Thành Công"));
    }

    @Override
    public ResponseEntity<?> deleteProductDetails(List<Long> ids) {
        if (ids.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sách ID Sản Phẩm Chi Tiết Trống"));
        }
        for (Long id : ids) {
            ProductDetail productDetail = productDetailRepository.findById(id).orElseThrow();
            productDetail.setStatus(Status.delete);
            productDetailRepository.save(productDetail);
        }
        return ResponseEntity.ok(Map.of("Success", "Xóa Thành Công"));
    }

    @Override
    public ResponseEntity<?> getProductDetailWithStatusActive() {
        List<ProductDetail> productDetails = productDetailRepository.getProductDetailWithStatusActive();
        if (productDetails.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", productDetails));
    }

    @Override
    public ResponseEntity<?> getProductDetail(Long sizeId, Long productId, Long colorId, Long materialId) {

        ProductDetailDto productDetailDto = productDetailRepository.getProductDetail(sizeId, productId, colorId, materialId);
        if(productDetailDto == null){
            return ResponseEntity.badRequest().body(Map.of("error", "Loi khi lay productDetail"));
        }
        return ResponseEntity.ok(Map.of("Success", productDetailDto));
    }

    @Override
    public ResponseEntity<?> GetColorByProductID(Long productID) {
        List<Map<String, Object>> colors = productDetailRepository.GetColorByProductID(productID);
        if (colors.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Loi khi lay productDetail"));
        }
        return ResponseEntity.ok(Map.of("Success", colors));
    }

    @Override
    public ResponseEntity<?> GetSizeByProductID(Long productID) {
        List<Map<String, Object>> sizes = productDetailRepository.GetSizeByProductID(productID);
        if (sizes == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Loi khi lay productDetail"));
        }
        return ResponseEntity.ok(Map.of("Success", sizes));
    }

    @Override
    public ResponseEntity<?> GetMaterialByProductID(Long productID) {
        List<Map<String, Object>> materials = productDetailRepository.GetMaterialByProductID(productID);
        if (materials == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Loi khi lay productDetail"));
        }
        return ResponseEntity.ok(Map.of("Success", materials));
    }
}
