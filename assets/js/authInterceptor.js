// authInterceptor.js
app.factory("AuthInterceptor", function ($q, $window) {
  return {
    request: function (config) {
      const token = $window.localStorage.getItem("jwt");
      const protectedUrls = [
        "http://localhost:8080/api/invoice/saveWithDetails",
        "http://localhost:8080/api/category/active",
        // Các URL bảo vệ khác
      ];

      // Kiểm tra nếu có token và URL là yêu cầu bảo vệ
      if (token && protectedUrls.some((url) => config.url.includes(url))) {
        config.headers["Authorization"] = "Bearer " + token;
      }
      return config;
    },
  };
});

// Đăng ký interceptor
app.config(function ($httpProvider) {
  $httpProvider.interceptors.push("AuthInterceptor");
});
