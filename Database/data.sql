-- Dữ liệu bảng ThuongHieu (Thương hiệu giày thể thao)
INSERT INTO ThuongHieu (TenThuongHieu, TrangThai)
VALUES
('Nike', 1),
('Adidas', 1),
('Puma', 1),
('New Balance', 1),
('Reebok', 1),
('Asics', 1),
('Under Armour', 1),
('Saucony', 1),
('Mizuno', 1),
('Hoka One One', 1);

-- Chèn dữ liệu vào bảng Thuộc Tính
INSERT INTO ThuocTinh (TenThuocTinh, MoTa, NgayTao, TrangThai) VALUES
(N'Màu sắc', N'Phân loại theo màu', GETDATE(), 1),
(N'Chất liệu', N'Phân loại theo chất liệu', GETDATE(), 1),
(N'Kiểu dáng', N'Phân loại theo kiểu dáng', GETDATE(), 1);

-- Chèn dữ liệu vào bảng Chi Tiết Thuộc Tính
INSERT INTO ChiTietThuocTinh (ID_ThuocTinh, Loai, TrangThai) VALUES
(1, N'Đỏ', 1),
(1, N'Xanh', 1),
(1, N'Đen', 1),
(2, N'Da', 1),
(2, N'Vải', 1),
(3, N'Cổ thấp', 1),
(3, N'Cổ cao', 1);

-- Chèn dữ liệu vào bảng Sản Phẩm
INSERT INTO SanPham (ID_ThuongHieu, TenSanPham, TrangThai) VALUES
(1, N'Nike Air Max', 1),
(2, N'Adidas UltraBoost', 1),
(3, N'Puma Future', 1),
(4, N'Converse Chuck Taylor', 1),
(5, N'New Balance 574', 1);



-- Dữ liệu bảng KichCo (Kích cỡ giày thể thao)
INSERT INTO KichCo (SoKichCo, TrangThai)
VALUES
('36', 1),
('37', 1),
('38', 1),
('39', 1),
('40', 1),
('41', 1),
('42', 1),
('43', 1),
('44', 1),
('45', 1);






-- Dữ liệu bảng DanhMuc (Danh mục sản phẩm giày thể thao)
INSERT INTO DanhMuc (TenDanhMuc, TrangThai)
VALUES
('Chạy Bộ', 1),
('Tập Gym', 1),
('Bóng Đá', 1),
('Bóng Rổ', 1),
('Tennis', 1),
('Cầu Lông', 1),
('Đi Bộ', 1),
('Thời Trang', 1),
('Dã Ngoại', 1),
('Leo Núi', 1);



-- Dữ liệu bảng KhuyenMai (Khuyến mãi)
INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, NgayBatDau, NgayKetThuc, MoTa, TrangThai)
VALUES
('KM01', 'Giảm giá 10%', '2024-01-01', '2024-01-31', 'Giảm giá 10% cho đơn hàng từ 1 triệu', 1),
('KM02', 'Giảm giá 15%', '2024-02-01', '2024-02-28', 'Giảm giá 15% cho giày Nike', 1),
('KM03', 'Giảm giá 20%', '2024-03-01', '2024-03-31', 'Giảm giá 20% cho giày Adidas', 1),
('KM04', 'Mua 1 tặng 1', '2024-04-01', '2024-04-30', 'Mua 1 tặng 1 cho giày Puma', 1),
('KM05', 'Giảm giá 25%', '2024-05-01', '2024-05-31', 'Giảm giá 25% cho đơn hàng từ 2 triệu', 1),
('KM06', 'Tặng Voucher', '2024-06-01', '2024-06-30', 'Tặng voucher cho khách hàng mới', 1),
('KM07', 'Giảm giá 5%', '2024-07-01', '2024-07-31', 'Giảm giá 5% cho đơn hàng bất kỳ', 1),
('KM08', 'Giảm giá 50%', '2024-08-01', '2024-08-31', 'Giảm giá 50% cho giày Under Armour', 1),
('KM09', 'Giảm giá 30%', '2024-09-01', '2024-09-30', 'Giảm giá 30% cho giày Reebok', 1),
('KM10', 'Miễn phí vận chuyển', '2024-10-01', '2024-10-31', 'Miễn phí vận chuyển cho đơn hàng trên 500k', 1);

-- Dữ liệu bảng Voucher
INSERT INTO Voucher (TenVoucher, GiaTri, TrangThai)
VALUES
('Voucher100K', '100000', 1),
('Voucher200K', '200000', 1),
('Voucher300K', '300000', 1),
('Voucher400K', '400000', 1),
('Voucher500K', '500000', 1),
('Voucher600K', '600000', 1),
('Voucher700K', '700000', 1),
('Voucher800K', '800000', 1),
('Voucher900K', '900000', 1),
('Voucher1M', '1000000', 1);

-- Dữ liệu bảng KhachHang (Khách hàng)
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, MatKhau, TenTaiKhoan, Email, SoDienThoai, DiaChi, NgaySinh, NgayTao, TrangThai)
VALUES
('KH01', 'Nguyen Van A', 'password123', 'nguyenvana', 'nguyenvana@example.com', '0912345678', 'Hà Nội', '1990-01-01', '2024-01-01', 1),
('KH02', 'Tran Thi B', 'password123', 'tranthib', 'tranthib@example.com', '0912345679', 'Hồ Chí Minh', '1992-02-02', '2024-02-01', 1),
('KH03', 'Le Van C', 'password123', 'levanc', 'levanc@example.com', '0912345680', 'Đà Nẵng', '1994-03-03', '2024-03-01', 1),
('KH04', 'Pham Thi D', 'password123', 'phamthid', 'phamthid@example.com', '0912345681', 'Cần Thơ', '1996-04-04', '2024-04-01', 1),
('KH05', 'Hoang Van E', 'password123', 'hoangvane', 'hoangvane@example.com', '0912345682', 'Nha Trang', '1998-05-05', '2024-05-01', 1),
('KH06', 'Vu Thi F', 'password123', 'vuthif', 'vuthif@example.com', '0912345683', 'Huế', '1991-06-06', '2024-06-01', 1),
('KH07', 'Nguyen Van G', 'password123', 'nguyenvang', 'nguyenvang@example.com', '0912345684', 'Hà Nội', '1993-07-07', '2024-07-01', 1),
('KH08', 'Tran Thi H', 'password123', 'tranthih', 'tranthih@example.com', '0912345685', 'Hồ Chí Minh', '1995-08-08', '2024-08-01', 1),
('KH09', 'Le Van I', 'password123', 'levani', 'levani@example.com', '0912345686', 'Đà Nẵng', '1997-09-09', '2024-09-01', 1),
('KH10', 'Pham Thi J', 'password123', 'phamthij', 'phamthij@example.com', '0912345687', 'Cần Thơ', '1999-10-10', '2024-10-01', 1);

INSERT INTO NhanVien (MaNhanVien, TenNhanVien, MatKhau, TenTaiKhoan, CCCD, Email, SoDienThoai, DiaChi, NgaySinh, NgayTuyenDung, NgayNghiViec, VaiTro, TrangThai)
VALUES 
-- Admin
('NV001', 'Nguyen Van Admin', 'admin123', 'admin', '012345678901', 'admin@example.com', '0909123456', '123 Nguyen Trai, Ha Noi', '1980-01-01', '2010-01-01', NULL, 0, 1),

-- Nhân viên
('NV002', 'Tran Thi B', 'password123', 'nv_b', '098765432109', 'tranthib@example.com', '0912345678', '456 Le Loi, TP HCM', '1992-07-20', '2019-05-01', NULL, 1, 1),
('NV003', 'Le Van C', 'matkhau456', 'nv_c', '123456789012', 'levanc@example.com', '0932123456', '789 Tran Phu, Da Nang', '1995-10-10', '2021-03-01', NULL, 1, 1),
('NV004', 'Nguyen Thi D', 'pass789', 'nv_d', '234567890123', 'nguyenthid@example.com', '0922345678', '12 Ly Thuong Kiet, Ha Noi', '1988-11-15', '2018-08-01', NULL, 1, 1),
('NV005', 'Pham Van E', 'mk123456', 'nv_e', '345678901234', 'phamvane@example.com', '0945123456', '23 Phan Chu Trinh, HCM', '1990-03-10', '2020-02-15', NULL, 1, 1),
('NV006', 'Do Thi F', 'mypass789', 'nv_f', '456789012345', 'dothif@example.com', '0912123123', '789 Cach Mang Thang Tam, HCM', '1993-05-25', '2022-07-01', NULL, 1, 1),
('NV007', 'Hoang Van G', 'pass999', 'nv_g', '567890123456', 'hoangvang@example.com', '0987897890', '456 Ngo Gia Tu, Ha Noi', '1985-09-09', '2017-12-20', NULL, 1, 1),
('NV008', 'Nguyen Van H', 'password111', 'nv_h', '678901234567', 'nguyenvanh@example.com', '0901234567', '15 Bach Mai, Ha Noi', '1989-06-30', '2019-11-11', NULL, 1, 1),
('NV009', 'Le Thi I', 'lethi333', 'nv_i', '789012345678', 'lethii@example.com', '0949988776', '98 Hai Ba Trung, Da Nang', '1991-12-05', '2020-03-15', NULL, 1, 1),
('NV010', 'Tran Van J', 'pass444', 'nv_j', '890123456789', 'tranvanj@example.com', '0933001122', '17 Dinh Tien Hoang, Ha Noi', '1994-04-20', '2021-06-10', NULL, 1, 1);

-- Dữ liệu bảng GioHang (Giỏ hàng)
INSERT INTO GioHang (ID_KhachHang, TrangThai)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1);

-- Dữ liệu bảng HoaDon (Hóa đơn)
INSERT INTO HoaDon (ID_NhanVien, ID_Voucher, PhuongThucThanhToan, HinhThucMuaHang, PhiShip, NgayTao, NgayHoanTra, NgayGiaoHang, DiaChiGiaoHang, TongSoTien, MoTa, TrangThai)
VALUES
(1, 1, 'Chuyển khoản', 'Online', '0', '2024-01-01', NULL, '2024-01-05', 'Hà Nội', '1000000', 'Thanh toán thành công', 1),
(2, 2, 'Tiền mặt', 'Offline', '0', '2024-01-03', NULL, '2024-01-07', 'Hồ Chí Minh', '1500000', 'Thanh toán thành công', 1),
(3, 3, 'Chuyển khoản', 'Online', '0', '2024-01-05',  NULL, '2024-01-08', 'Đà Nẵng', '2000000', 'Thanh toán thành công', 1),
(4, 4, 'Tiền mặt', 'Offline', '0', '2024-01-07',  NULL, '2024-01-10', 'Cần Thơ', '2500000', 'Thanh toán thành công', 1),
(5, 5, 'Chuyển khoản', 'Online', '0', '2024-01-09',  NULL, '2024-01-12', 'Nha Trang', '3000000', 'Thanh toán thành công', 1),
(6, 6, 'Chuyển khoản', 'Online', '50000', '2024-01-11', NULL, '2024-01-15', 'Huế', '3500000', 'Thanh toán thành công', 1),
(7, 7, 'Tiền mặt', 'Offline', '50000', '2024-01-13',  NULL, '2024-01-17', 'Hà Nội', '4000000', 'Thanh toán thành công', 1),
(8, 8, 'Chuyển khoản', 'Online', '50000', '2024-01-15', NULL, '2024-01-19', 'Hồ Chí Minh', '4500000', 'Thanh toán thành công', 1),
(9, 9, 'Tiền mặt', 'Offline', '50000', '2024-01-17',  NULL, '2024-01-20', 'Đà Nẵng', '5000000', 'Thanh toán thành công', 1),
(10, 10, 'Chuyển khoản', 'Online', '50000', '2024-01-19',  NULL, '2024-01-22', 'Cần Thơ', '5500000', 'Thanh toán thành công', 1);

INSERT INTO ChiTietSanPham 
(ID_SanPham, ID_NhanVien, ID_KichCo, MaSanPham, TenChiTietSanPham, GiaBan, GiaNhap, SoLuong, MoTa, NgayTao, TrangThai) 
VALUES
(1, 1, 1, 'SP001', N'Giày thể thao Nike Air Max', 2500000, 2000000, 100, N'Giày chạy bộ thoải mái và phong cách', '2024-10-01', 1),
(1, 2, 2, 'SP002', N'Giày thể thao Adidas Ultraboost', 3000000, 2500000, 80, N'Giày với đế Boost êm ái', '2024-10-02', 1),
(2, 1, 3, 'SP003', N'Giày thể thao Puma RS-X', 2200000, 1800000, 120, N'Phong cách retro', '2024-10-03', 1),
(3, 3, 4, 'SP004', N'Giày thể thao Converse Chuck Taylor', 1800000, 1500000, 200, N'Huyền thoại giày canvas', '2024-10-04', 1),
(2, 2, 5, 'SP005', N'Giày thể thao New Balance 574', 2000000, 1700000, 150, N'Kiểu dáng cổ điển và tiện dụng', '2024-10-05', 1),
(3, 4, 1, 'SP006', N'Giày thể thao Jordan 1 Retro', 5000000, 4500000, 50, N'Biểu tượng của thời trang và thể thao', '2024-10-06', 1),
(1, 3, 2, 'SP007', N'Giày thể thao Asics Gel-Kayano', 3200000, 2800000, 60, N'Giày hỗ trợ chạy bộ chuyên nghiệp', '2024-10-07', 1),
(2, 1, 3, 'SP008', N'Giày thể thao Reebok Classic', 1600000, 1300000, 100, N'Phong cách cổ điển', '2024-10-08', 1),
(3, 4, 4, 'SP009', N'Giày thể thao Vans Old Skool', 1700000, 1400000, 90, N'Giày trượt ván cổ điển', '2024-10-09', 1),
(1, 2, 5, 'SP010', N'Giày thể thao Under Armour HOVR', 2800000, 2400000, 70, N'Giày chạy bộ với công nghệ HOVR', '2024-10-10', 1);


-- Dữ liệu bảng ChiTietGioHang (Chi tiết giỏ hàng)
INSERT INTO ChiTietGioHang (ID_GioHang, ID_ChiTietSanPham, SoLuong, NgayTao, TrangThai)
VALUES
(1, 1, '2', '2024-01-01', 1),
(2, 2, '1', '2024-01-02', 1),
(3, 3, '3', '2024-01-03', 1),
(4, 4, '2', '2024-01-04', 1),
(5, 5, '1', '2024-01-05', 1),
(6, 6, '4', '2024-01-06', 1),
(7, 7, '2', '2024-01-07', 1),
(8, 8, '1', '2024-01-08', 1),
(9, 9, '3', '2024-01-09', 1),
(10, 10, '1', '2024-01-10', 1);

-- Dữ liệu bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (ID_HoaDon, ID_ChiTietSanPham, SoLuong, TrangThai)
VALUES
(1, 1, '2', 1),
(1, 2, '1', 1),
(2, 3, '3', 1),
(2, 4, '1', 1),
(3, 5, '5', 1),
(4, 6, '2', 1),
(4, 7, '1', 1),
(5, 8, '4', 1),
(5, 9, '2', 1),
(6, 10, '1', 1),
(7, 1, '3', 1),
(7, 2, '2', 1),
(8, 3, '4', 1),
(8, 4, '1', 1),
(9, 5, '2', 1),
(10, 6, '3', 1),
(10, 7, '1', 1);

-- Chèn dữ liệu vào bảng Thuộc Tính Sản Phẩm
INSERT INTO ThuocTinhSanPham (ID_ChiTietSanPham, ID_ChiTietThuocTinh, TrangThai) VALUES
(1, 1, 1),  -- Chi tiết sản phẩm 1 (Nike Air Max - Đỏ) có màu sắc Đỏ
(1, 2, 1),  -- Chi tiết sản phẩm 1 (Nike Air Max - Đỏ) có màu sắc Xanh
(1, 3, 1),  -- Chi tiết sản phẩm 1 (Nike Air Max - Đỏ) có chất liệu Da
(2, 1, 1),  -- Chi tiết sản phẩm 2 (Nike Air Max - Xanh) có màu sắc Đỏ
(2, 3, 1),  -- Chi tiết sản phẩm 2 (Nike Air Max - Xanh) có chất liệu Da
(3, 1, 1),  -- Chi tiết sản phẩm 3 (Nike Air Force 1 - Trắng) có màu sắc Đỏ
(3, 2, 1),  -- Chi tiết sản phẩm 3 (Nike Air Force 1 - Trắng) có màu sắc Xanh
(4, 1, 1),  -- Chi tiết sản phẩm 4 (Adidas UltraBoost - Đen) có màu sắc Đỏ
(4, 3, 1)  -- Chi tiết sản phẩm 4 (Adidas UltraBoost - Đen) có chất liệu Da

INSERT INTO AnhGiay (ID_ChiTietSanPham, TenURL, TrangThai) VALUES
(1, 'https://example.com/image1.jpg', 1),
(2, 'https://example.com/image2.jpg', 1),
(3, 'https://example.com/image3.jpg', 1),
(4, 'https://example.com/image4.jpg', 0),
(5, 'https://example.com/image5.jpg', 1),
(6, 'https://example.com/image6.jpg', 1),
(7, 'https://example.com/image7.jpg', 0),
(8, 'https://example.com/image8.jpg', 1),
(9, 'https://example.com/image9.jpg', 1),
(10, 'https://example.com/image10.jpg', 0);

INSERT INTO ChiTietDanhMuc (ID_ChiTietSanPham, ID_DanhMuc, TrangThai) 
VALUES 
(1, 1, 1),
(1, 2, 1),
(2, 1, 1),
(3, 1, 1),
(2, 2, 1);


