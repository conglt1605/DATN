/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Cong
 */
@Entity
public class ThuocTinhSanPham {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "ID_ChiTietSanPham")
    private ChiTietSanPham chiTietSanPham;
    
    @ManyToOne
    @JoinColumn(name = "ID_ChiTietThuocTinh")
    private ChiTietThuocTinh chiTietThuocTinh;

    public ThuocTinhSanPham() {
    }

    public ThuocTinhSanPham(long id, int trangThai, ChiTietSanPham chiTietSanPham, ChiTietThuocTinh chiTietThuocTinh) {
        this.id = id;
        this.trangThai = trangThai;
        this.chiTietSanPham = chiTietSanPham;
        this.chiTietThuocTinh = chiTietThuocTinh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public ChiTietThuocTinh getChiTietThuocTinh() {
        return chiTietThuocTinh;
    }

    public void setChiTietThuocTinh(ChiTietThuocTinh chiTietThuocTinh) {
        this.chiTietThuocTinh = chiTietThuocTinh;
    }
    
    
    
}
