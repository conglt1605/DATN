/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

/**
 *
 * @author admin
 */
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maNhanVien;
    private String tenNhanVien;
    private String matKhau;
    private String tenTaiKhoan;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private Date ngaySinh;  
    private Date ngayTuyenDung;
    private Date ngayNghiViec;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(Long id, String maNhanVien, String tenNhanVien, String matKhau, String tenTaiKhoan, String email, String soDienThoai, String diaChi, Date ngaySinh, Date ngayTuyenDung, Date ngayNghiViec, int trangThai) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.matKhau = matKhau;
        this.tenTaiKhoan = tenTaiKhoan;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayTuyenDung = ngayTuyenDung;
        this.ngayNghiViec = ngayNghiViec;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }






    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTuyenDung() {
        return ngayTuyenDung;
    }

    public void setNgayTuyenDung(Date ngayTuyenDung) {
        this.ngayTuyenDung = ngayTuyenDung;
    }

    public Date getNgayNghiViec() {
        return ngayNghiViec;
    }

    public void setNgayNghiViec(Date ngayNghiViec) {
        this.ngayNghiViec = ngayNghiViec;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    


    
    
    
}
