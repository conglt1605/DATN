/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.dto.ProductDto;
import com.example.Runflex.dto.ProductFilterDto;
import com.example.Runflex.entity.Product;
import com.example.Runflex.service.ProductService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return productService.getAll();
    }
    
        @GetMapping("/active")
    public ResponseEntity<?> getProductWithStatusActive() {
        return productService.getProductWithStatusActive();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
    @GetMapping("/page")
    public ResponseEntity<?> page(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> productDtos = productService.getPageProducts(pageable);
        if(productDtos.isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("error","Danh sách Trống"));
        }
        return ResponseEntity.ok(Map.of("Success",productDtos));
    }
    
    @GetMapping("/filter")
    public ResponseEntity<?> filterProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) List<Long> categoryIds,
            @RequestParam(required = false) List<Long> brandIds,
            @RequestParam(required = false) List<Long> usageObjectIds,
            @RequestParam(required = false) List<Long> sizeIds,
            @RequestParam(required = false) List<Long> colorIds,
            @RequestParam(required = false) List<Long> materialIds,
            @RequestParam(required = false) String productName) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductFilterDto> productsFilterDto =  productService.filterProducts(pageable,categoryIds, brandIds, usageObjectIds, sizeIds, colorIds, materialIds, productName);
                if(productsFilterDto.isEmpty()){
            return ResponseEntity.ok(Map.of("error","Không tìm thấy sản phẩm","productsFilterDto",productsFilterDto));
        }
        return ResponseEntity.ok(Map.of("productsFilterDto",productsFilterDto));
    }
    
}

