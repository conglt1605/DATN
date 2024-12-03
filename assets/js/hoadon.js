var app = angular.module("myApp", []);

app.controller("HoaDonController", function ($scope, $http) {
  // Danh sách trạng thái
  $scope.statusList = [
    { value: 1, label: "Chờ xác nhận" },
    { value: 2, label: "Chờ giao" },
    { value: 3, label: "Đang giao" },
    { value: 4, label: "Hoàn thành" },
    { value: 5, label: "Hủy" },
    { value: 6, label: "Chờ thanh toán" },
  ];

  // Biến để lưu tab hiện tại
  $scope.currentTab = "all";

  // Biến lưu hóa đơn lọc
  $scope.filteredInvoices = [];

  // Hàm để lọc hóa đơn theo trạng thái
  $scope.filterByStatus = function (status) {
    $scope.currentTab = status;
    if (status === "all") {
      $scope.filteredInvoices = $scope.invoices; // Hiển thị tất cả hóa đơn
    } else {
      $scope.filteredInvoices = $scope.invoices.filter(
        (hd) => hd.status === status
      );
    }
  };

  // Hàm đếm số lượng hóa đơn theo trạng thái
  $scope.getCountByStatus = function (status) {
    return $scope.invoices.filter((hd) => hd.status === status).length;
  };

  // Hàm tải dữ liệu
  $scope.loadData = function () {
    $http
      .get("http://localhost:8080/api/invoice/all")
      .then(function (response) {
        if (response.data) {
          $scope.invoices = response.data.Success;
          $scope.filterByStatus("all"); // Hiển thị tất cả hóa đơn ban đầu
        } else {
          toastr.error("Không có dữ liệu hóa đơn", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách hóa đơn", "Thông báo");
      });
  };

  // Gọi hàm tải dữ liệu khi khởi tạo controller
  $scope.loadData();

  // Hàm trạng thái và các hàm bổ trợ (như trong mã trước đó)
  $scope.getTrangThai = function (status) {
    switch (status) {
      case 1:
        return "Chờ xác nhận";
      case 2:
        return "Chờ giao";
      case 3:
        return "Đang giao";
      case 4:
        return "Hoàn thành";
      case 5:
        return "Hủy";
      case 6:
        return "Chờ thanh toán";
      default:
        return "Không xác định";
    }
  };

  $scope.getStatusClass = function (status) {
    switch (status) {
      case 1:
        return "status-1";
      case 2:
        return "status-2";
      case 3:
        return "status-3";
      case 4:
        return "status-4";
      case 5:
        return "status-5";
      case 6:
        return "status-6";
      default:
        return "";
    }
  };

  $scope.getStatusIconClass = function (status) {
    switch (status) {
      case 1:
        return "fa fa-clock icon-status-1";
      case 2:
        return "fa fa-truck icon-status-2";
      case 3:
        return "fa fa-spinner fa-spin icon-status-3";
      case 4:
        return "fa fa-check icon-status-4";
      case 5:
        return "fa fa-times icon-status-5";
      case 6:
        return "fa fa-hourglass-half icon-status-6";
      default:
        return "";
    }
  };
});
