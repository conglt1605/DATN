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
      // controller: "AccountController",
    })
    .otherwise({
      redirectTo: "/home",
    });
  $locationProvider.html5Mode(true);
});
