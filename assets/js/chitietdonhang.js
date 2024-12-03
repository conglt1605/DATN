var app = angular.module("myApp", []);

app.controller("chiTietDonHangController", function ($scope, $http) {
  const urlParams = new URLSearchParams(window.location.search);
  const id = urlParams.get("id");

  // Hàm tải chi tiết hóa đơn
  $scope.loadChiTietHoaDon = function () {
    $http
      .get(`http://localhost:8080/api/invoicedetail/${id}`)
      .then(function (response) {
        console.log(response.data); // Kiểm tra dữ liệu trả về từ API
        if (response.data && response.data.length > 0) {
          $scope.invoice = response.data[0].invoice; // Thông tin hóa đơn
          $scope.invoicedetail = response.data; // Lưu toàn bộ mảng chi tiết hóa đơn
          console.log($scope.invoicedetail); // Kiểm tra chi tiết hóa đơn
        } else {
          toastr.error("Không có dữ liệu chi tiết hóa đơn.");
        }
      })
      .catch(function (error) {
        toastr.error("Lỗi khi tải chi tiết hóa đơn.");
        console.error(error);
      });
  };

  // Hàm tải danh sách hóa đơn
  $scope.loadHoaDonList = function () {
    $http
      .get("http://localhost:8080/api/invoice/all")
      .then(function (response) {
        $scope.invoices = response.data;
      })
      .catch(function (error) {
        console.error("Lỗi khi tải danh sách hóa đơn:", error);
      });
  };

  // Hàm tải danh sách sản phẩm chi tiết
  $scope.loadChiTietSanPham = function () {
    $http
      .get("http://localhost:8080/api/productdetail/all")
      .then(function (response) {
        $scope.productdetails = response.data.Success;
      })
      .catch(function (error) {
        console.error("Lỗi khi tải danh sách sản phẩm chi tiết:", error);
      });
  };

  // Hàm tải danh sách sản phẩm
  $scope.loadSanPham = function () {
    $http
      .get("http://localhost:8080/api/product/all")
      .then(function (response) {
        if (response.data) {
          $scope.products = response.data.Success;
          console.log($scope.products);
        } else {
          toastr.error("Không có dữ liệu sản phẩm", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách sản phẩm", "Thông báo");
      });
  };

  // Hàm để lấy trạng thái dựa trên giá trị
  $scope.getStatus = function (trangThai) {
    switch (trangThai) {
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

  $scope.printInvoice = function () {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    // Tiêu đề PDF
    doc.setFontSize(18);
    doc.text("Hóa Đơn", 105, 10, { align: "center" });

    // Thông tin khách hàng
    doc.setFontSize(12);

    const formattedDate = $scope.invoice.createdDate
      ? new Date($scope.invoice.createdDate).toLocaleDateString("vi-VN")
      : "Chưa có ngày mua";
    const address = $scope.invoice.deliveryAddress
      ? $scope.invoice.deliveryAddress.replace(
          /[\u0000-\u001F\u007F-\u009F]/g,
          ""
        )
      : "Chưa có địa chỉ";

    doc.text(
      "Mã đơn: " + ($scope.invoice.invoiceCode || "Chưa có mã đơn"),
      10,
      20
    );
    doc.text("Ngày mua: " + formattedDate, 10, 25);
    doc.text(
      "Khách hàng: " + ($scope.invoice.consigneeName || "Chưa có khách hàng"),
      10,
      30
    );
    doc.text("Địa chỉ: " + address, 10, 35);
    doc.text(
      "SĐT: " + ($scope.invoice.phoneNumber || "Chưa có số điện thoại"),
      10,
      40
    );

    // Thông tin sản phẩm
    const tableStartY = 50;
    const rowHeight = 10;

    doc.setFontSize(12);
    doc.text("Tên sản phẩm", 10, tableStartY);
    doc.text("Số lượng", 50, tableStartY);
    doc.text("Giá", 90, tableStartY);
    doc.text("Thành tiền", 130, tableStartY);

    let yOffset = tableStartY + rowHeight;

    // Kiểm tra nếu có thông tin chi tiết sản phẩm
    if (
      $scope.invoice.invoiceDetail &&
      Array.isArray($scope.invoice.invoiceDetail.productDetail)
    ) {
      $scope.invoice.invoiceDetail.productDetail.forEach((invoiceDetail) => {
        const product = invoiceDetail.productDetail || {};
        const productName = product.productDetailName || "Chưa có tên";
        const quantity = invoiceDetail.quantity || 0;
        const price = invoiceDetail.currentPrice || 0;
        const total = quantity * price;

        // In thông tin sản phẩm vào bảng
        doc.text(productName, 10, yOffset);
        doc.text(quantity.toString(), 50, yOffset);
        doc.text(price.toString(), 90, yOffset);
        doc.text(total.toFixed(2), 130, yOffset);

        yOffset += rowHeight; // Cập nhật vị trí yOffset cho dòng tiếp theo
      });
    }

    // Tổng tiền
    const totalAmount = Array.isArray($scope.invoice.invoiceDetail)
      ? $scope.invoice.invoiceDetail.reduce((sum, invoiceDetail) => {
          return (
            sum +
            (invoiceDetail.quantity || 0) * (invoiceDetail.currentPrice || 0)
          );
        }, 0)
      : 0;

    // In tổng tiền
    doc.text("Tổng tiền: " + totalAmount.toFixed(2), 10, yOffset + 10);

    // Trạng thái đơn hàng
    const statusOffset = yOffset + 20;
    doc.text("Trạng thái đơn hàng:", 10, statusOffset);

    // Tiến trình đơn hàng (tương tự như trong giao diện)
    const steps = [
      { label: "Tạo đơn hàng", date: $scope.invoice.ngayTao },
      { label: "Chờ Xác Nhận", date: $scope.invoice.ngayChoXacNhan },
      { label: "Chờ giao", date: $scope.invoice.ngayChoGiao },
      { label: "Đang giao", date: $scope.invoice.ngayDangGiao },
      { label: "Hoàn thành", date: $scope.invoice.ngayHoanThanh },
    ];

    let stepYOffset = statusOffset + 10;
    steps.forEach((step, index) => {
      if (step.date) {
        doc.text(
          `${step.label}: ${new Date(step.date).toLocaleString()}`,
          10,
          stepYOffset
        );
        stepYOffset += rowHeight;
      }
    });

    // Lưu và tải xuống PDF
    doc.save("hoa_don.pdf");
  };

  // Hàm tính toán Tiền Phải Trả
  $scope.calculateAmountToPay = function (invoicedetail) {
    let totalAmount = 0;
    invoicedetail.forEach(function (item) {
      const productPrice = item.productDetail.price;
      const quantity = item.quantity;
      const discount = item.invoice.voucher
        ? item.invoice.voucher.discountPercentage
        : 0;

      // Tính tổng tiền sản phẩm sau khi trừ giảm giá
      totalAmount += productPrice * quantity * (1 - discount / 100);
    });
    return totalAmount;
  };

  $scope.updateStatus = function (invoice) {
    // Kiểm tra trạng thái hiện tại
    if (invoice.status >= 4) {
      toastr.error("Đơn hàng đã hoàn thành, không thể cập nhật thêm.");
      return;
    }

    // Hỏi trước khi cập nhật trạng thái
    const confirmUpdate = confirm(
      `Trạng thái hiện tại: ${$scope.getStatus(
        invoice.status
      )}. Bạn có chắc muốn chuyển sang trạng thái tiếp theo?`
    );

    if (!confirmUpdate) {
      toastr.info("Bạn đã hủy cập nhật trạng thái.");
      return;
    }

    // Tăng trạng thái thêm 1 đơn vị
    const newStatus = invoice.status + 1;

    // Gửi yêu cầu cập nhật trạng thái lên server
    $http
      .put(`http://localhost:8080/api/invoice/updateStatus/${invoice.id}`, {
        status: newStatus,
      })
      .then(function (response) {
        toastr.success("Cập nhật đơn hàng thành công!");
        invoice.status = newStatus; // Cập nhật trạng thái trong giao diện
      })
      .catch(function (error) {
        const errorMessage =
          error.data?.error || "Lỗi khi cập nhật trạng thái đơn hàng.";
        toastr.error(errorMessage);
        console.error(error);
      });
  };

  // Khởi chạy
  $scope.loadChiTietHoaDon();
});
