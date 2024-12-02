app.controller("CartController", function ($scope, $http) {
  $scope.lstOrderProduct =
    JSON.parse(localStorage.getItem("orderProduct")) || [];
  //   console.log(localStorage.getItem("orderProduct"));

  const apiInvoice = "http://localhost:8080/api/invoice/";
  $scope.submitPayment = function () {
    if (!$scope.consigneeName) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Họ và tên không được để trống !",
        showConfirmButton: true,
      });
      return;
    }
    if (!$scope.phoneNumber) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Số điện thoại không được để trống !",
        showConfirmButton: true,
      });
      return;
    }
    if (!$scope.deliveryAddress) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Địa chỉ không được để trống !",
        showConfirmButton: true,
      });
      return;
    }
    if (!$scope.paymentMethod) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Vui long chọn phương thức thanh toán !",
        showConfirmButton: true,
      });
      return;
    }
    $scope.invoice = {
      consigneeName: $scope.consigneeName,
      phoneNumber: $scope.phoneNumber,
      deliveryAddress: $scope.deliveryAddress,
      paymentMethod: $scope.paymentMethod,
      totalAmount: $scope.lstOrderProduct
        .filter((order) => order.selected)
        .reduce(
          (sum, order) => sum + order.productDetai.price * order.quantity,
          0
        ),
      invoiceDetails: $scope.lstOrderProduct
        .filter((order) => order.selected) // Lọc các sản phẩm có selected = true
        .map((order) => ({
          quantity: order.quantity, // Số lượng sản phẩm
          currentPrice: order.productDetai.price, // Giá hiện tại của sản phẩm
          totalPrice: order.productDetai.price * order.quantity, // Tổng giá = Giá * Số lượng
          status: 1, // Trạng thái (cố định là 1)
          productDetail: order.productDetai, // Thông tin chi tiết sản phẩm
        })),
    };
    console.log($scope.invoice);
    return;
    // Gửi yêu cầu thanh toán lên server
    $http.post(apiInvoice + "saveWithDetails", $scope.invoice).then(
      function (response) {
        // Xử lý kết quả thanh toán thành công
        Swal.fire({
          position: "center",
          icon: "success",
          title: response.data.success,
          showConfirmButton: false,
          timer: 1500,
        });
        console.log(response.data);
      },
      function (error) {
        // Xử lý lỗi thanh toán
        console.error(error);
      }
    );
  };

  // Tính tổng giá trị giỏ hàng
  $scope.getTotal = function () {
    // Lọc các sản phẩm được chọn và tính tổng giá trị
    const total = $scope.lstOrderProduct
      .filter((order) => order.selected) // Lọc các sản phẩm được chọn
      .reduce((sum, order) => {
        return sum + order.productDetai.price * order.quantity;
      }, 0);

    // Cập nhật localStorage với danh sách đã lọc
    localStorage.setItem(
      "orderProduct",
      JSON.stringify($scope.lstOrderProduct)
    );
    return total;
  };
  $scope.pay = function () {
    window.location.href = "/pay";
  };
  $scope.removeProduct = function (productId) {
    let index = $scope.lstOrderProduct.findIndex(
      (order) => order.productDetai.id === productId
    );
    if (index !== -1) {
      $scope.lstOrderProduct.splice(index, 1);
      localStorage.setItem(
        "orderProduct",
        JSON.stringify($scope.lstOrderProduct)
      );
    }
  };

  $scope.updateQuantity = function (productId, quantity) {
    let product = $scope.lstOrderProduct.find(
      (order) => order.productDetai.id === productId
    );
    if (product) {
      product.quantity = quantity;
      localStorage.setItem(
        "orderProduct",
        JSON.stringify($scope.lstOrderProduct)
      );
    }
  };

  $scope.calculateTotal = function () {
    return $scope.lstOrderProduct.reduce((total, item) => {
      return total + item.quantity * item.productDetai.price; // Cần có thuộc tính giá
    }, 0);
  };

  $scope.getSelectedProducts = function () {
    return $scope.lstOrderProduct.filter(function (order) {
      console.log($scope.lstOrderProduct);
      return order.selected; // Lọc những sản phẩm được chọn
    });
  };
});
