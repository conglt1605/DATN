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
 * @author Cong
 */
@Entity
public class KichCo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int soKichCo;
    public int trangThai;

    public KichCo() {
    }

    public KichCo(long id, int soKichCo, int trangThai) {
        this.id = id;
        this.soKichCo = soKichCo;
        this.trangThai = trangThai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSoKichCo() {
        return soKichCo;
    }

    public void setSoKichCo(int soKichCo) {
        this.soKichCo = soKichCo;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
