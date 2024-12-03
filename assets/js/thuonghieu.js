var app = angular.module("myApp", []);

app.controller("BrandController", function ($scope, $http) {
  // Lấy danh sách thương hiệu từ API
  $scope.getAllBrands = function () {
    $http({
      method: "GET",
      url: "http://localhost:8080/api/brand/all",
    })
      .then(function (response) {
        if (response.data) {
          $scope.brands = response.data.Succes;

          console.log($scope.brands);
        } else {
          toastr.error("Không có dữ liệu thương hiệu", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách thương hiệu", "Thông báo");
      });
  };

  // Thêm thương hiệu mới
  $scope.addBrand = function () {
    if (!$scope.newBrand || !$scope.newBrand.brandName) {
      toastr.error("Vui lòng nhập tên thương hiệu", "Thông báo");
      return;
    }

    var newBrand = {
      brandName: $scope.newBrand.brandName,
      status: 1,
    };

    $http({
      method: "POST",
      url: "http://localhost:8080/api/brand/add",
      data: newBrand,
    }).then(
      function () {
        toastr.success("Thương hiệu đã được thêm thành công", "Thông báo");
        $scope.getAllBrands();
        $("#addModal").modal("hide");
        $scope.newBrand = {}; // Reset dữ liệu đầu vào
      },
      function () {
        toastr.error("Lỗi khi thêm thương hiệu", "Thông báo");
      }
    );
  };

  // Cập nhật thương hiệu
  $scope.updateBrand = function (brand) {
    if (!brand.brandName) {
      toastr.error("Vui lòng nhập tên thương hiệu", "Thông báo");
      return;
    }

    $http({
      method: "PUT",
      url: "http://localhost:8080/api/brand/update/" + brand.id,
      data: brand,
    }).then(
      function () {
        toastr.success("Thương hiệu đã được cập nhật", "Thông báo");
        $scope.getAllBrands();
        brand.isEditing = false; // Tắt chế độ chỉnh sửa
      },
      function () {
        toastr.error("Lỗi khi cập nhật thương hiệu", "Thông báo");
      }
    );
  };

  // Xóa thương hiệu
  $scope.deleteBrand = function (id) {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/brand/delete/" + id,
    }).then(
      function () {
        toastr.success("Thương hiệu đã được xóa", "Thông báo");
        $scope.getAllBrands();
      },
      function () {
        toastr.error("Lỗi khi xóa thương hiệu", "Thông báo");
      }
    );
  };

  // Chế độ chỉnh sửa
  $scope.toggleEdit = function (brand) {
    if (brand.isEditing) {
      $scope.updateBrand(brand);
    } else {
      brand.isEditing = true;
    }
  };

  // Hủy chế độ chỉnh sửa
  $scope.cancelEdit = function (brand) {
    brand.isEditing = false;
    $scope.getAllBrands();
  };

  // Khởi tạo
  $scope.getAllBrands();
});
