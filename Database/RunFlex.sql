	ALTER DATABASE RunFlex SET SINGLE_USER WITH ROLLBACK IMMEDIATE;

use master
drop database RunFlex

create database RunFlex 
use RunFlex




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

create table MauSac(
ID int primary key identity(1,1),
TenMauSac nvarchar(255) not null,
TrangThai int not null
)

create table ChatLieu(
ID int primary key identity(1,1),
TenChatLieu nvarchar(255) not null,
TrangThai int not null
)

create table DeGiay(
ID int primary key identity(1,1),
TenDeGiay nvarchar(255) not null,
TrangThai int not null
)





-- Bảng Sản phẩm
CREATE TABLE SanPham (
    ID INT PRIMARY KEY identity(1,1),
    ID_ThuongHieu INT,
    ID_DanhMuc INT,
	MaSanPham varchar(20), --Mã tự tạo
	GioiTinh int not null, --1:nam, 2: nữ
    TenSanPham NVARCHAR(255) NOT NULL,
    TrangThai int NOT NULL,
    FOREIGN KEY (ID_ThuongHieu) REFERENCES ThuongHieu(ID),
	FOREIGN KEY (ID_DanhMuc) REFERENCES DanhMuc(ID)
);



create table KichCo(
ID int primary key identity(1,1),
SoKichCo varchar(2) not null,
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
MaKhachHang varchar(20) , --Mã tự tạo
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
MaNhanVien varchar(20) , --Mã tự tạo
TenNhanVien nvarchar(255) not null,
MatKhau varchar(20) not null,
TenTaiKhoan varchar(20) not null,
CCCD varchar(15) not null,
Email varchar(255) not null,
SoDienThoai varchar(15) not null,
DiaChi nvarchar(255) not null,
NgaySinh date not null,
NgayTuyenDung date not null,
NgayNghiViec date ,
VaiTro int not null, --0:quản lý, 1:nhân viên
TrangThai int not null --1:đang hoạt động, 2:vô hiệu hóa, 0:đã xóa
)

create table GioHang(
ID int primary key identity(1,1),
ID_KhachHang int not null unique,
TrangThai int not null
foreign key (ID_KhachHang) references KhachHang(ID)
)

create table HoaDon(
ID int primary key identity(1,1),
ID_NhanVien int null,
ID_Voucher int null,
ID_KhachHang int null,	
PhuongThucThanhToan int null, --1:tiền mặt, 2:tiền tài khoản
HinhThucMuaHang int not null, --1:tại quầy, 2:online 
PhiShip DECIMAL(18, 0) null,
NgayTao date not null,
NgayHoanTra date null,
NgayGiaoHang date null,
DiaChiGiaoHang nvarchar(255) null,
TongSoTien varchar(20) not null,
MoTa nvarchar(255) null,
TrangThai int not null --1:chưa thanh toán, 2:đã thanh toán, 3:đã hoàn tiền
foreign key (ID_NhanVien) references NhanVien(ID),
foreign key (ID_Voucher) references Voucher(ID),
foreign key (ID_KhachHang) references KhachHang(ID)
)

CREATE TABLE ChiTietSanPham (
    ID INT PRIMARY KEY identity(1,1),
    ID_SanPham INT,
    ID_NhanVien INT,
    ID_KichCo INT,
	ID_MauSac INT,
	ID_DeGiay INT,
	ID_ChatLieu INT,
	MaChiTietSanPham varchar(50) , --Mã tự tạo
    TenChiTietSanPham VARCHAR(255) NOT NULL,
    GiaBan DECIMAL(18, 0) NOT NULL,
    SoLuong INT NOT NULL,
    MoTa Nvarchar(255),
    NgayTao DATE ,
    TrangThai int NOT NULL,
    FOREIGN KEY (ID_SanPham) REFERENCES SanPham(ID),
	FOREIGN KEY (ID_KichCo) REFERENCES KichCo(ID),
		FOREIGN KEY (ID_NhanVien) REFERENCES NhanVien(ID),
		FOREIGN KEY (ID_MauSac) REFERENCES MauSac(ID),
		FOREIGN KEY (ID_DeGiay) REFERENCES DeGiay(ID),
		FOREIGN KEY (ID_ChatLieu) REFERENCES ChatLieu(ID),
);

create table ChiTietGioHang(
ID int primary key identity(1,1),
ID_GioHang int not null,
ID_ChiTietSanPham int not null,
SoLuong varchar(20) not null,
NgayTao date not null,
TrangThai int not null
foreign key (ID_GioHang) references GioHang(ID),
foreign key (ID_ChiTietSanPham) references ChiTietSanPham(ID)
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


create table AnhGiay(
ID int primary key identity(1,1),
TenURL nvarchar(255) not null,
TrangThai int not null
)

create table ChiTietAnhGiay(
ID int primary key identity(1,1),
ID_ChiTietSanPham int not null,
ID_AnhGiay int not null,
TrangThai int not null
FOREIGN KEY (ID_ChiTietSanPham) REFERENCES ChiTietSanPham(ID),
FOREIGN KEY (ID_AnhGiay) REFERENCES AnhGiay(ID)
)

create table ChiTietChinhSua(
ID int primary key identity(1,1),
ID_ChiTietSanPham int not null,
ID_NhanVien int not null,
NgayChinhSua date not null,
MoTa nvarchar(255) not null,
TrangThai int not null
FOREIGN KEY (ID_ChiTietSanPham) REFERENCES ChiTietSanPham(ID),
FOREIGN KEY (ID_NhanVien) REFERENCES NhanVien(ID)
)

--mã ctsp tự tăng
go
CREATE TRIGGER trg_MaChiTietSanPham
ON ChiTietSanPham
AFTER INSERT
AS
BEGIN
    UPDATE ctsp
    SET ctsp.MaChiTietSanPham = CONCAT('CTSP', ctsp.ID)
    FROM ChiTietSanPham AS ctsp
    INNER JOIN inserted AS ins ON ctsp.ID = ins.ID
    WHERE ctsp.MaChiTietSanPham IS NULL; -- Chỉ cập nhật nếu giá trị hiện tại là NULL
END;

GO

--mã mã sp tự tăng
CREATE TRIGGER trg_MaSanPham
ON SanPham
AFTER INSERT
AS
BEGIN
    UPDATE sp
    SET sp.MaSanPham = CONCAT('SP', sp.ID)
    FROM SanPham AS sp
    INNER JOIN inserted AS ins ON sp.ID = ins.ID
    WHERE sp.MaSanPham IS NULL; -- Chỉ cập nhật nếu giá trị hiện tại là NULL
END;

GO

--mã nv tự tăng
CREATE TRIGGER trg_MaNhanVien
ON NhanVien
AFTER INSERT
AS
BEGIN
    UPDATE nv
    SET nv.MaNhanVien = CONCAT('NV', nv.ID)
    FROM NhanVien AS nv
    INNER JOIN inserted AS ins ON nv.ID = ins.ID
    WHERE nv.MaNhanVien IS NULL; -- Chỉ cập nhật nếu giá trị hiện tại là NULL
END;

GO

--mã mã kh tự tăng
CREATE TRIGGER trg_MaKhachHang
ON KhachHang
AFTER INSERT
AS
BEGIN
    UPDATE kh
    SET kh.MaKhachHang = CONCAT('KH', kh.ID)
    FROM KhachHang AS kh
    INNER JOIN inserted AS ins ON kh.ID = ins.ID
    WHERE kh.MaKhachHang IS NULL; -- Chỉ cập nhật nếu giá trị hiện tại là NULL
END;

GO



