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
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maSanPham;
    private int soLuong;
    private int giaBan;
    private int giaNhap;
    private String doiTuongSuDung;
    private String moTa;
    private Date ngayTao;
    private int trangThai;
    @ManyToOne
    @JoinColumn(name = "ID_SanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "ID_NhanVien")
    private NhanVien nhanVien;
    
    @ManyToOne
    @JoinColumn(name = "ID_MauSac")
    private MauSac mauSac;
    
    @ManyToOne
    @JoinColumn(name = "ID_ThuongHieu")
    private ThuongHieu thuongHieu;
    
    @ManyToOne
    @JoinColumn(name = "ID_DanhMuc")
    private DanhMuc danhMuc;
    
    @ManyToOne
    @JoinColumn(name = "ID_ChatLieu")
    private ChatLieu chatLieu;
    
    @ManyToOne
    @JoinColumn(name = "ID_DeGiay")
    private DeGiay deGiay;
    
    @ManyToOne
    @JoinColumn(name = "ID_KichCo")
    private KichCo kichCo;
    
    @ManyToOne
    @JoinColumn(name = "ID_XuatXu")
    private XuatXu xuatXu;
    
    @ManyToOne
    @JoinColumn(name = "ID_AnhGiay")
    private AnhGiay anhGiay;
    
    @ManyToOne
    @JoinColumn(name = "ID_KhuyenMai")
    private KhuyenMai khuyenMai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Long id, String maSanPham, int soLuong, int giaBan, int giaNhap, String doiTuongSuDung, String moTa, Date ngayTao, int trangThai, SanPham sanPham, NhanVien nhanVien, MauSac mauSac, ThuongHieu thuongHieu, DanhMuc danhMuc, ChatLieu chatLieu, DeGiay deGiay, KichCo kichCo, XuatXu xuatXu, AnhGiay anhGiay, KhuyenMai khuyenMai) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.doiTuongSuDung = doiTuongSuDung;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.sanPham = sanPham;
        this.nhanVien = nhanVien;
        this.mauSac = mauSac;
        this.thuongHieu = thuongHieu;
        this.danhMuc = danhMuc;
        this.chatLieu = chatLieu;
        this.deGiay = deGiay;
        this.kichCo = kichCo;
        this.xuatXu = xuatXu;
        this.anhGiay = anhGiay;
        this.khuyenMai = khuyenMai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getDoiTuongSuDung() {
        return doiTuongSuDung;
    }

    public void setDoiTuongSuDung(String doiTuongSuDung) {
        this.doiTuongSuDung = doiTuongSuDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public DeGiay getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(DeGiay deGiay) {
        this.deGiay = deGiay;
    }

    public KichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(KichCo kichCo) {
        this.kichCo = kichCo;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public AnhGiay getAnhGiay() {
        return anhGiay;
    }

    public void setAnhGiay(AnhGiay anhGiay) {
        this.anhGiay = anhGiay;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    
    
}
