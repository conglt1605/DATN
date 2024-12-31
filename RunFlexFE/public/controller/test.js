app.controller("PaymentController", function($scope, $http) {
    $scope.submitPayment = function() {
        if ($scope.paymentMethod === 2) {
            // Nếu chọn phương thức thanh toán chuyển khoản
            const accountNumber = "123456789"; // Số tài khoản của bạn
            const bankName = "Ngân hàng XYZ";
            const amount = 123; // Tổng số tiền

            const url = `/generate-qr?accountNumber=${accountNumber}&bankName=${bankName}&amount=${amount}`;

            $http
                .get(url, { responseType: "arraybuffer" })
                .then((response) => {
                    const blob = new Blob([response.data], { type: "image/png" });
                    const qrUrl = URL.createObjectURL(blob);

                    // Hiển thị mã QR
                    const qrContainer = document.getElementById("qr-code-container");
                    qrContainer.innerHTML = `<img src="${qrUrl}" alt="QR Code" />`;
                })
                .catch((error) => {
                    console.error("Lỗi khi tạo mã QR:", error);
                });
        } else {
            alert("Vui lòng chọn phương thức thanh toán!");
        }
    };
});