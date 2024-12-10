var app = angular.module("myApp", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider, $httpProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "views/home.html",
            // controller: "ProductController",
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
        .when("/account", {
            templateUrl: "views/account.html",
            controller: "AccountController",
            resolve: {
                // Kiểm tra xác thực trước khi vào trang account
                checkAuth: function($q, $window, $location) {
                    const token = $window.localStorage.getItem("token");
                    if (!token) {
                        // Nếu không có token, chuyển hướng về trang đăng nhập
                        $location.path("/signin");
                        return $q.reject("Not authenticated");
                    }
                    return $q.resolve();
                },
            },
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

app.factory("AuthInterceptor", function($q, $window) {
    return {
        request: function(config) {
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
                "http://localhost:8080/api/invoice/invoiceWithUser",
                "http://localhost:8080/api/invoice/invoiceWithDetail",
            ];

            if (token && protectedUrls.some((url) => config.url.includes(url))) {
                config.headers["Authorization"] = "Bearer " + token;
            }
            return config;
        },
    };
});