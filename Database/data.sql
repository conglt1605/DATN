	

-- Dữ liệu bảng DanhMuc (Danh mục sản phẩm giày thể thao)
INSERT INTO DanhMuc (TenDanhMuc, TrangThai)
VALUES
(N'Chạy Bộ', 1),
(N'Tập Gym', 1),
(N'Bóng Đá', 1),
(N'Bóng Rổ', 1),
(N'Tennis', 1),
(N'Cầu Lông', 1),
(N'Đi Bộ', 1),
(N'Thời Trang', 1),
(N'Dã Ngoại', 1),
(N'Leo Núi', 1);

-- Dữ liệu bảng MauSac (Màu sắc giày thể thao)
INSERT INTO MauSac (TenMauSac, TrangThai) VALUES
(N'Đen', 1),
(N'Trắng', 1),
(N'Đỏ', 1),
(N'Xanh dương', 1),
(N'Xanh lá', 1),
(N'Vàng', 1),
(N'Cam', 1),
(N'Xám', 1),
(N'Tím', 1),
(N'Hồng', 1);

-- Dữ liệu bảng ChatLieu (Chất liệu giày thể thao)
INSERT INTO ChatLieu (TenChatLieu, TrangThai) VALUES
(N'Vải lưới', 1),
(N'Da tổng hợp', 1),
(N'Vải cotton', 1),
(N'Da lộn', 1),
(N'Cao su', 1),
(N'PU Leather', 1),
(N'Canvas', 1),
(N'Nylon', 1),
(N'Polyester', 1),
(N'EVA Foam', 1);

-- Dữ liệu bảng DeGiay (Đế giày thể thao)
INSERT INTO DeGiay (TenDeGiay, TrangThai) VALUES
(N'Đế cao su non', 1),
(N'Đế PU Foam', 1),
(N'Đế Boost', 1),
(N'Đế EVA', 1),
(N'Đế Vibram', 1),
(N'Đế Flyknit', 1),
(N'Đế TPU', 1),
(N'Đế Carbon Fiber', 1),
(N'Đế Air Max', 1),
(N'Đế React', 1);

-- Dữ liệu bảng ThuongHieu (Thương hiệu giày thể thao)
INSERT INTO ThuongHieu (TenThuongHieu, TrangThai)
VALUES
(N'Nike', 1),
(N'Adidas', 1),
(N'Puma', 1),
(N'New Balance', 1),
(N'Reebok', 1),
(N'Asics', 1),
(N'Under Armour', 1),
(N'Saucony', 1),
(N'Mizuno', 1),
(N'Hoka One One', 1);

-- Dữ liệu bảng SanPham (Sản phẩm)
INSERT INTO SanPham (ID_ThuongHieu, ID_DanhMuc ,GioiTinh, TenSanPham, TrangThai) VALUES
(1, 1, 1, N'Nike Air Max 270', 1),
(2, 2, 1, N'Adidas Ultraboost 22', 1),
(3, 1, 1, N'Puma RS-X', 1),
(4, 2, 1, N'New Balance 574', 1),
(1, 1,1,  N'Nike Jordan 1', 1),
(2, 2, 1, N'Adidas NMD R1', 1),
(5, 3, 1, N'Asics Gel-Kayano 28', 1),
(6, 3, 2, N'Reebok Zig Kinetica', 1),
(7, 4, 2, N'Converse Chuck Taylor', 1),
(8, 4, 2, N'Vans Old Skool', 1),
(8, 4, 2, N'Thuong dinh', 1);

-- Dữ liệu bảng KichCo (Kích cỡ giày thể thao)
INSERT INTO KichCo (SoKichCo, TrangThai)
VALUES
(N'36', 1),
(N'37', 1),
(N'38', 1),
(N'39', 1),
(N'40', 1),
(N'41', 1),
(N'42', 1),
(N'43', 1),
(N'44', 1),
(N'45', 1);

-- Dữ liệu bảng KhuyenMai (Khuyến mãi)
INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, NgayBatDau, NgayKetThuc, MoTa, TrangThai)
VALUES
(N'KM01', N'Giảm giá 10%', '2024-01-01', '2024-01-31', N'Giảm giá 10% cho đơn hàng từ 1 triệu', 1),
(N'KM02', N'Giảm giá 15%', '2024-02-01', '2024-02-28', N'Giảm giá 15% cho giày Nike', 1),
(N'KM03', N'Giảm giá 20%', '2024-03-01', '2024-03-31', N'Giảm giá 20% cho giày Adidas', 1),
(N'KM04', N'Mua 1 tặng 1', '2024-04-01', '2024-04-30', N'Mua 1 tặng 1 cho giày Puma', 1),
(N'KM05', N'Giảm giá 25%', '2024-05-01', '2024-05-31', N'Giảm giá 25% cho đơn hàng từ 2 triệu', 1),
(N'KM06', N'Tặng Voucher', '2024-06-01', '2024-06-30', N'Tặng voucher cho khách hàng mới', 1),
(N'KM07', N'Giảm giá 5%', '2024-07-01', '2024-07-31', N'Giảm giá 5% cho đơn hàng bất kỳ', 1),
(N'KM08', N'Giảm giá 50%', '2024-08-01', '2024-08-31', N'Giảm giá 50% cho giày Under Armour', 1),
(N'KM09', N'Giảm giá 30%', '2024-09-01', '2024-09-30', N'Giảm giá 30% cho giày Reebok', 1),
(N'KM10', N'Miễn phí vận chuyển', '2024-10-01', '2024-10-31', N'Miễn phí vận chuyển cho đơn hàng trên 500k', 1);

-- Dữ liệu bảng Voucher
INSERT INTO Voucher (TenVoucher, GiaTri, TrangThai)
VALUES
(N'Voucher100K', '100000', 1),
(N'Voucher200K', '200000', 1),
(N'Voucher300K', '300000', 1),
(N'Voucher400K', '400000', 1),
(N'Voucher500K', '500000', 1),
(N'Voucher600K', '600000', 1),
(N'Voucher700K', '700000', 1),
(N'Voucher800K', '800000', 1),
(N'Voucher900K', '900000', 1),
(N'Voucher1M', '1000000', 1);

-- Dữ liệu bảng KhachHang (Khách hàng)
INSERT INTO KhachHang ( TenKhachHang, MatKhau, TenTaiKhoan, Email, SoDienThoai, DiaChi, NgaySinh, NgayTao, TrangThai)
VALUES
( N'Nguyen Van A', N'password123', N'nguyenvana', 'nguyenvana@example.com', '0912345678', N'Hà Nội', '1990-01-01', '2024-01-01', 1),
( N'Tran Thi B', N'password123', N'tranthib', 'tranthib@example.com', '0912345679', N'Hồ Chí Minh', '1992-02-02', '2024-02-01', 1),
( N'Le Van C', N'password123', N'levanc', 'levanc@example.com', '0912345680', N'Đà Nẵng', '1994-03-03', '2024-03-01', 1),
( N'Pham Thi D', N'password123', N'phamthid', 'phamthid@example.com', '0912345681', N'Cần Thơ', '1996-04-04', '2024-04-01', 1),
( N'Hoang Van E', N'password123', N'hoangvane', 'hoangvane@example.com', '0912345682', N'Nha Trang', '1998-05-05', '2024-05-01', 1),
( N'Vu Thi F', N'password123', N'vuthif', 'vuthif@example.com', '0912345683', N'Huế', '1991-06-06', '2024-06-01', 1),
( N'Nguyen Van G', N'password123', N'nguyenvang', 'nguyenvang@example.com', '0912345684', N'Quảng Ninh', '1993-07-07', '2024-07-01', 1),
( N'Tran Thi H', N'password123', N'tranthih', 'tranthih@example.com', '0912345685', N'Lâm Đồng', '1995-08-08', '2024-08-01', 1),
( N'Le Van I', N'password123', N'levani', 'levani@example.com', '0912345686', N'Quảng Bình', '1997-09-09', '2024-09-01', 1),
( N'Pham Thi K', N'password123', N'phamthik', 'phamthik@example.com', '0912345687', N'Hải Phòng', '1999-10-10', '2024-10-01', 1);

INSERT INTO NhanVien ( TenNhanVien, MatKhau, TenTaiKhoan, CCCD, Email, SoDienThoai, DiaChi, NgaySinh, NgayTuyenDung, NgayNghiViec, VaiTro, TrangThai)
VALUES 
-- Admin
( 'Nguyen Van Admin', 'admin123', 'admin', '012345678901', 'admin@example.com', '0909123456', '123 Nguyen Trai, Ha Noi', '1980-01-01', '2010-01-01', NULL, 0, 1),

-- Nhân viên
( 'Tran Thi B', 'password123', 'nv_b', '098765432109', 'tranthib@example.com', '0912345678', '456 Le Loi, TP HCM', '1992-07-20', '2019-05-01', NULL, 1, 1),
( 'Le Van C', 'matkhau456', 'nv_c', '123456789012', 'levanc@example.com', '0932123456', '789 Tran Phu, Da Nang', '1995-10-10', '2021-03-01', NULL, 1, 1),
( 'Nguyen Thi D', 'pass789', 'nv_d', '234567890123', 'nguyenthid@example.com', '0922345678', '12 Ly Thuong Kiet, Ha Noi', '1988-11-15', '2018-08-01', NULL, 1, 1),
( 'Pham Van E', 'mk123456', 'nv_e', '345678901234', 'phamvane@example.com', '0945123456', '23 Phan Chu Trinh, HCM', '1990-03-10', '2020-02-15', NULL, 1, 1),
( 'Do Thi F', 'mypass789', 'nv_f', '456789012345', 'dothif@example.com', '0912123123', '789 Cach Mang Thang Tam, HCM', '1993-05-25', '2022-07-01', NULL, 1, 1),
( 'Hoang Van G', 'pass999', 'nv_g', '567890123456', 'hoangvang@example.com', '0987897890', '456 Ngo Gia Tu, Ha Noi', '1985-09-09', '2017-12-20', NULL, 1, 1),
( 'Nguyen Van H', 'password111', 'nv_h', '678901234567', 'nguyenvanh@example.com', '0901234567', '15 Bach Mai, Ha Noi', '1989-06-30', '2019-11-11', NULL, 1, 1),
( 'Le Thi I', 'lethi333', 'nv_i', '789012345678', 'lethii@example.com', '0949988776', '98 Hai Ba Trung, Da Nang', '1991-12-05', '2020-03-15', NULL, 1, 1),
( 'Tran Van J', 'pass444', 'nv_j', '890123456789', 'tranvanj@example.com', '0933001122', '17 Dinh Tien Hoang, Ha Noi', '1994-04-20', '2021-06-10', NULL, 1, 1);

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
(1, 1, 1, '1', '1', '30000', '2024-10-30', NULL, '2024-11-02', '123 Đường A, Quận 1', '4800000', 'Đơn hàng thanh toán online', 2),
(2, NULL, 2, '1', '1', NULL, '2024-10-28', NULL, '2024-10-28', NULL, '6000000', 'Mua trực tiếp', 2),
(3, 2, 3, '2', '1', '50000', '2024-10-27', '2024-10-29', NULL, '456 Đường B, Quận 2', '5300000', 'Đơn hàng bị hoàn trả', 3),
(1, NULL, 4, '1', '1', '40000', '2024-10-25', NULL, '2024-10-27', '789 Đường C, Quận 3', '3200000', 'Đơn hàng giao nhanh', 2),
(2, 3, 5, '2', '1', NULL, '2024-10-24', NULL, '2024-10-24', NULL, '3500000', 'Mua trực tiếp', 2),
(3, NULL, 6, '2', '1', '30000', '2024-10-20', NULL, '2024-10-23', '102 Đường D, Quận 4', '2900000', 'Đã giao hàng', 2),
(4, 4, 7, '1', '2', '45000', '2024-10-18', NULL, '2024-10-21', '150 Đường E, Quận 5', '4200000', 'Giao hàng nhanh', 2),
(1, NULL, 8, '2', '2', NULL, '2024-10-15', '2024-10-16', NULL, '50 Đường G, Quận 6', '5100000', 'Bị hoàn trả', 3),
(5, NULL, 9, '1', '2', NULL, '2024-10-10', NULL, '2024-10-10', NULL, '2200000', 'Mua trực tiếp', 2),
(3, 5, 10, '2', '2', '35000', '2024-10-05', NULL, '2024-10-07', '200 Đường H, Quận 7', '2700000', 'Thanh toán thành công', 2);


INSERT INTO ChiTietSanPham (ID_SanPham, ID_NhanVien, ID_KichCo, ID_MauSac, ID_DeGiay, ID_ChatLieu,TenChiTietSanPham, GiaBan,  SoLuong, MoTa, NgayTao, TrangThai) 
VALUES
(1, 1, 1, 1, 1, 1,  'Nike Air Max 270 - Đen', 4500000, 50, 'Giày thể thao êm ái cho chạy bộ', '2024-10-30', 1),
(1, 2, 2, 2, 1, 1,  'Nike Air Max 270 - Trắng', 9000000,  30, 'Giày thể thao phong cách', '2024-10-30', 1),
(2, 3, 1, 3, 2, 2,  'Adidas Ultraboost 22 - Đỏ', 5200000,  40, 'Giày chạy bộ chuyên nghiệp', '2024-10-30', 1),
(3, 1, 3, 4, 3, 2, 'Puma RS-X - Xanh dương', 3500000, 25, 'Giày thời trang thể thao', '2024-10-30', 1),
(4, 2, 4, 5, 2, 3,  'New Balance 574 - Xanh lá', 3200000, 20, 'Thiết kế cổ điển', '2024-10-30', 1),
(5, 3, 5, 6, 4, 3,  'Nike Jordan 1 - Vàng', 6000000,  15, 'Giày bóng rổ huyền thoại', '2024-10-30', 1),
(6, 4, 3, 7, 5, 4,  'Adidas NMD R1 - Cam', 49000, 35, 'Giày công nghệ Boost', '2024-10-30', 1),
(7, 1, 6, 8, 6, 4,  'Asics Gel-Kayano 28 - Xám', 3800000,  45, 'Hỗ trợ chân tối đa', '2024-10-30', 1),
(8, 2, 4, 9, 7, 5,  'Reebok Zig Kinetica - Tím', 3300000,  30, 'Công nghệ đế Zig', '2024-10-30', 1),
(9, 3, 5, 10, 8, 5, 'Converse Chuck Taylor - Hồng', 2500000, 60, 'Giày vải cổ cao', '2024-10-30', 1);


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

