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
public class ChiTietGioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int soLuong;
    public Date ngayTao;
    public int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "ID_GioHang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "ID_ChiTietSanPham")
    private ChiTietSanPham chiTietSanPham;

    public ChiTietGioHang() {
    }

    public ChiTietGioHang(long id, int soLuong, Date ngayTao, int trangThai, GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        this.id = id;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.gioHang = gioHang;
        this.chiTietSanPham = chiTietSanPham;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }
    
}
