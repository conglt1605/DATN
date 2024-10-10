ALTER DATABASE RunFlex SET SINGLE_USER WITH ROLLBACK IMMEDIATE;

use master
drop database RunFlex

create database RunFlex
use RunFlex

create table SanPham(
ID int primary key identity(1,1),
TenSanPham nvarchar(255) not null,
TrangThai int not null
)

create table MauSac(
ID int primary key identity(1,1),
TenMauSac nvarchar(255) not null,
TrangThai int not null
)

create table DeGiay(
ID int primary key identity(1,1),
TenDeGiay nvarchar(255) not null,
TrangThai int not null
)

create table KichCo(
ID int primary key identity(1,1),
SoKichCo varchar(2) not null,
TrangThai int not null
)

create table XuatXu(
ID int primary key identity(1,1),
TenXuatXu nvarchar(255) not null,
TrangThai int not null
)

create table AnhGiay(
ID int primary key identity(1,1),
TenURL nvarchar(255) not null,
TrangThai int not null
)

create table ChatLieu(
ID int primary key identity(1,1),
TenChatLieu nvarchar(255) not null,
TrangThai int not null
)

create table DanhMuc(
ID int primary key identity(1,1),
TenDanhMuc nvarchar(255) not null,
TrangThai int not null
)

create table ThuongHieu(
ID int primary key identity(1,1),
TenThuongHieu nvarchar(255) not null,
TrangThai int not null
)

create table KhuyenMai(
ID int primary key identity(1,1),
MaKhuyenMai varchar(20) not null,
TenKhuyenMai nvarchar(255) not null,
NgayBatDau date not null,
NgayKetThuc date not null,
MoTa nvarchar(255) not null,
TrangThai int not null
)

create table Voucher(
ID int primary key identity(1,1),
TenVoucher nvarchar(255) not null,
GiaTri varchar(20) not null,
TrangThai int not null
)

create table KhachHang(
ID int primary key identity(1,1),
MaKhachHang varchar(20) not null,
TenKhachHang nvarchar(255) not null,
MatKhau varchar(20) not null,
TenTaiKhoan varchar(20) not null,
Email varchar(255) not null,
SoDienThoai varchar(15) not null,
DiaChi nvarchar(255) not null,
NgaySinh date not null,
NgayTao date not null,
TrangThai int not null
)

create table NhanVien(
ID int primary key identity(1,1),
MaNhanVien varchar(20) not null,
TenNhanVien nvarchar(255) not null,
MatKhau varchar(20) not null,
TenTaiKhoan varchar(20) not null,
Email varchar(255) not null,
SoDienThoai varchar(15) not null,
DiaChi nvarchar(255) not null,
NgaySinh date not null,
NgayTuyenDung date not null,
NgayNghiViec date ,
TrangThai int not null
)

create table GioHang(
ID int primary key identity(1,1),
ID_KhachHang int not null unique,
TrangThai int not null
foreign key (ID_KhachHang) references KhachHang(ID)
)

create table HoaDon(
ID int primary key identity(1,1),
ID_NhanVien int not null,
ID_Voucher int null,
PhuongThucThanhToan nvarchar(255) not null,
HinhThucMuaHang nvarchar(255) not null,
PhiShip varchar(20) ,
NgayTao date not null,
NgayHoanTra date ,
NgayGiaoHang date ,
DiaChiGiaoHang nvarchar(255) ,
TongSoTien varchar(20) not null,
MoTa nvarchar(255) not null,
TrangThai int not null --1:chưa thanh toán, 2:đã thanh toán, 3:đã hoàn tiền
foreign key (ID_NhanVien) references NhanVien(ID),
foreign key (ID_Voucher) references Voucher(ID)
)

create table ChiTietSanPham(
ID int primary key identity(1,1),
ID_SanPham int not null,
ID_NhanVien int not null,
ID_MauSac int not null,
ID_ThuongHieu int not null,
ID_DanhMuc int not null,
ID_ChatLieu int not null,
ID_DeGiay int not null,
ID_KichCo int not null,
ID_XuatXu int not null,
ID_AnhGiay int not null,
ID_KhuyenMai int null,
MaSanPham varchar(20) not null,
SoLuong varchar(20) not null,
GiaBan varchar(20) not null,
GiaNhap varchar(20) not null,
DoiTuongSuDung nvarchar(255) not null,
MoTa nvarchar(255) not null,
NgayTao date not null,
TrangThai int not null
foreign key (ID_SanPham) references SanPham(ID),
foreign key (ID_NhanVien) references NhanVien(ID),
foreign key (ID_MauSac) references MauSac(ID),
foreign key (ID_ThuongHieu) references ThuongHieu(ID),
foreign key (ID_DanhMuc) references DanhMuc(ID),
foreign key (ID_ChatLieu) references ChatLieu(ID),
foreign key (ID_DeGiay) references DeGiay(ID),
foreign key (ID_KichCo) references KichCo(ID),
foreign key (ID_XuatXu) references XuatXu(ID),
foreign key (ID_AnhGiay) references AnhGiay(ID),
foreign key (ID_KhuyenMai) references KhuyenMai(ID)
)

create table ChiTietGioHang(
ID int primary key identity(1,1),
ID_GioHang int not null,
ID_SanPhamChiTiet int not null,
SoLuong varchar(20) not null,
NgayTao date not null,
TrangThai int not null
foreign key (ID_GioHang) references GioHang(ID),
foreign key (ID_SanPhamChiTiet) references ChiTietSanPham(ID)
)

create table ChiTietHoaDon(
ID int primary key identity(1,1),
ID_HoaDon int not null,
ID_ChiTietSanPham int not null,
SoLuong varchar(20) not null,
TrangThai int not null
foreign key (ID_HoaDon) references HoaDon(ID),
foreign key (ID_ChiTietSanPham) references ChiTietSanPham(ID)
)
