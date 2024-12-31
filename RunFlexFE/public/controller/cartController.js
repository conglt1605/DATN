app.controller("CartController", function($scope, $http, $window, $location) {
    $scope.lstOrderProduct =
        JSON.parse(localStorage.getItem("orderProduct")) || [];
    $scope.producBuyNow = JSON.parse(localStorage.getItem("producBuyNow")) || [];
    $scope.userId = JSON.parse(localStorage.getItem("userId")) || [];

    console.log("Sản phẩm giỏ hàng", localStorage.getItem("orderProduct"));

    const apiInvoice = "http://localhost:8080/api/invoice/";
    const apiUser = "http://localhost:8080/api/user/";

    $scope.userById = function() {
        $http
            .get(apiUser + "userById", { params: { userId: $scope.userId } })
            .then(function(response) {
                $scope.userById = response.data.Success;
                console.log("UserById", $scope.userById);
                $scope.deliveryAddress = $scope.userById.address;
                $scope.consigneeName = $scope.userById.fullName;
                $scope.phoneNumber = $scope.userById.phoneNumber;
            })
            .catch(function(error) {
                console.error("Lỗi khi tìm user", error);
            });
    };

    $scope.buyNow = function() {
        $scope.invoice1 = {
            consigneeName: $scope.consigneeName,
            phoneNumber: $scope.phoneNumber,
            deliveryAddress: $scope.deliveryAddress,
            paymentMethod: $scope.paymentMethod,
            totalAmount: $scope.producBuyNow.quantityOder * $scope.producBuyNow.price,
            invoiceDetails: [{
                quantity: $scope.producBuyNow.quantityOder, // Số lượng sản phẩm
                currentPrice: $scope.producBuyNow.price, // Giá hiện tại của sản phẩm
                totalPrice: $scope.producBuyNow.quantityOder * $scope.producBuyNow.price, // Tổng giá = Giá * Số lượng
                status: 1, // Trạng thái (cố định là 1)
                productDetail: $scope.producBuyNow,
            }, ],
            invoiceUsers: [{
                user: {
                    id: $scope.userId, // Giá trị lấy từ $scope.userId
                },
            }, ],
        };
        console.log($scope.invoice1);
        $http
            .post(apiInvoice + "saveWithDetails", $scope.invoice1)
            .then(function(response) {
                // Xử lý kết quả thanh toán thành công
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: response.data.success || "Thành công",
                    showConfirmButton: false,
                    timer: 1500,
                }).then(() => {
                    $window.location.href = "/myorder"; // Đảm bảo URL hợp lệ
                });
                console.log(response.data);
            })
            .catch(function(error) {
                console.log(error);
                // Xử lý lỗi thanh toán
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: error.data.error,
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
        localStorage.setItem("invoice1", JSON.stringify($scope.invoice1));
    };

    $scope.submitPayment = function() {
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
            invoiceUsers: [{
                user: {
                    id: $scope.userId, // Giá trị lấy từ $scope.userId
                },
            }, ],
        };
        console.log($scope.invoice);
        // return;
        // Gửi yêu cầu thanh toán lên server
        $http
            .post(apiInvoice + "saveWithDetails", $scope.invoice)
            .then(function(response) {
                // Xử lý kết quả thanh toán thành công
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: response.data.success || "Thành công",
                    showConfirmButton: false,
                    timer: 1500,
                }).then(() => {
                    $window.location.href = "/myorder"; // Đảm bảo URL hợp lệ
                });
                console.log(response.data);
            })
            .catch(function(error) {
                console.log(error);
                // Xử lý lỗi thanh toán
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: error.data.error,
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
        localStorage.setItem("invoice", JSON.stringify($scope.invoice));
    };

    // Tính tổng giá trị giỏ hàng
    $scope.getTotal = function() {
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

    //Chức năng đặt hànghàng
    $scope.pay = function() {
        const isSelected = $scope.lstOrderProduct.some(
            (product) => product.selected
        );
        if (!isSelected) {
            Swal.fire({
                position: "center",
                icon: "error",
                title: "Vui lòng chọn sản phẩm",
                showConfirmButton: false,
                timer: 1500,
            });
            return;
        }
        window.location.href = "/pay";
    };

    $scope.removeProduct = function(productId) {
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

    $scope.updateQuantity = function(productId, quantity) {
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

    $scope.calculateTotal = function() {
        return $scope.lstOrderProduct.reduce((total, item) => {
            return total + item.quantity * item.productDetai.price; // Cần có thuộc tính giá
        }, 0);
    };

    $scope.getSelectedProducts = function() {
        return $scope.lstOrderProduct.filter(function(order) {
            console.log($scope.lstOrderProduct);
            return order.selected; // Lọc những sản phẩm được chọn
        });
    };

    $scope.validateQuantity = function(order) {
        if (order.quantity == null || order.quantity < 1) {
            // Nếu giá trị để trống hoặc nhỏ hơn 1, đặt giá trị tối thiểu
            order.quantity = 1;
            Swal.fire({
                position: "center",
                icon: "error",
                title: "Số lượng không hợp lệ",
                showConfirmButton: false,
                timer: 1500,
            });
        } else if (order.quantity > order.productDetai.quantity) {
            // Nếu giá trị vượt quá, đặt giá trị tối đa
            order.quantity = order.productDetai.quantity;
            Swal.fire({
                position: "center",
                icon: "error",
                title: `Sản phẩm có số lượng tối đa là ${order.productDetai.quantity}`,
                showConfirmButton: false,
                timer: 1500,
            });
        }
    };

    $scope.userById();
});