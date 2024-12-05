var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider, $httpProvider) {
  $routeProvider
    .when("/home", {
      templateUrl: "views/home.html",
      controller: "HomeController",
    })
    .when("/detail", {
      templateUrl: "views/detailproduct.html",
      controller: "ProductDetailController",
    })
    .when("/products", {
      templateUrl: "views/product.html",
      controller: "ProductController",
    })

    .when("/signup", {
      templateUrl: "views/signup.html",
      controller: "AccountController",
    })
    .when("/signin", {
      templateUrl: "views/signin.html",
      controller: "AccountController",
    })
    .when("/cart", {
      templateUrl: "views/cart.html",
      controller: "CartController",
    })
    .when("/pay", {
      templateUrl: "views/pay.html",
      controller: "CartController",
    })
    .when("/myOder", {
      templateUrl: "views/myOder.html",
      // controller: "CartController",
    })
    .when("/demo", {
      templateUrl: "views/demoUploadAnh.html",
      controller: "ImageUploadController",
    })
    .otherwise({
      redirectTo: "/home",
    });
  $locationProvider.html5Mode(true);
  $httpProvider.interceptors.push("AuthInterceptor");
});

app.factory("AuthInterceptor", function ($q, $window) {
  return {
    request: function (config) {
      const token = $window.localStorage.getItem("token");
      const protectedUrls = [
        "http://localhost:8080/api/invoice/saveWithDetails",
        "http://localhost:8080/api/category/active",
        "http://localhost:8080/api/usageobject/active",
        "http://localhost:8080/api/size/active",
        "http://localhost:8080/api/brand/active",
        "http://localhost:8080/api/product/page",
        "http://localhost:8080/api/productdetail/getColorByProductID",
        "http://localhost:8080/api/productdetail/getSizeByProductID",
        "http://localhost:8080/api/productdetail/getMaterialByProductID",
        "http://localhost:8080/api/productdetail/getProducDetail",
      ];

      if (token && protectedUrls.some((url) => config.url.includes(url))) {
        config.headers["Authorization"] = "Bearer " + token;
      }
      return config;
    },
  };
});
