var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider, $httpProvider) {
  $routeProvider
    .when("/thuonghieu", {
      templateUrl: "html/thuonghieu.html",
      controller: "BrandController",
    })
    .when("/addChiTietSanPham", {
      templateUrl: "html/addChiTietSanPham.html",
      controller: "chiTietSanPhamController",
    })
    .when("/banhang", {
      templateUrl: "html/banhang.html",
      controller: "ProductController",
    })

    .when("/chatlieu", {
      templateUrl: "html/chatlieu.html",
      controller: "MaterialController",
    })
    .when("/chitietdonhang", {
      templateUrl: "html/chitietdonhang.html",
      controller: "chiTietDonHangController",
    })
    .when("/chitietsanpham", {
      templateUrl: "html/chitietsanpham.html",
      controller: "chiTietSanPhamController",
    })
    .when("/danhmuc", {
      templateUrl: "html/danhmuc.html",
      controller: "CategoryController",
    })
    .when("/donhang", {
      templateUrl: "html/donhang.html",
      controller: "HoaDonController",
    })
    .when("/kichco", {
      templateUrl: "html/kichco.html",
      controller: "SizeController",
    })
    .when("/Login", {
      templateUrl: "html/Login.html",
      controller: "LoginController",
    })
    .when("/mausac", {
      templateUrl: "html/mausac.html",
      controller: "ColorController",
    })
    .when("/nhanvien", {
      templateUrl: "html/nhanvien.html",
      controller: "UserController",
    })
    .when("/sanpham", {
      templateUrl: "html/sanpham.html",
      controller: "ProductController",
    })
    .when("/voucher", {
      templateUrl: "html/voucher.html",
      controller: "VoucherController",
    })
    .otherwise({
      redirectTo: "/thuonghieu",
    });
  $locationProvider.html5Mode(true);
  $httpProvider.interceptors.push("AuthInterceptor");
});
