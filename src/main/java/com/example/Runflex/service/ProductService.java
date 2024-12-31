/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.dto.ProductFilterDto;
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
        existingProduct.setImageURL2(product.getImageURL2());
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

    public Page<ProductFilterDto> filterProducts(
            Pageable pageable,
            List<Long> categoryIds,
            List<Long> brandIds,
            List<Long> usageObjectIds,
            List<Long> sizeIds,
            List<Long> colorIds,
            List<Long> materialIds,
            String productName) {

        // Xử lý giá trị null hoặc rỗng thành null để phù hợp với câu query
        categoryIds = (categoryIds == null || categoryIds.isEmpty()) ? null : categoryIds;
        brandIds = (brandIds == null || brandIds.isEmpty()) ? null : brandIds;
        usageObjectIds = (usageObjectIds == null || usageObjectIds.isEmpty()) ? null : usageObjectIds;
        sizeIds = (sizeIds == null || sizeIds.isEmpty()) ? null : sizeIds;
        colorIds = (colorIds == null || colorIds.isEmpty()) ? null : colorIds;
        materialIds = (materialIds == null || materialIds.isEmpty()) ? null : materialIds;
        productName = (productName == null || productName.isBlank()) ? null : productName;
           
        return productRepository.filterProducts(pageable,categoryIds, brandIds, usageObjectIds, sizeIds, colorIds, materialIds, productName);

    }


}
