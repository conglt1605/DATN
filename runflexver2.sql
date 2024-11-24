
-- Bảng Danh Mục (Category)
-- Lưu trữ thông tin về các danh mục sản phẩm (Ví dụ: Giày, Quần áo, Phụ kiện)
CREATE TABLE Category (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID danh mục
    CategoryName NVARCHAR(255) NULL, -- Tên danh mục
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Thương Hiệu (Brand)
-- Lưu trữ thông tin về các thương hiệu sản phẩm (Ví dụ: Nike, Adidas)
CREATE TABLE Brand (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID thương hiệu
    BrandName NVARCHAR(255) NULL, -- Tên thương hiệu
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Màu Sắc (Color)
-- Lưu trữ thông tin về màu sắc sản phẩm (Ví dụ: Đỏ, Xanh, Trắng)
CREATE TABLE Color (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID màu sắc
    ColorName NVARCHAR(255) NULL, -- Tên màu sắc
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Chất Liệu (Material)
-- Lưu trữ thông tin về chất liệu sản phẩm (Ví dụ: Da, Vải, Nhựa)
CREATE TABLE Material (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID chất liệu
    MaterialName NVARCHAR(255) NULL, -- Tên chất liệu
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Đối Tượng Sử Dụng (UsageObject)
-- Lưu trữ thông tin về đối tượng sử dụng sản phẩm (Ví dụ: Nam, Nữ, Unisex)
CREATE TABLE UsageObject (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID đối tượng sử dụng
    UsageObjectName NVARCHAR(255) NULL, -- Tên đối tượng sử dụng
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Sản Phẩm (Product)
-- Lưu trữ thông tin sản phẩm (Ví dụ: Tên sản phẩm, Mã sản phẩm, Thương hiệu, Danh mục)
CREATE TABLE Product (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID sản phẩm
    BrandID INT NULL, -- ID thương hiệu (liên kết với bảng Brand)
    CategoryID INT NULL, -- ID danh mục (liên kết với bảng Category)
    UsageObjectID INT NULL, -- ID đối tượng sử dụng (liên kết với bảng UsageObject)
    ProductCode VARCHAR(20) NULL, -- Mã sản phẩm
    ProductName NVARCHAR(255) NULL, -- Tên sản phẩm
    ImageURL VARCHAR(100) NULL, -- URL ảnh sản phẩm
    Status INT NULL -- Trạng thái: 1: Đang bán, 2: Tạm ngừng
);

-- Bảng Kích Cỡ (Size)
-- Lưu trữ thông tin về kích cỡ sản phẩm (Ví dụ: 40, 41, 42)
CREATE TABLE Size (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID kích cỡ
    SizeNumber INT NULL, -- Số kích cỡ (Ví dụ: 40, 41, 42)
    Status INT NULL -- Trạng thái: 1: Có sẵn, 2: Hết hàng
);

-- Bảng Voucher
-- Lưu trữ thông tin về các voucher giảm giá
CREATE TABLE Voucher (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID voucher
    VoucherCode NVARCHAR(255) NULL, -- Mã voucher
    VoucherName NVARCHAR(255) NULL, -- Tên voucher
    MaxAmount DECIMAL(18, 2) NULL, -- Số tiền tối đa voucher có thể giảm
    UsageLimit INT NULL, -- Số lần sử dụng voucher
    StartDate DATE NULL, -- Ngày bắt đầu áp dụng voucher
    EndDate DATE NULL, -- Ngày kết thúc áp dụng voucher
    DiscountPercentage DECIMAL(18, 2) NULL, -- Phần trăm giảm giá
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Hết hạn
);

-- Bảng Vai Trò (Role)
-- Lưu trữ thông tin về các vai trò người dùng trong hệ thống (Ví dụ: Admin, Customer)
CREATE TABLE Role (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID vai trò
    RoleName NVARCHAR(50) NULL, -- Tên vai trò
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Tạm ngừng
);

-- Bảng Người Dùng (User)
-- Lưu trữ thông tin người dùng trong hệ thống
CREATE TABLE User (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID người dùng
    RoleID INT NULL, -- ID vai trò người dùng (liên kết với bảng Role)
    UserName VARCHAR(20) NULL, -- Tên người dùng
    Password VARCHAR(255) NULL, -- Mật khẩu
    FullName NVARCHAR(255) NULL, -- Tên đầy đủ người dùng
    Email VARCHAR(255) NULL, -- Địa chỉ email
    PhoneNumber VARCHAR(10) NULL, -- Số điện thoại
    Address NVARCHAR(255) NULL, -- Địa chỉ
    Status INT NULL -- Trạng thái: 1: Đang hoạt động, 2: Vô hiệu hóa, 0: Đã xóa
);

-- Bảng Hóa Đơn (Invoice)
-- Lưu trữ thông tin về các hóa đơn của khách hàng
CREATE TABLE Invoice (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID hóa đơn
    VoucherID INT NULL, -- ID voucher áp dụng (liên kết với bảng Voucher)
    InvoiceCode VARCHAR(50) NULL, -- Mã hóa đơn
    PaymentMethod INT NULL, -- Phương thức thanh toán (Ví dụ: Thanh toán online, tiền mặt)
    PhoneNumber VARCHAR(50) NULL, -- Số điện thoại của khách hàng
    CreatedDate DATE NULL, -- Ngày tạo hóa đơn
    DeliveryAddress NVARCHAR(255) NULL, -- Địa chỉ giao hàng
    TotalAmount DECIMAL(18, 2) NULL, -- Tổng giá trị hóa đơn
    Description NVARCHAR(255) NULL, -- Mô tả hóa đơn
    Status INT NULL -- Trạng thái: 1: Đang xử lý, 2: Đã giao, 3: Đã hủy
);

-- Bảng Chi Tiết Sản Phẩm (ProductDetail)
-- Lưu trữ chi tiết các sản phẩm (kích cỡ, màu sắc, chất liệu, v.v.)
CREATE TABLE ProductDetail (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID chi tiết sản phẩm
    ProductID INT NULL, -- ID sản phẩm (liên kết với bảng Product)
    SizeID INT NULL, -- ID kích cỡ (liên kết với bảng Size)
    ColorID INT NULL, -- ID màu sắc (liên kết với bảng Color)
    MaterialID INT NULL, -- ID chất liệu (liên kết với bảng Material)
    ProductDetailCode VARCHAR(50) NULL, -- Mã chi tiết sản phẩm
    ProductDetailName VARCHAR(255) NULL, -- Tên chi tiết sản phẩm
    ImageURL VARCHAR(100) NULL, -- URL ảnh chi tiết sản phẩm
    Price DECIMAL(18, 2) NULL, -- Giá chi tiết sản phẩm
    Quantity INT NULL, -- Số lượng chi tiết sản phẩm
    Description NVARCHAR(255) NULL, -- Mô tả chi tiết sản phẩm
    Status INT NULL -- Trạng thái: 1: Đang bán, 2: Tạm ngừng
);

-- Bảng Chi Tiết Hóa Đơn (InvoiceDetail)
-- Lưu trữ thông tin chi tiết về các sản phẩm trong mỗi hóa đơn
CREATE TABLE InvoiceDetail (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID chi tiết hóa đơn
    InvoiceID INT NULL, -- ID hóa đơn (liên kết với bảng Invoice)
    ProductDetailID INT NULL, -- ID chi tiết sản phẩm (liên kết với bảng ProductDetail)
    Quantity INT NULL, -- Số lượng sản phẩm
    CurrentPrice DECIMAL(18, 2) NULL, -- Giá hiện tại sản phẩm
    TotalPrice DECIMAL(18, 2) NULL, -- Tổng giá sản phẩm trong hóa đơn
    Status INT NULL -- Trạng thái: 1: Đã giao, 2: Đang xử lý
);

-- Bảng Người Dùng - Hóa Đơn (InvoiceUser)
-- Lưu trữ thông tin người dùng liên quan đến hóa đơn
CREATE TABLE InvoiceUser (
    ID INT PRIMARY KEY AUTO_INCREMENT, -- ID bản ghi
    InvoiceID INT NULL, -- ID hóa đơn (liên kết với bảng Invoice)
    UserID INT NULL, -- ID người dùng (liên kết với bảng User)
    Status INT NULL -- Trạng thái: 1: Đang xử
);
-- Dữ liệu cho bảng Category
INSERT INTO Category (CategoryName, Status)
VALUES
('Shoes', 1),
('Clothing', 1),
('Accessories', 1);

-- Dữ liệu cho bảng Brand
INSERT INTO Brand (BrandName, Status)
VALUES
('Nike', 1),
('Adidas', 1),
('Puma', 1),
('Reebok', 1);

-- Dữ liệu cho bảng Color
INSERT INTO Color (ColorName, Status)
VALUES
('Red', 1),
('Blue', 1),
('Black', 1),
('White', 1);

-- Dữ liệu cho bảng Material
INSERT INTO Material (MaterialName, Status)
VALUES
('Leather', 1),
('Cotton', 1),
('Nylon', 1),
('Polyester', 1);

-- Dữ liệu cho bảng UsageObject
INSERT INTO UsageObject (UsageObjectName, Status)
VALUES
('Men', 1),
('Women', 1),
('Unisex', 1);

-- Dữ liệu cho bảng Product
INSERT INTO Product (BrandID, CategoryID, UsageObjectID, ProductCode, ProductName, ImageURL, Status)
VALUES
(1, 1, 1, 'SP001', 'Air Max 2023', 'air_max.jpg', 1),
(2, 1, 2, 'SP002', 'Adidas Ultraboost', 'ultraboost.jpg', 1),
(3, 1, 3, 'SP003', 'Puma Running Shoes', 'puma_shoes.jpg', 1),
(4, 2, 1, 'SP004', 'Reebok Workout T-Shirt', 'reebok_tshirt.jpg', 1);

-- Dữ liệu cho bảng Size
INSERT INTO Size (SizeNumber, Status)
VALUES
(40, 1),
(41, 1),
(42, 1),
(43, 1);

-- Dữ liệu cho bảng Voucher
INSERT INTO Voucher (VoucherCode, VoucherName, MaxAmount, UsageLimit, StartDate, EndDate, DiscountPercentage, Status)
VALUES
('VOUCHER10', '10% Discount on All Products', 100000, 500, '2024-01-01', '2024-12-31', 10.00, 1),
('VOUCHER20', '20% Discount on Sports Shoes', 200000, 300, '2024-02-01', '2024-06-30', 20.00, 1);

-- Dữ liệu cho bảng Role
INSERT INTO Role (RoleName, Status)
VALUES
('Admin', 1),
('Customer', 1),
('Manager', 1);

-- Dữ liệu cho bảng User
INSERT INTO User (RoleID, UserName, Password, FullName, Email, PhoneNumber, Address, Status)
VALUES
(1, 'admin1', 'admin1234',  'John Doe', 'john.doe@example.com', '0987654321', '123 Admin St.', 1),
(2, 'jane_doe', 'jane1234',  'Jane Doe', 'jane.doe@example.com', '0987654322', '456 Customer St.', 1),
(3, 'mike_smith', 'mike1234', 'Mike Smith', 'mike.smith@example.com', '0987654323', '789 Manager St.', 1);

-- Dữ liệu cho bảng Invoice
INSERT INTO Invoice (VoucherID, InvoiceCode, PaymentMethod, PhoneNumber, CreatedDate, DeliveryAddress, TotalAmount, Description, Status)
VALUES
(1, 'INV001', 1, '0987654321', '2024-01-01', '123 Customer St.', 150000, 'Discount applied', 1),
(2, 'INV002', 2, '0987654322', '2024-02-01', '456 Customer St.', 200000, 'Seasonal Sale', 1);

-- Dữ liệu cho bảng ProductDetail
INSERT INTO ProductDetail (ProductID, SizeID, ColorID, MaterialID, ProductDetailCode, ProductDetailName, Price, Quantity, Description, Status)
VALUES
(1, 1, 1, 1, 'PD001', 'Air Max 2023 - Red - 40', 1500000, 100, 'Comfortable running shoes', 1),
(1, 2, 2, 2, 'PD002', 'Air Max 2023 - Blue - 41', 1550000, 80, 'Stylish for everyday wear', 1),
(2, 3, 3, 3, 'PD003', 'Adidas Ultraboost - Black - 42', 1700000, 150, 'Ultimate comfort for sports', 1),
(3, 4, 4, 4, 'PD004', 'Puma Running Shoes - White - 43', 1400000, 120, 'Perfect for running', 1);

-- Dữ liệu cho bảng InvoiceDetail
INSERT INTO InvoiceDetail (InvoiceID, ProductDetailID, Quantity, CurrentPrice, TotalPrice, Status)
VALUES
(1, 1, 2, 1500000, 3000000, 1),
(1, 3, 1, 1700000, 1700000, 1),
(2, 2, 3, 1550000, 4650000, 1),
(2, 4, 1, 1400000, 1400000, 1);

-- Dữ liệu cho bảng InvoiceUser
INSERT INTO InvoiceUser (InvoiceID, UserID, Status)
VALUES
(1, 2, 1),
(2, 1, 1);
