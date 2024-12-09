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
            voucher.isEditing = false;
            voucher.originalData = angular.copy(voucher);
            return voucher;
          });
          $scope.sortByVoucherName();
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
          `http://localhost:8080/api/voucher/${$scope.voucher.id}`,
          newVoucher
        )
        .then(
          function (response) {
            toastr.success("Voucher đã được cập nhật!", "Thông báo");
            $scope.loadData();
            $scope.resetForm(); // Reset form sau khi cập nhật
            $("#addModal").modal("hide"); // Đóng modal
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

    // Kiểm tra giá trị ngày bắt đầu và ngày kết thúc
    console.log("Original startDate:", voucher.startDate);
    console.log("Original endDate:", voucher.endDate);

    // Đảm bảo ngày bắt đầu và ngày kết thúc có định dạng "yyyy-MM-dd" trước khi gán cho ng-model
    if ($scope.voucher.startDate) {
      $scope.voucher.startDate = formatToDateInput($scope.voucher.startDate);
    }
    if ($scope.voucher.endDate) {
      $scope.voucher.endDate = formatToDateInput($scope.voucher.endDate);
    }

    // Kiểm tra sau khi định dạng lại ngày
    console.log("Formatted startDate:", $scope.voucher.startDate);
    console.log("Formatted endDate:", $scope.voucher.endDate);

    $scope.isEditing = true;
    $("#addModal").modal("show"); // Mở modal chỉnh sửa
  };

  // Hàm để chuyển đổi đối tượng Date thành chuỗi định dạng "yyyy-MM-dd"
  function formatToDateInput(date) {
    var d = new Date(date);
    var day = "" + d.getDate();
    var month = "" + (d.getMonth() + 1); // Tháng trong JavaScript bắt đầu từ 0
    var year = d.getFullYear();

    // Đảm bảo ngày và tháng có đủ 2 chữ số
    if (day.length < 2) day = "0" + day;
    if (month.length < 2) month = "0" + month;

    // Trả về ngày theo định dạng "yyyy-MM-dd" (định dạng chuẩn cho input type="date")
    return [year, month, day].join("-");
  }

  // Hủy chỉnh sửa
  $scope.cancelEdit = function () {
    $scope.resetForm();
    $scope.isEditing = false;
    $("#addModal").modal("hide");
  };

  // Xóa voucher
  $scope.deleteVoucher = function (voucherId) {
    $http.delete(`http://localhost:8080/api/voucher/${voucherId}`).then(
      function (response) {
        $scope.loadData();
        toastr.success("Voucher đã bị xóa!", "Thông báo");
      },
      function (error) {
        toastr.error("Lỗi khi xóa voucher", "Thông báo");
      }
    );
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
