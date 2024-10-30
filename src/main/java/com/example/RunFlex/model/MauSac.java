/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Admin
 */
@Entity
public class MauSac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String tenMauSac;
    public int trangThai;

    public MauSac() {
    }

    public MauSac(long id, String tenMauSac, int trangThai) {
        this.id = id;
        this.tenMauSac = tenMauSac;
        this.trangThai = trangThai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}