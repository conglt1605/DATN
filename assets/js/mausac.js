var app = angular.module("myApp", []);

app.controller("ColorController", function ($scope, $http) {
  var token = localStorage.getItem("jwt");

  // Lấy danh sách màu sắc từ API
  $scope.getAllColors = function () {
    $http({
      method: "GET",
      url: "http://localhost:8080/api/color/all",
      headers: { Authorization: "Bearer " + token },
    })
      .then(function (response) {
        if (response.data && response.data.Success) {
          $scope.colors = response.data.Success;
          console.log($scope.colors);
        } else {
          toastr.error("Không có dữ liệu màu sắc", "Thông báo");
        }
      })
      .catch(function (error) {
        toastr.error("Lỗi khi lấy danh sách màu sắc", "Thông báo");
      });
  };

  // Thêm màu sắc mới
  $scope.addColor = function () {
    if (!$scope.color || !$scope.color.colorName) {
      toastr.error("Vui lòng nhập tên màu sắc", "Thông báo");
      return;
    }

    var newColor = {
      colorName: $scope.color.colorName,
      status: 1,
    };

    $http({
      method: "POST",
      url: "http://localhost:8080/api/color/add",
      data: newColor,
      headers: { Authorization: "Bearer " + token },
    }).then(
      function (response) {
        toastr.success("Màu sắc đã được thêm thành công", "Thông báo");
        $scope.getAllColors();
        $("#addModal").modal("hide");
        $scope.color = {}; // Reset trường nhập liệu
      },
      function (error) {
        toastr.error("Lỗi khi thêm màu sắc", "Thông báo");
      }
    );
  };

  // Cập nhật màu sắc
  $scope.updateColor = function (color) {
    // Kiểm tra nếu tên màu sắc trống
    if (!color.colorName) {
      toastr.error("Vui lòng nhập tên màu sắc", "Thông báo");
      // Không sử dụng return, chỉ thông báo lỗi và giữ chế độ chỉnh sửa
      color.isEditing = true; // Giữ chế độ chỉnh sửa lại
    } else {
      var updatedColor = {
        colorName: color.colorName,
        status: color.status,
      };

      // Thực hiện PUT request để cập nhật màu sắc
      $http({
        method: "PUT",
        url: "http://localhost:8080/api/color/update/" + color.id,
        data: updatedColor,
        headers: { Authorization: "Bearer " + token },
      }).then(
        function (response) {
          toastr.success("Màu sắc đã được cập nhật", "Thông báo");
          $scope.getAllColors();
          // Sau khi cập nhật thành công, tắt chế độ chỉnh sửa
          color.isEditing = false;
        },
        function (error) {
          toastr.error("Lỗi khi cập nhật màu sắc", "Thông báo");
          // Giữ chế độ chỉnh sửa nếu có lỗi trong quá trình PUT
        }
      );
    }
  };

  // Xóa màu sắc
  $scope.deleteColor = function (colorId) {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/color/delete/" + colorId,
      headers: { Authorization: "Bearer " + token },
    }).then(
      function (response) {
        toastr.success("Màu sắc đã được xóa", "Thông báo");
        $scope.getAllColors();
      },
      function (error) {
        toastr.error("Lỗi khi xóa màu sắc", "Thông báo");
      }
    );
  };

  // Chuyển đổi chế độ sửa
  $scope.toggleEdit = function (color) {
    color.isEditing = !color.isEditing;
    if (!color.isEditing) {
      $scope.updateColor(color); // Cập nhật khi đóng chế độ sửa
    }
  };

  // Hủy chỉnh sửa
  $scope.cancelEdit = function (color) {
    color.isEditing = false;
    $scope.getAllColors();
    // Lấy lại thông tin màu sắc ban đầu nếu cần
  };

  // Gọi hàm khởi tạo để load màu sắc khi trang được tải
  $scope.getAllColors();
});
