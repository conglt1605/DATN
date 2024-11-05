// Tạo module AngularJS mới tên là myApp
var app = angular.module("myApp", []);

app.controller("MainController", function($scope, $http) {
    // GET: lấy dữ liệu từ API và lưu vào $scope.nhanViens
    $http.get("http://localhost:8080/chitietsanpham").then(
        function(response) {
            $scope.chiTietSanPhams = response.data;
        },
        function(error) {
            console.error("Lỗi khi lấy dữ liệu:", error);
        }
    );

    $http.get("http://localhost:8080/nhanvien/quanly").then(
        function(response) {
            $scope.quanLys = response.data;
        },
        function(error) {
            console.error("Lỗi khi lấy dữ liệu:", error);
        }
    );

    $scope.nhanVien = {
        id: null,
        ma: "",
        ten: "",
    };

    // POST: Thêm mới nhân viên
    $scope.submitData = function() {
        $http.post("http://localhost:8080/nhanvien", $scope.nhanVien).then(
            function(response) {
                console.log("Tạo thành công");
                $scope.nhanViens.push(response.data); // Cập nhật danh sách
                $scope.resetForm(); // Reset form sau khi thêm mới
            },
            function(error) {
                console.error("Lỗi khi tạo:", error);
            }
        );
    };

    // PUT: Cập nhật nhân viên
    $scope.updateData = function() {
        if ($scope.nhanVien.id) {
            $http
                .put(
                    `http://localhost:8080/nhanvien/${$scope.nhanVien.id}`,
                    $scope.nhanVien
                )
                .then(
                    function(response) {
                        console.log("Sửa thành công");
                        $scope.loadData(); // Reload danh sách nhân viên sau khi cập nhật
                    },
                    function(error) {
                        console.error("Lỗi khi cập nhật:", error);
                    }
                );
        }
    };

    // DELETE: Xóa nhân viên
    $scope.deleteData = function(id) {
        $http.delete(`http://localhost:8080/nhanvien/${id}`).then(
            function(response) {
                console.log("Xóa thành công");
                $scope.loadData(); // Reload danh sách nhân viên sau khi xóa
            },
            function(error) {
                console.error("Lỗi khi xóa:", error);
            }
        );
    };

    // Lấy dữ liệu nhân viên để cập nhật
    $scope.editData = function(nhanVien) {
        $scope.nhanVien = angular.copy(nhanVien);
    };

    // Load lại dữ liệu nhân viên
    $scope.loadData = function() {
        $http.get("http://localhost:8080/nhanvien").then(
            function(response) {
                $scope.nhanViens = response.data;
            },
            function(error) {
                console.error("Lỗi khi lấy dữ liệu:", error);
            }
        );
    };

    // Reset form
    $scope.resetForm = function() {
        $scope.nhanVien = {
            id: null,
            ma: "",
            ten: "",
        };
    };
});