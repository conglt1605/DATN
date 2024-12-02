/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.entity.Product;
import com.example.Runflex.repository.ProductRepository;
import com.example.Runflex.service.impl.IProductService;
import com.example.Runflex.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Cong
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sách Trống"));
        }
        return ResponseEntity.ok(Map.of("Success", products));
    }

    @Override
    public ResponseEntity<?> getProductWithStatusActive() {
        List<Product> products = productRepository.getProductWithStatusActive();
        if (products.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Success", products));
    }

    @Override
    public ResponseEntity<?> saveProduct(Product product) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tên Sản Phẩm Không Được Để Trống"));
        }
        Long maxId = productRepository.findMaxId();

        if (maxId == null) {
            maxId = 1l;  // Nếu bảng trống thì bắt đầu từ 1
        } else {
            maxId++;
        }

        // Tạo mã chi tiết sản phẩm theo định dạng "MD" + 3 số
        String productCode = String.format("MD%03d", maxId);
       
        product.setProductCode(productCode);
        product.setStatus(Status.active);
        productRepository.save(product);
        return ResponseEntity.ok(Map.of("Success", "Thêm Thành Công"));
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        if (product == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không Tìm Thấy"));
        }
        product.setStatus(Status.delete);
        productRepository.save(product);
        return ResponseEntity.ok(Map.of("Success", "Xóa Thành Công"));
    }

    @Override
    public ResponseEntity<?> updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        if (existingProduct == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không Tìm Thấy"));
        }
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductCode(product.getProductCode());
        existingProduct.setImageURL(product.getImageURL());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setUsageObject(product.getUsageObject());
        productRepository.save(existingProduct);
        return ResponseEntity.ok(Map.of("Success", "Cập Nhật Thành Công"));
    }

    @Override
    public Page<ProductDto> getPageProducts(Pageable pageable) {
        return productRepository.getPageProducts(pageable);
    }
}
