app.controller("AccountController", function ($scope, $http) {
    $scope.message = "Welcome to AccountController!";
$scope.form= null
    const apiBaseUrl = "http://localhost:8080/api/user/"
    $scope.signin = function () {
        // Gửi yêu cầu POST đến API
        $http.post(apiBaseUrl + "authenticate", $scope.form)
            .then(function (response) {
                console.log("Signin successful", response.data);
                alert("Đăng nhập thành công!");
                // Xử lý token hoặc điều hướng sau khi đăng nhập
                const token = response.data.succes; // Nhận token từ server
                localStorage.setItem("token", token); // Lưu token vào localStorage
            })
            .catch(function (error) {
                console.error("Signin error", error);
                alert("Đăng nhập thất bại! Vui lòng kiểm tra thông tin.");
            });
    
    }
    $scope.signup = function () {
        if($scope.form===null){
            console.log("t met lam r")
            return
        }
        $http.post(apiBaseUrl + "register", $scope.form)
            .then(function (response) {
                console.log("Sign-up successful:", response.data);               
                alert("Đăng kí thành công !")
            })
            .catch(function (error) {
                console.error("Sign-up failed:", error);
                alert("Đăng kí thất bại, vui lòng kiểm tra lại")

            });

    }
    $scope.logout = function () {
        $http.post(apiBaseUrl + "logout")
            .then(function (response) {
                console.log("Logged out:", response.data);
                $scope.message = "You have logged out!";
            })
            .catch(function (error) {
                console.error("Logout failed:", error);
                $scope.message = "Logout failed!";
            });
    };
    
});