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
public class DeGiay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String tenDeGiay;
    public int trangThai;

    public DeGiay() {
    }

    public DeGiay(long id, String tenDeGiay, int trangThai) {
        this.id = id;
        this.tenDeGiay = tenDeGiay;
        this.trangThai = trangThai;
    }

    public long getId() {
        return id;
    }

    public String getTenDeGiay() {
        return tenDeGiay;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTenDeGiay(String tenDeGiay) {
        this.tenDeGiay = tenDeGiay;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
