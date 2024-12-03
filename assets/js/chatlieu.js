var app = angular.module("myApp", []);
app.controller("MaterialController", function ($scope, $http) {
  // Lấy danh sách chất liệu từ API
  $scope.getAllMaterials = function () {
    $http({
      method: "GET",
      url: "http://localhost:8080/api/material/all",
    })
      .then(function (response) {
        if (response.data) {
          $scope.materials = response.data.Success;
        } else {
          toastr.error("Không có dữ liệu chất liệu", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách chất liệu", "Thông báo");
      });
  };

  // Thêm chất liệu mới
  $scope.addMaterial = function () {
    if (!$scope.newMaterial || !$scope.newMaterial.materialName) {
      toastr.error("Vui lòng nhập tên chất liệu", "Thông báo");
      return;
    }

    var newMaterial = {
      materialName: $scope.newMaterial.materialName,
      status: 1,
    };

    $http({
      method: "POST",
      url: "http://localhost:8080/api/material/add",
      data: newMaterial,
    }).then(
      function () {
        toastr.success("Chất liệu đã được thêm thành công", "Thông báo");
        $scope.getAllMaterials();
        $("#addModal").modal("hide");
        $scope.newMaterial = {}; // Reset dữ liệu đầu vào
      },
      function () {
        toastr.error("Lỗi khi thêm chất liệu", "Thông báo");
      }
    );
  };

  // Cập nhật chất liệu
  $scope.updateMaterial = function (material) {
    if (!material.materialName) {
      toastr.error("Vui lòng nhập tên chất liệu", "Thông báo");
      return;
    }

    $http({
      method: "PUT",
      url: "http://localhost:8080/api/material/update/" + material.id,
      data: material,
    }).then(
      function () {
        toastr.success("Chất liệu đã được cập nhật", "Thông báo");
        $scope.getAllMaterials();
        material.isEditing = false; // Tắt chế độ chỉnh sửa
      },
      function () {
        toastr.error("Lỗi khi cập nhật chất liệu", "Thông báo");
      }
    );
  };

  // Xóa chất liệu
  $scope.deleteMaterial = function (id) {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/material/delete/" + id,
    }).then(
      function () {
        toastr.success("Chất liệu đã được xóa", "Thông báo");
        $scope.getAllMaterials();
      },
      function () {
        toastr.error("Lỗi khi xóa chất liệu", "Thông báo");
      }
    );
  };

  // Bật/Tắt chế độ chỉnh sửa
  $scope.toggleEdit = function (material) {
    material.isEditing = !material.isEditing;
    if (!material.isEditing) {
      $scope.updateMaterial(material);
    }
  };

  // Hủy chỉnh sửa
  $scope.cancelEdit = function (material) {
    material.isEditing = false;
  };

  // Khởi tạo - Gọi API khi trang được tải
  $scope.getAllMaterials();
});
