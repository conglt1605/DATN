var app = angular.module("myApp", []);

app.controller("CategoryController", function ($scope, $http) {
  // Lấy danh sách danh mục từ API
  $scope.getAllCategories = function () {
    $http({
      method: "GET",
      url: "http://localhost:8080/api/category/all",
    })
      .then(function (response) {
        if (response.data) {
          $scope.categories = response.data.Success;
        } else {
          toastr.error("Không có dữ liệu danh mục", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách danh mục", "Thông báo");
      });
  };

  // Thêm danh mục mới
  $scope.addCategory = function () {
    if (!$scope.newCategory || !$scope.newCategory.categoryName) {
      toastr.error("Vui lòng nhập tên danh mục", "Thông báo");
      return;
    }

    var newCategory = {
      categoryName: $scope.newCategory.categoryName,
      status: 1,
    };

    $http({
      method: "POST",
      url: "http://localhost:8080/api/category/add",
      data: newCategory,
    }).then(
      function () {
        toastr.success("Danh mục đã được thêm thành công", "Thông báo");
        $scope.getAllCategories();
        $("#addModal").modal("hide");
        $scope.newCategory = {}; // Reset dữ liệu đầu vào
      },
      function () {
        toastr.error("Lỗi khi thêm danh mục", "Thông báo");
      }
    );
  };

  // Cập nhật danh mục
  $scope.updateCategory = function (category) {
    if (!category.categoryName) {
      toastr.error("Vui lòng nhập tên danh mục", "Thông báo");
      return;
    }

    $http({
      method: "PUT",
      url: "http://localhost:8080/api/category/update/" + category.id,
      data: category,
    }).then(
      function () {
        toastr.success("Danh mục đã được cập nhật", "Thông báo");
        $scope.getAllCategories();
        category.isEditing = false; // Tắt chế độ chỉnh sửa
      },
      function () {
        toastr.error("Lỗi khi cập nhật danh mục", "Thông báo");
      }
    );
  };

  // Xóa danh mục
  $scope.deleteCategory = function (id) {
    $http({
      method: "DELETE",
      url: "http://localhost:8080/api/category/delete/" + id,
    }).then(
      function () {
        toastr.success("Danh mục đã được xóa", "Thông báo");
        $scope.getAllCategories();
      },
      function () {
        toastr.error("Lỗi khi xóa danh mục", "Thông báo");
      }
    );
  };

  // Bật/Tắt chế độ chỉnh sửa
  $scope.toggleEdit = function (category) {
    category.isEditing = !category.isEditing;
    if (!category.isEditing) {
      $scope.updateCategory(category);
    }
  };

  // Hủy chỉnh sửa
  $scope.cancelEdit = function (category) {
    category.isEditing = false;
  };

  // Khởi tạo - Gọi API khi trang được tải
  $scope.getAllCategories();
});
