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
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int soLuong;
    public int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "ID_HoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ID_ChiTietSanPham")
    private ChiTietSanPham chiTietSanPham;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(long id, int soLuong, int trangThai, HoaDon hoaDon, ChiTietSanPham chiTietSanPham) {
        this.id = id;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.hoaDon = hoaDon;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }
    
}
