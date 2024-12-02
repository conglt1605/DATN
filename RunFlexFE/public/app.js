var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider) {
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
    .when("/login", {
      templateUrl: "views/signup.html",
      // controller: "ProductController",
    })
    .when("/signin", {
      templateUrl: "views/signin.html",
      // controller: "ProductController",
    })
    .when("/cart", {
      templateUrl: "views/cart.html",
      controller: "CartController",
    })
    .when("/pay", {
      templateUrl: "views/pay.html",
      controller: "CartController",
    })
    .when("/demo", {
      templateUrl: "views/demoUploadAnh.html",
      controller: "ImageUploadController",
    })
    .otherwise({
      redirectTo: "/home",
    });
  $locationProvider.html5Mode(true);
});
