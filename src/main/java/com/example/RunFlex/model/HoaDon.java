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
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int phuongThucThanhToan;
    private int hinhThucMuaHang;
    private Long phiShip;
    private Date ngayTao;
    private Date ngayHoanTra;
    private Date ngayGiaoHang;
    private String diaChiGiaoHang;
    private int tongSoTien;
    private String moTa;
    private int trangThai;
    @ManyToOne
    @JoinColumn(name = "ID_NhanVien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "ID_KhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "ID_Voucher")
    private Voucher voucher;

    public HoaDon() {
    }

    public HoaDon(Long id, int phuongThucThanhToan, int hinhThucMuaHang, long phiShip, Date ngayTao, Date ngayHoanTra, Date ngayGiaoHang, String diaChiGiaoHang, int tongSoTien, String moTa, int trangThai, NhanVien nhanVien, KhachHang khachHang, Voucher voucher) {
        this.id = id;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.hinhThucMuaHang = hinhThucMuaHang;
        this.phiShip = phiShip;
        this.ngayTao = ngayTao;
        this.ngayHoanTra = ngayHoanTra;
        this.ngayGiaoHang = ngayGiaoHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.tongSoTien = tongSoTien;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.voucher = voucher;
    }

    public int getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public int getHinhThucMuaHang() {
        return hinhThucMuaHang;
    }

    public void setHinhThucMuaHang(int hinhThucMuaHang) {
        this.hinhThucMuaHang = hinhThucMuaHang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(Long phiShip) {
        this.phiShip = phiShip;
    }

   
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHoanTra() {
        return ngayHoanTra;
    }

    public void setNgayHoanTra(Date ngayHoanTra) {
        this.ngayHoanTra = ngayHoanTra;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public int getTongSoTien() {
        return tongSoTien;
    }

    public void setTongSoTien(int tongSoTien) {
        this.tongSoTien = tongSoTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

}
