-- Dữ liệu bảng SanPham (Giày thể thao)
INSERT INTO SanPham (TenSanPham,  TrangThai)
VALUES
('Nike Air Max 97',  1),
('Adidas Ultraboost 21', 1),
('Puma RS-X', 1),
('New Balance 574',  1),
('Reebok Nano X1', 1),
('Asics Gel-Nimbus 23', 1),
('Under Armour HOVR Phantom', 1),
('Saucony Endorphin Pro',  1),
('Mizuno Wave Rider 25', 1),
('Hoka One One Clifton 8', 1);

-- Dữ liệu bảng MauSac (Màu sắc cho giày thể thao)
INSERT INTO MauSac (TenMauSac, TrangThai)
VALUES
('Đỏ', 1),
('Xanh Dương', 1),
('Xanh Lá', 1),
('Đen', 1),
('Trắng', 1),
('Vàng', 1),
('Xám', 1),
('Cam', 1),
('Tím', 1),
('Nâu', 1);

-- Dữ liệu bảng DeGiay (Đế giày thể thao)
INSERT INTO DeGiay (TenDeGiay, TrangThai)
VALUES
('Đế Bằng', 1),
('Đế Cao Su', 1),
('Đế Phylon', 1),
('Đế EVA', 1),
('Đế Boost', 1),
('Đế Gel', 1),
('Đế Air', 1),
('Đế HOVR', 1),
('Đế FlyteFoam', 1),
('Đế React', 1);

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

-- Dữ liệu bảng XuatXu (Xuất xứ giày thể thao)
INSERT INTO XuatXu (TenXuatXu, TrangThai)
VALUES
('Việt Nam', 1),
('Trung Quốc', 1),
('Ấn Độ', 1),
('Indonesia', 1),
('Mỹ', 1),
('Thái Lan', 1),
('Brazil', 1),
('Đức', 1),
('Mexico', 1),
('Ý', 1);

-- Dữ liệu bảng AnhGiay (Ảnh URL giày thể thao)
INSERT INTO AnhGiay (TenURL, TrangThai)
VALUES
('nike-air-max-97.jpg', 1),
('adidas-ultraboost-21.jpg', 1),
('puma-rsx.jpg', 1),
('new-balance-574.jpg', 1),
('reebok-nano-x1.jpg', 1),
('asics-gel-nimbus-23.jpg', 1),
('under-armour-hovr-phantom.jpg', 1),
('saucony-endorphin-pro.jpg', 1),
('mizuno-wave-rider-25.jpg', 1),
('hoka-one-one-clifton-8.jpg', 1);

-- Dữ liệu bảng ChatLieu (Chất liệu giày thể thao)
INSERT INTO ChatLieu (TenChatLieu, TrangThai)
VALUES
('Vải Lưới', 1),
('Da Tổng Hợp', 1),
('Vải Cotton', 1),
('Da Thật', 1),
('Polyester', 1),
('Nylon', 1),
('Mesh', 1),
('Synthetic', 1),
('Knit', 1),
('Canvas', 1);

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

-- Dữ liệu bảng NhanVien (Nhân viên)
INSERT INTO NhanVien (MaNhanVien, TenNhanVien, MatKhau, TenTaiKhoan, Email, SoDienThoai, DiaChi, NgaySinh, NgayTuyenDung, NgayNghiViec, TrangThai)
VALUES
('NV01', 'Nguyen Van A', 'password123', 'nva', 'nva@example.com', '0987654321', 'Hà Nội', '1985-01-01', '2020-01-01', NULL, 1),
('NV02', 'Tran Thi B', 'password123', 'ttb', 'ttb@example.com', '0987654322', 'Hồ Chí Minh', '1987-02-02', '2020-02-01', NULL, 1),
('NV03', 'Le Van C', 'password123', 'lvc', 'lvc@example.com', '0987654323', 'Đà Nẵng', '1989-03-03', '2020-03-01', NULL, 1),
('NV04', 'Pham Thi D', 'password123', 'ptd', 'ptd@example.com', '0987654324', 'Cần Thơ', '1991-04-04', '2020-04-01', NULL, 1),
('NV05', 'Hoang Van E', 'password123', 'hve', 'hve@example.com', '0987654325', 'Nha Trang', '1993-05-05', '2020-05-01', NULL, 1),
('NV06', 'Vu Thi F', 'password123', 'vtf', 'vtf@example.com', '0987654326', 'Huế', '1995-06-06', '2020-06-01', NULL, 1),
('NV07', 'Nguyen Van G', 'password123', 'nvg', 'nvg@example.com', '0987654327', 'Hà Nội', '1987-07-07', '2020-07-01', NULL, 1),
('NV08', 'Tran Thi H', 'password123', 'tth', 'tth@example.com', '0987654328', 'Hồ Chí Minh', '1989-08-08', '2020-08-01', NULL, 1),
('NV09', 'Le Van I', 'password123', 'lvi', 'lvi@example.com', '0987654329', 'Đà Nẵng', '1991-09-09', '2020-09-01', NULL, 1),
('NV10', 'Pham Thi J', 'password123', 'ptj', 'ptj@example.com', '0987654330', 'Cần Thơ', '1993-10-10', '2020-10-01', NULL, 1);

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

-- Dữ liệu bảng ChiTietSanPham 
INSERT INTO ChiTietSanPham (ID_SanPham, ID_NhanVien, ID_MauSac, ID_ThuongHieu, ID_DanhMuc, ID_ChatLieu, ID_DeGiay, ID_KichCo, ID_XuatXu, ID_AnhGiay, ID_KhuyenMai, MaSanPham, SoLuong, GiaBan, GiaNhap, DoiTuongSuDung, MoTa, NgayTao, TrangThai)
VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'SP01', 20, '2000000', '1200000', 'Nam', 'Giày thể thao nam Nike Air', '2024-01-01', 1),
(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 'SP02', 25, '2200000', '1500000', 'Nữ', 'Giày thể thao nữ Adidas Ultraboost', '2024-01-02', 1),
(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 'SP03', 30, '2400000', '1600000', 'Nam', 'Giày thể thao nam Puma', '2024-01-03', 1),
(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 'SP04', 40, '2600000', '1800000', 'Nữ', 'Giày thể thao nữ Reebok', '2024-01-04', 1),
(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 'SP05', 50, '2800000', '2000000', 'Nam', 'Giày thể thao nam Converse', '2024-01-05', 1),
(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 'SP06', 60, '3000000', '2200000', 'Trẻ em', 'Giày thể thao trẻ em Vans', '2024-01-06', 1),
(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 'SP07', 70, '3200000', '2400000', 'Nữ', 'Giày thể thao nữ New Balance', '2024-01-07', 1),
(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 'SP08', 80, '3400000', '2600000', 'Nam', 'Giày thể thao nam Fila', '2024-01-08', 1),
(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 'SP09', 90, '3600000', '2800000', 'Nữ', 'Giày thể thao nữ Skechers', '2024-01-09', 1),
(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 'SP10', 100, '3800000', '3000000', 'Nam', 'Giày thể thao nam Asics', '2024-01-10', 1),
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'SP11', 10, '1500000', '1000000', 'Nam', 'Giày thể thao nam Under Armour', '2024-01-11', 1),
(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 'SP12', 15, '1800000', '1200000', 'Nữ', 'Giày thể thao nữ Jordan', '2024-01-12', 1),
(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 'SP13', 20, '2200000', '1500000', 'Nam', 'Giày thể thao nam Adidas Yeezy', '2024-01-13', 1),
(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 'SP14', 30, '2400000', '1600000', 'Nữ', 'Giày thể thao nữ Puma Suede', '2024-01-14', 1),
(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 'SP15', 40, '2800000', '2000000', 'Nam', 'Giày thể thao nam New Balance 574', '2024-01-15', 1),
(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 'SP16', 50, '3200000', '2500000', 'Nữ', 'Giày thể thao nữ Reebok Classic', '2024-01-16', 1),
(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 'SP17', 60, '3500000', '2700000', 'Trẻ em', 'Giày thể thao trẻ em Skechers', '2024-01-17', 1),
(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 'SP18', 70, '3800000', '3000000', 'Nam', 'Giày thể thao nam Nike SB', '2024-01-18', 1),
(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 'SP19', 80, '4000000', '3200000', 'Nữ', 'Giày thể thao nữ Under Armour Hovr', '2024-01-19', 1),
(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 'SP20', 90, '4200000', '3500000', 'Nam', 'Giày thể thao nam Vans Old Skool', '2024-01-20', 1);

-- Dữ liệu bảng ChiTietGioHang (Chi tiết giỏ hàng)
INSERT INTO ChiTietGioHang (ID_GioHang, ID_SanPhamChiTiet, SoLuong, NgayTao, TrangThai)
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
