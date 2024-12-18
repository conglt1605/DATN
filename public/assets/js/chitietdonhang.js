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

  $scope.updateProductQuantity = function (cthd, newQuantityFromUser) {
    if (newQuantityFromUser !== undefined) {
      // Kiểm tra nếu số lượng mới được nhập
      const oldQuantity = cthd.quantity; // Lưu lại số lượng cũ trước khi thay đổi
      const updatedQuantity = newQuantityFromUser; // Số lượng mới nhập từ người dùng

      // Tính toán sự thay đổi số lượng
      const quantityChange = updatedQuantity - oldQuantity;

      // Cập nhật số lượng trong chi tiết sản phẩm
      const updatedProductDetail = {
        id: cthd.productDetail.id, // ID chi tiết sản phẩm
        quantity: cthd.productDetail.quantity - quantityChange, // Điều chỉnh số lượng chi tiết sản phẩm
      };

      // Kiểm tra nếu số lượng chi tiết sản phẩm không âm
      if (updatedProductDetail.quantity < 0) {
        toastr.error("Số lượng sản phẩm không đủ để cập nhật.");
        return;
      }

      // Gửi yêu cầu PUT để cập nhật số lượng trong chi tiết sản phẩm
      $http
        .put(
          `http://localhost:8080/api/productdetail/update/quantity/${cthd.productDetail.id}`,
          updatedProductDetail // Gửi một đối tượng ProductDetail thay vì mảng
        )
        .then(function (response) {
          toastr.success("Số lượng trong chi tiết sản phẩm đã được cập nhật!");

          // Cập nhật số lượng trong chi tiết hóa đơn
          const updatedInvoiceDetail = {
            id: cthd.id,
            quantity: updatedQuantity,
            currentPrice: cthd.currentPrice,
            totalPrice: updatedQuantity * cthd.currentPrice, // Cập nhật tổng tiền
          };

          // Gửi yêu cầu PUT để cập nhật số lượng trong chi tiết hóa đơn
          $http
            .put(
              `http://localhost:8080/api/invoicedetail/update/${cthd.id}`,
              updatedInvoiceDetail
            )
            .then(function (response) {
              toastr.success("Số lượng trong hóa đơn đã được cập nhật!");
              $scope.loadChiTietHoaDon(); // Tải lại chi tiết hóa đơn để phản ánh thay đổi
            })
            .catch(function (error) {
              toastr.error("Lỗi khi cập nhật số lượng trong hóa đơn.");
              console.error(error);
            });
        })
        .catch(function (error) {
          toastr.error("Lỗi khi cập nhật số lượng chi tiết sản phẩm.");
          console.error(error);
        });
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

  $scope.cancelInvoice = function (invoice) {
    const confirmCancel = confirm(
      `Bạn có chắc chắn muốn hủy đơn hàng với mã: ${invoice.invoiceCode}?`
    );

    if (!confirmCancel) {
      toastr.info("Bạn đã hủy thao tác hủy đơn.");
      return;
    }

    // Gửi yêu cầu cập nhật trạng thái hủy lên server
    $http
      .put(`http://localhost:8080/api/invoice/updateStatus/${invoice.id}`, {
        status: 5, // Trạng thái hủy
      })
      .then(function (response) {
        toastr.success("Đơn hàng đã được hủy thành công!");
        invoice.status = 5; // Cập nhật trạng thái trong giao diện
      })
      .catch(function (error) {
        const errorMessage = error.data?.error || "Lỗi khi hủy đơn hàng.";
        toastr.error(errorMessage);
        console.error(error);
      });
  };

  $scope.openEditInvoiceModal = function () {
    const modal = new bootstrap.Modal(
      document.getElementById("editInvoiceModal")
    );
    modal.show();
  };

  $scope.updateInvoice = function () {
    $http
      .put(
        `http://localhost:8080/api/invoice/update/${$scope.invoice.id}`,
        $scope.invoice
      )
      .then(function (response) {
        toastr.success("Cập nhật thông tin đơn hàng thành công!");
        const modal = bootstrap.Modal.getInstance(
          document.getElementById("editInvoiceModal")
        );
        modal.hide();
      })
      .catch(function (error) {
        toastr.error("Lỗi khi cập nhật đơn hàng.");
        console.error(error);
      });
  };

  // Hàm mở modal thêm sản phẩm
  $scope.openAddProductModal = function () {
    // Lấy danh sách sản phẩm có trạng thái là 1
    $http
      .get("http://localhost:8080/api/productdetail/all")
      .then(function (response) {
        if (response.data.Success) {
          // Lọc sản phẩm có trạng thái là 1
          $scope.availableProductdetails = response.data.Success.filter(
            (productdetail) => productdetail.status === 1
          );
          // Mở modal
          console.log(response);
          const modal = new bootstrap.Modal(
            document.getElementById("addProductModal")
          );
          modal.show();
        } else {
          toastr.error("Không có dữ liệu sản phẩm", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách sản phẩm", "Thông báo");
      });
  };

  $scope.addProductToInvoice = function (selectedProduct) {
    // Khởi tạo mặc định nếu chưa có invoiceDetails
    if (!$scope.invoiceDetails) {
      $scope.invoiceDetails = [];
    }

    // Lấy số lượng đã nhập từ ô nhập liệu (hoặc giá trị mặc định là 1)
    const selectedQuantity = selectedProduct.selectedQuantity || 1;

    // Kiểm tra số lượng có hợp lệ không
    if (selectedQuantity < 1 || selectedQuantity > selectedProduct.quantity) {
      toastr.error(
        "Số lượng không hợp lệ hoặc vượt quá số lượng sản phẩm trong kho",
        "Thông báo"
      );
      return;
    }

    // Tìm trong chi tiết hóa đơn xem sản phẩm này đã có chưa
    const existingProduct = $scope.invoiceDetails.find(function (detail) {
      return detail.productDetail.id === selectedProduct.id;
    });

    if (existingProduct) {
      // Nếu đã có sản phẩm này trong chi tiết hóa đơn, cộng số lượng
      existingProduct.quantity += selectedQuantity;
      existingProduct.totalPrice =
        existingProduct.quantity * existingProduct.currentPrice;

      // Cập nhật lại chi tiết hóa đơn trong backend
      $http
        .put(
          `http://localhost:8080/api/invoicedetail/update/${existingProduct.id}`,
          existingProduct
        )
        .then(function (response) {
          toastr.success("Sản phẩm đã được cập nhật số lượng!");
          $scope.loadChiTietHoaDon(); // Tải lại chi tiết hóa đơn
        })
        .catch(function (error) {
          toastr.error("Lỗi khi cập nhật sản phẩm trong chi tiết hóa đơn.");
          console.error(error.data); // In lỗi chi tiết từ backend
        });
    } else {
      // Nếu chưa có sản phẩm này trong chi tiết hóa đơn, thêm mới
      const newProductDetail = {
        productDetailId: selectedProduct.productDetailId || selectedProduct.id,
        quantity: selectedQuantity,
        currentPrice: selectedProduct.price,
        totalPrice: selectedQuantity * selectedProduct.price,
        status: 1, // Bạn có thể sửa status tùy theo yêu cầu
        invoiceId: $scope.invoice.id,
      };

      // Gọi API để thêm sản phẩm vào chi tiết hóa đơn
      $http
        .post(
          `http://localhost:8080/api/invoicedetail/add/${$scope.invoice.id}`,
          newProductDetail
        )
        .then(function (response) {
          toastr.success("Sản phẩm đã được thêm vào chi tiết hóa đơn!");
          $scope.loadChiTietHoaDon(); // Tải lại chi tiết hóa đơn
          const modal = bootstrap.Modal.getInstance(
            document.getElementById("addProductModal")
          );
          modal.hide(); // Ẩn modal sau khi thêm sản phẩm
        })
        .catch(function (error) {
          toastr.error("Lỗi khi thêm sản phẩm vào chi tiết hóa đơn.");
          console.error(error.data); // In lỗi chi tiết từ backend
        });
    }

    // Cập nhật số lượng còn lại trong giỏ hàng
    selectedProduct.quantity -= selectedQuantity;

    // Nếu số lượng còn lại < 0, thông báo lỗi để người dùng chỉnh sửa lại số lượng
    if (selectedProduct.quantity < 0) {
      toastr.error("Số lượng sản phẩm trong giỏ hàng không đủ.", "Lỗi");
    }
  };

  // Khởi chạy
  $scope.loadChiTietHoaDon();
});
