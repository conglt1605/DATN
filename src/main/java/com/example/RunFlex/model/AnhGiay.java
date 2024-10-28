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

/**
 *
 * @author Cong
 */
@Entity
public class AnhGiay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String tenURL;
    public int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "ID_ChiTietSanPham")
    private ChiTietSanPham chiTietSanPham;

    public AnhGiay() {
    }

    public AnhGiay(long id, String tenURL, int trangThai, ChiTietSanPham chiTietSanPham) {
        this.id = id;
        this.tenURL = tenURL;
        this.trangThai = trangThai;
        this.chiTietSanPham = chiTietSanPham;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenURL() {
        return tenURL;
    }

    public void setTenURL(String tenURL) {
        this.tenURL = tenURL;
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
    

}
