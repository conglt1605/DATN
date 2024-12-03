var app = angular.module("myApp", []);

app.controller("SizeController", function ($scope, $http) {
  // Lấy danh sách kích cỡ từ API
  $scope.getAllSizes = function () {
    $http({
      method: "GET",
      url: "http://localhost:8080/api/size/all",
    })
      .then(function (response) {
        if (response.data) {
          $scope.sizes = response.data.Success;
          console.log($scope.sizes);
        } else {
          toastr.error("Không có dữ liệu kích cỡ", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách kích cỡ", "Thông báo");
      });
  };

  // Thêm kích cỡ mới
  $scope.addSize = function () {
    if (!$scope.newSize || !$scope.newSize.sizeNumber) {
      toastr.error("Vui lòng nhập kích cỡ", "Thông báo");
      return;
    }

    var newSize = {
      sizeNumber: $scope.newSize.sizeNumber,
      status: 1,
    };

    $http({
      method: "POST",
      url: "http://localhost:8080/api/size/add",
      data: newSize,
    }).then(
      function () {
        toastr.success("Kích cỡ đã được thêm thành công", "Thông báo");
        $scope.getAllSizes();
        $("#addModal").modal("hide");
        $scope.newSize = {}; // Reset dữ liệu đầu vào
      },
      function () {
        toastr.error("Lỗi khi thêm kích cỡ", "Thông báo");
      }
    );
  };

  // Cập nhật kích cỡ
  $scope.updateSize = function (size) {
    if (!size.sizeNumber) {
      toastr.error("Vui lòng nhập kích cỡ", "Thông báo");
      return;
    }

    $http({
      method: "PUT",
      url: "http://localhost:8080/api/size/update/" + size.id,
      data: size,
    }).then(
      function () {
        toastr.success("Kích cỡ đã được cập nhật", "Thông báo");
        $scope.getAllSizes();
        size.isEditing = false; // Tắt chế độ chỉnh sửa
      },
      function () {
        toastr.error("Lỗi khi cập nhật kích cỡ", "Thông báo");
      }
    );
  };

  // Xóa kích cỡ
  $scope.deleteSize = function (id) {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/size/delete/" + id,
    }).then(
      function () {
        toastr.success("Kích cỡ đã được xóa", "Thông báo");
        $scope.getAllSizes();
      },
      function () {
        toastr.error("Lỗi khi xóa kích cỡ", "Thông báo");
      }
    );
  };

  // Bật/Tắt chế độ chỉnh sửa
  $scope.toggleEdit = function (size) {
    size.isEditing = !size.isEditing;
    if (!size.isEditing) {
      $scope.updateSize(size);
    }
  };

  // Hủy chỉnh sửa
  $scope.cancelEdit = function (size) {
    size.isEditing = false;
    // Bạn có thể tải lại dữ liệu gốc nếu cần
  };

  // Khởi tạo - Gọi API khi trang được tải
  $scope.getAllSizes();
});
