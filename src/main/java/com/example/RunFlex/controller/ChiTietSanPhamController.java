/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.service.ChiTietSanPhamService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/chitietsanpham")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping()
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamService.getAll();
    }

    @PostMapping
    public List<ChiTietSanPham> add(@RequestBody List<ChiTietSanPham> chiTietSanPhams) {
        return chiTietSanPhamService.add(chiTietSanPhams);
    }

    @PutMapping("/{id}")
    public ChiTietSanPham update(@RequestBody ChiTietSanPham chiTietSanPham, @PathVariable Long id) {
        return chiTietSanPhamService.update(id, chiTietSanPham);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietSanPhamService.delete(id);
    }

    @GetMapping("/slsp")
    public List<Object[]> getTongSLSP() {
        List<Object[]> tong = chiTietSanPhamService.getTongSLSP();
        return tong;
    }

    @GetMapping("/{id}")
    public List<ChiTietSanPham> getCTSPByID(@PathVariable Long id) {
        return chiTietSanPhamService.getCTSPByID(id);
    }
    
    //Lấy (giá thấp nhất) - (Giá cao nhất) trong ctsp theo id sản phẩm
    @GetMapping("/{sanPhamId}/giaMinMax")
    public ResponseEntity<Map<String, String>> getPriceRange(@PathVariable Long sanPhamId) {
        try {
            Map<String, String> priceRange = chiTietSanPhamService.getPriceRangeBySanPhamId(sanPhamId);
            return ResponseEntity.ok(priceRange);
        } catch (ArrayIndexOutOfBoundsException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("minPrice", "0");
            errorResponse.put("maxPrice", "0");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
