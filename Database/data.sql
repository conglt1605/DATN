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


INSERT INTO MauSac (TenMauSac, TrangThai) VALUES
('Đen', 1),
('Trắng', 1),
('Đỏ', 1),
('Xanh dương', 1),
('Xanh lá', 1),
('Vàng', 1),
('Cam', 1),
('Xám', 1),
('Tím', 1),
('Hồng', 1);

INSERT INTO ChatLieu (TenChatLieu, TrangThai) VALUES
('Vải lưới', 1),
('Da tổng hợp', 1),
('Vải cotton', 1),
('Da lộn', 1),
('Cao su', 1),
('PU Leather', 1),
('Canvas', 1),
('Nylon', 1),
('Polyester', 1),
('EVA Foam', 1);

INSERT INTO DeGiay (TenDeGiay, TrangThai) VALUES
('Đế cao su non', 1),
('Đế PU Foam', 1),
('Đế Boost', 1),
('Đế EVA', 1),
('Đế Vibram', 1),
('Đế Flyknit', 1),
('Đế TPU', 1),
('Đế Carbon Fiber', 1),
('Đế Air Max', 1),
('Đế React', 1);


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




INSERT INTO SanPham (ID_ThuongHieu, ID_DanhMuc, TenSanPham, TrangThai) VALUES
(1, 1, 'Nike Air Max 270', 1),
(2, 2, 'Adidas Ultraboost 22', 1),
(3, 1, 'Puma RS-X', 1),
(4, 2, 'New Balance 574', 1),
(1, 1, 'Nike Jordan 1', 1),
(2, 2, 'Adidas NMD R1', 1),
(5, 3, 'Asics Gel-Kayano 28', 1),
(6, 3, 'Reebok Zig Kinetica', 1),
(7, 4, 'Converse Chuck Taylor', 1),
(8, 4, 'Vans Old Skool', 1);




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
INSERT INTO HoaDon (
    ID_NhanVien, ID_Voucher, ID_KhachHang, PhuongThucThanhToan, 
    HinhThucMuaHang, PhiShip, NgayTao, NgayHoanTra, NgayGiaoHang, 
    DiaChiGiaoHang, TongSoTien, MoTa, TrangThai
) 
VALUES
(1, 1, 1, 'Thẻ tín dụng', 'Mua online', '30000', '2024-10-30', NULL, '2024-11-02', '123 Đường A, Quận 1', '4800000', 'Đơn hàng thanh toán online', 2),
(2, NULL, 2, 'Tiền mặt', 'Mua tại cửa hàng', NULL, '2024-10-28', NULL, '2024-10-28', NULL, '6000000', 'Mua trực tiếp', 2),
(3, 2, 3, 'Ví điện tử', 'Mua online', '50000', '2024-10-27', '2024-10-29', NULL, '456 Đường B, Quận 2', '5300000', 'Đơn hàng bị hoàn trả', 3),
(1, NULL, 4, 'Chuyển khoản', 'Mua online', '40000', '2024-10-25', NULL, '2024-10-27', '789 Đường C, Quận 3', '3200000', 'Đơn hàng giao nhanh', 2),
(2, 3, 5, 'Tiền mặt', 'Mua tại cửa hàng', NULL, '2024-10-24', NULL, '2024-10-24', NULL, '3500000', 'Mua trực tiếp', 2),
(3, NULL, 6, 'Ví Momo', 'Mua online', '30000', '2024-10-20', NULL, '2024-10-23', '102 Đường D, Quận 4', '2900000', 'Đã giao hàng', 2),
(4, 4, 7, 'Thẻ ATM', 'Mua online', '45000', '2024-10-18', NULL, '2024-10-21', '150 Đường E, Quận 5', '4200000', 'Giao hàng nhanh', 2),
(1, NULL, 8, 'Chuyển khoản', 'Mua online', NULL, '2024-10-15', '2024-10-16', NULL, '50 Đường G, Quận 6', '5100000', 'Bị hoàn trả', 3),
(5, NULL, 9, 'Tiền mặt', 'Mua tại cửa hàng', NULL, '2024-10-10', NULL, '2024-10-10', NULL, '2200000', 'Mua trực tiếp', 2),
(3, 5, 10, 'Ví điện tử', 'Mua online', '35000', '2024-10-05', NULL, '2024-10-07', '200 Đường H, Quận 7', '2700000', 'Thanh toán thành công', 2);


INSERT INTO ChiTietSanPham (ID_SanPham, ID_NhanVien, ID_KichCo, ID_MauSac, ID_DeGiay, ID_ChatLieu, MaChiTietSanPham, TenChiTietSanPham, GiaBan, GiaNhap, SoLuong, MoTa, NgayTao, TrangThai) 
VALUES
(1, 1, 1, 1, 1, 1, 'NIKE270-BLK', 'Nike Air Max 270 - Đen', 4500000, 3000000, 50, 'Giày thể thao êm ái cho chạy bộ', '2024-10-30', 1),
(1, 2, 2, 2, 1, 1, 'NIKE270-WHT', 'Nike Air Max 270 - Trắng', 4500000, 3000000, 30, 'Giày thể thao phong cách', '2024-10-30', 1),
(2, 3, 1, 3, 2, 2, 'ADIDUB-RED', 'Adidas Ultraboost 22 - Đỏ', 5200000, 3200000, 40, 'Giày chạy bộ chuyên nghiệp', '2024-10-30', 1),
(3, 1, 3, 4, 3, 2, 'PUMA-RSX', 'Puma RS-X - Xanh dương', 3500000, 2000000, 25, 'Giày thời trang thể thao', '2024-10-30', 1),
(4, 2, 4, 5, 2, 3, 'NB574-GRN', 'New Balance 574 - Xanh lá', 3200000, 1800000, 20, 'Thiết kế cổ điển', '2024-10-30', 1),
(5, 3, 5, 6, 4, 3, 'JORDAN1-YLW', 'Nike Jordan 1 - Vàng', 6000000, 4000000, 15, 'Giày bóng rổ huyền thoại', '2024-10-30', 1),
(6, 4, 3, 7, 5, 4, 'NMD-R1-ORG', 'Adidas NMD R1 - Cam', 4900000, 3100000, 35, 'Giày công nghệ Boost', '2024-10-30', 1),
(7, 1, 6, 8, 6, 4, 'ASICS-GEL', 'Asics Gel-Kayano 28 - Xám', 3800000, 2500000, 45, 'Hỗ trợ chân tối đa', '2024-10-30', 1),
(8, 2, 4, 9, 7, 5, 'REEB-ZIG', 'Reebok Zig Kinetica - Tím', 3300000, 2100000, 30, 'Công nghệ đế Zig', '2024-10-30', 1),
(9, 3, 5, 10, 8, 5, 'CONV-CT-HNG', 'Converse Chuck Taylor - Hồng', 2500000, 1500000, 60, 'Giày vải cổ cao', '2024-10-30', 1);


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


-- Insert data into AnhGiay
INSERT INTO AnhGiay (TenURL, TrangThai) VALUES
('url_image_shoe_1.jpg', 1),
('url_image_shoe_2.jpg', 1),
('url_image_shoe_3.jpg', 1),
('url_image_shoe_4.jpg', 1),
('url_image_shoe_5.jpg', 1),
('url_image_shoe_6.jpg', 1),
('url_image_shoe_7.jpg', 1),
('url_image_shoe_8.jpg', 1),
('url_image_shoe_9.jpg', 1),
('url_image_shoe_10.jpg', 1);

-- Insert data into ChiTietAnhGiay
INSERT INTO ChiTietAnhGiay (ID_ChiTietSanPham, ID_AnhGiay, TrangThai) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 3, 1),
(2, 4, 1),
(3, 5, 1),
(3, 6, 1),
(4, 7, 1),
(4, 8, 1),
(5, 9, 1),
(5, 10, 1);

-- Insert data into ChiTietChinhSua
INSERT INTO ChiTietChinhSua (ID_ChiTietSanPham, ID_NhanVien, NgayChinhSua, MoTa, TrangThai) VALUES
(1, 1, '2024-10-10', N'Sửa màu sắc giày thể thao', 1),
(2, 2, '2024-10-12', N'Thêm kích cỡ mới', 1),
(3, 3, '2024-10-15', N'Sửa kiểu dáng', 1),
(4, 4, '2024-10-18', N'Thêm thuộc tính chống trơn', 1),
(5, 1, '2024-10-20', N'Chỉnh sửa giá bán', 1),
(1, 2, '2024-10-22', N'Cập nhật thông tin sản phẩm', 1),
(2, 3, '2024-10-25', N'Thêm màu mới', 1),
(3, 4, '2024-10-27', N'Chỉnh sửa chi tiết mô tả', 1),
(4, 1, '2024-10-29', N'Thêm ảnh mới', 1),
(5, 2, '2024-10-30', N'Thêm size mới', 1);

