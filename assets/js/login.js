var app = angular.module("myApp", []);
app.controller("LoginController", function ($scope, $http, $window) {
  $scope.username = "";
  $scope.password = "";
  $scope.fullName = "";
  $scope.email = "";
  // Hàm đăng nhập
  $scope.login = function () {
    var data = {
      userName: $scope.username,
      password: $scope.password,
    };

    $http.post("http://localhost:8080/api/user/authenticate", data).then(
      function (response) {
        // Giả sử token trả về từ server nằm trong response.data.token
        var token = response.data.token;

        // Lưu token vào localStorage
        localStorage.setItem("jwt", token);

        // Thông báo đăng nhập thành công
        toastr.success("Đăng nhập thành công", "Thông báo");

        // Đợi 2 giây trước khi điều hướng sau khi đăng nhập thành công
        setTimeout(function () {
          $window.location.href = "../index.html"; // Điều hướng trang chính
        }, 2000); // 2000ms = 2 giây
      },
      function (error) {
        if (error.status === 401) {
          toastr.error("Sai thông tin tài khoản hoặc mật khẩu", "Thông báo");
        } else {
          toastr.error("Đã xảy ra lỗi. Vui lòng thử lại sau!", "Thông báo");
        }
      }
    );
  };

  // // Hàm đăng ký
  // $scope.register = function () {
  //   var data = {
  //     userName: $scope.username,
  //     password: $scope.password,
  //     fullName: $scope.fullName,
  //     email: $scope.email,
  //   };

  //   $http.post("http://localhost:8080/api/user/register", data).then(
  //     function (response) {
  //       toastr.success("Tài Khoản Đã Được Tạo!", "Thông báo");
  //       $window.location.href = "login.html"; // Điều hướng sau khi đăng ký thành công
  //     },
  //     function (error) {
  //       console.error("Error response:", error); // Log the full error object for debugging

  //       if (error.status === 400) {
  //         // Ensure that error.data is structured as expected
  //         console.log("Error message:", error.data); // Check the structure of the response data

  //         // Access the correct error message, assuming 'error' field contains the message
  //         var errorMessage =
  //           error.data.error || "Đã xảy ra lỗi. Vui lòng thử lại sau!";
  //         toastr.error(errorMessage, "Thông báo");
  //       }
  //     }
  //   );
  // };
});
