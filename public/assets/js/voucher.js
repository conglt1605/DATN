var app = angular.module("myApp", []);

app.controller("VoucherController", function ($scope, $http) {
  $scope.isEditing = false; // Biến xác định xem có đang chỉnh sửa hay không
  $scope.voucher = {}; // Khởi tạo đối tượng voucher để thêm mới hoặc chỉnh sửa

  // Tải dữ liệu voucher hiện có
  $scope.loadData = function () {
    $http.get("http://localhost:8080/api/voucher/all").then(
      function (response) {
        if (response.data && response.data.Success) {
          $scope.vouchers = response.data.Success.map((voucher) => {
            voucher.startDate = new Date(voucher.startDate);
            voucher.endDate = new Date(voucher.endDate);
            return voucher;
          });
        } else {
          console.error("Dữ liệu không đúng cấu trúc:", response.data);
        }
      },
      function (error) {
        console.error("Lỗi khi tải dữ liệu:", error);
      }
    );
  };

  // Xử lý thêm mới hoặc cập nhật voucher
  $scope.submitData = function () {
    const newVoucher = angular.copy($scope.voucher);
    if ($scope.voucher.id) {
      // Cập nhật voucher
      $http
        .put(
          `http://localhost:8080/api/voucher/update/${$scope.voucher.id}`,
          newVoucher
        )
        .then(
          function (response) {
            toastr.success("Voucher đã được cập nhật!", "Thông báo");
            $scope.loadData();
            $scope.resetForm(); // Reset form sau khi cập nhật
            $("#addModal").modal("hide"); // Đóng modal
            $scope.loadData();
          },
          function (error) {
            toastr.error("Lỗi khi cập nhật voucher", "Thông báo");
          }
        );
    } else {
      // Thêm mới voucher
      $http.post("http://localhost:8080/api/voucher/add", newVoucher).then(
        function (response) {
          if (response.data) {
            $scope.vouchers.unshift(response.data); // Thêm voucher mới vào danh sách
            $scope.resetForm();
            toastr.success("Thêm voucher thành công!", "Thông báo");
            $("#addModal").modal("hide");
            $scope.loadData();
          } else {
            toastr.error("Lỗi khi thêm voucher", "Thông báo");
          }
        },
        function (error) {
          toastr.error("Lỗi khi thêm voucher", "Thông báo");
        }
      );
    }
  };

  // Reset form sau khi thêm hoặc chỉnh sửa
  $scope.resetForm = function () {
    $scope.voucher = {}; // Reset đối tượng voucher
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

  // Xóa voucher
  $scope.deleteVoucher = function (voucherId) {
    $http.delete(`http://localhost:8080/api/voucher/delete/${voucherId}`).then(
      function (response) {
        $scope.loadData();
        toastr.success("Voucher đã bị xóa!", "Thông báo");
      },
      function (error) {
        toastr.error("Lỗi khi xóa voucher", "Thông báo");
      }
    );
  };

  $scope.getTrangThaiName = function (status) {
    switch (status) {
      case 1:
        return "Hoạt động";
      case 0:
        return "Ngừng Hoạt động";
      default:
        return "Không xác định";
    }
  };
  // Sắp xếp voucher theo tên
  $scope.sortByVoucherName = function () {
    if (!$scope.isEditing) {
      $scope.vouchers.sort((a, b) =>
        a.voucherName.localeCompare(b.voucherName)
      );
    }
  };

  // Tải dữ liệu khi khởi tạo
  $scope.loadData();
});
