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
public class ChiTietThuocTinh {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long  id;
        public String  loai;
        public int  trangThai;
        
        @ManyToOne
        @JoinColumn(name = "ID_ThuocTinh")
        private ThuocTinh thuocTinh;

    public ChiTietThuocTinh() {
    }

    public ChiTietThuocTinh(long id, String loai, int trangThai, ThuocTinh thuocTinh) {
        this.id = id;
        this.loai = loai;
        this.trangThai = trangThai;
        this.thuocTinh = thuocTinh;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ThuocTinh getThuocTinh() {
        return thuocTinh;
    }

    public void setThuocTinh(ThuocTinh thuocTinh) {
        this.thuocTinh = thuocTinh;
    }
        
}
