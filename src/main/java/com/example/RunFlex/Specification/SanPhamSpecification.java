/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.Specification;

import com.example.RunFlex.model.SanPham;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Cong
 */
public class SanPhamSpecification {
        public static Specification<SanPham> hasDanhMuc(Long danhMucId) {
        return (root, query, cb) -> 
            danhMucId == null ? cb.conjunction() : cb.equal(root.get("danhMuc").get("id"), danhMucId);
    }

    public static Specification<SanPham> hasThuongHieu(Long thuongHieuId) {
        return (root, query, cb) -> 
            thuongHieuId == null ? cb.conjunction() : cb.equal(root.get("thuongHieu").get("id"), thuongHieuId);
    }

    public static Specification<SanPham> hasGioiTinh(Integer gioiTinh) {
        return (root, query, cb) -> 
            gioiTinh == null ? cb.conjunction() : cb.equal(root.get("gioiTinh"), gioiTinh);
    }
}
