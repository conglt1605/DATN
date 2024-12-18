var app = angular.module("myApp", []);

app.controller("UserController", function ($scope, $http) {
  $scope.isEditing = false; // Quản lý việc hiển thị modal

  // Tải dữ liệu người dùng
  $scope.loadData = function () {
    $http.get("http://localhost:8080/api/user/all").then(
      function (response) {
        $scope.users = response.data.Success;
        console.log($scope.users);
      },
      function (error) {
        console.error("Lỗi khi tải dữ liệu:", error);
        toastr.error("Không thể tải dữ liệu.");
      }
    );
    $http.get("http://localhost:8080/api/role/all").then(
      function (response) {
        $scope.roles = response.data.Success;
        console.log($scope.roles);
      },
      function (error) {
        console.error("Lỗi khi tải dữ liệu:", error);
        toastr.error("Không thể tải dữ liệu.");
      }
    );
  };

  $scope.editVoucher = function (voucher) {
    // Sao chép dữ liệu voucher hiện tại vào form để chỉnh sửa
    $scope.voucher = angular.copy(voucher);

    // Kiểm tra sau khi định dạng lại ngày
    console.log("Formatted startDate:", $scope.voucher.startDate);
    console.log("Formatted endDate:", $scope.voucher.endDate);

    $scope.isEditing = true;
    $("#addModal").modal("show"); // Mở modal chỉnh sửa
  };

  $scope.cancelEdit = function () {
    $scope.resetForm();
    $scope.isEditing = false;
    $("#addModal").modal("hide");
  };

  // Lưu dữ liệu khi thêm mới hoặc sửa
  $scope.submitData = function () {
    if ($scope.editMode) {
      // Nếu đang ở chế độ sửa, gọi API để cập nhật
      $http.put("http://localhost:8080/api/user/update", $scope.formData).then(
        function (response) {
          toastr.success("Cập nhật thành công!");
          $scope.loadData(); // Tải lại danh sách người dùng
          $scope.closeModal();
        },
        function (error) {
          toastr.error("Lỗi khi cập nhật.");
          console.error(error);
        }
      );
    } else {
      // Nếu đang ở chế độ thêm mới, gọi API để thêm
      $http.post("http://localhost:8080/api/user/save", $scope.formData).then(
        function (response) {
          toastr.success("Thêm mới thành công!");
          $scope.loadData(); // Tải lại danh sách người dùng
          $scope.closeModal();
        },
        function (error) {
          toastr.error("Lỗi khi thêm mới.");
          console.error(error);
        }
      );
    }
  };

  // Xóa người dùng
  $scope.deleteUser = function (userId) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
      $http.delete("http://localhost:8080/api/user/delete/" + userId).then(
        function (response) {
          toastr.success("Xóa thành công!");
          $scope.loadData(); // Tải lại danh sách người dùng
        },
        function (error) {
          toastr.error("Lỗi khi xóa.");
          console.error(error);
        }
      );
    }
  };

  // Tải dữ liệu khi trang được tải
  $scope.loadData();
});
