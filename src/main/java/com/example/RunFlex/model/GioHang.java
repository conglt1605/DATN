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
import jakarta.persistence.OneToOne;

/**
 *
 * @author Cong
 */
@Entity
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int trangThai;
    
    @OneToOne
    @JoinColumn(name = "ID_KhachHang")
    private KhachHang khachHang;

    public GioHang() {
    }

    public GioHang(long id, int trangThai, KhachHang khachHang) {
        this.id = id;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    
}
