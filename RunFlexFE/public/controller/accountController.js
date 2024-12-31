app.controller("AccountController", function($scope, $http, $location) {
    $scope.message = "Welcome to AccountController!";
    $scope.form = null;
    const apiUser = "http://localhost:8080/api/user/";
    const apiInvoice = "http://localhost:8080/api/invoice/";

    ($scope.getInvoiceWithUserId = null),
    ($scope.userId = JSON.parse(localStorage.getItem("userId")));
    $scope.editMode = false;

    $scope.cancelOrder = function(invoiceID) {
        $http
            .get(apiInvoice + "CancelOrder", { params: { id: invoiceID } })
            .then(function(response) {
                $scope.success = response.data.Success;
                Swal.fire({
                    icon: "success",
                    title: "Hủy đơn hàng",
                    text: $scope.success,
                }).then(() => {
                    location.reload(); // Tải lại trang sau khi thông báo thành công
                });
            })
            .catch(function(error) {
                $scope.error = error.data.error;
                Swal.fire({
                    icon: "error",
                    title: "Lỗi khi hủy đơn hàng",
                    text: $scope.error,
                });
            });
    };

    $scope.userById = function() {
        $http
            .get(apiUser + "userById", { params: { userId: $scope.userId } })
            .then(function(response) {
                $scope.userById = response.data.Success;
                console.log("UserById", $scope.userById);
            })
            .catch(function(error) {
                console.error("Lỗi khi tìm user", error);
            });
    };

    $scope.updateUser = function() {
        // Gửi yêu cầu POST với userId trong tham số truy vấn và đối tượng user trong body
        $http
            .post(
                apiUser + "UpdateUser", // URL API
                {
                    // Body request chứa thông tin người dùng
                    fullName: $scope.userById.fullName,
                    email: $scope.userById.email,
                    phoneNumber: $scope.userById.phoneNumber,
                    address: $scope.userById.address,
                }, {
                    params: {
                        // Truyền userId qua tham số truy vấn
                        userId: $scope.userId,
                    },
                }
            )
            .then(function(response) {
                $scope.success = response.data.Success;
                console.log("Cập nhật thành công:", $scope.success);
                if ($scope.success) {
                    Swal.fire({
                        icon: "success",
                        title: "Cập nhật thành công!",
                        text: "Thông tin người dùng đã được cập nhật.",
                    }).then(() => {
                        location.reload(); // Tải lại trang sau khi thông báo thành công
                    });
                }
            })
            .catch(function(error) {
                console.error("Lỗi khi update người dùng:", error);
            });
    };

    $scope.signin = function() {
        // Gửi yêu cầu POST đến API
        $http
            .post(apiUser + "authenticate", $scope.form)
            .then(function(response) {
                console.log("Signin successful", response.data);
                // Xử lý token hoặc điều hướng sau khi đăng nhập
                const token = response.data.success; // Nhận token từ server
                const userId = response.data.userId; // Nhận userId từ server
                localStorage.setItem("token", token); // Lưu token vào localStorage
                localStorage.setItem("userId", userId); // Lưu userId vào localStorage
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Đăng nhập thành công",
                    showConfirmButton: false,
                    timer: 1500,
                }).then(() => {
                    window.location.href = "/home"; // Chuyển hướng về trang chủ hoặc trang khác
                });
            })
            .catch(function(error) {
                console.log(error);
                // Xử lý lỗi
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: error.data.error,
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
    };

    $scope.signup = function() {
        // if ($scope.form === null) {
        //   console.log("t met lam r");
        //   return;
        // }
        $http
            .post(apiUser + "register", $scope.form)
            .then(function(response) {
                console.log("Sign-up successful:", response.data);
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: response.data.success || "Thành công",
                    showConfirmButton: false,
                    timer: 1500,
                });
            })
            .catch(function(error) {
                console.log(error);
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: error.data.error,
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
    };
    $scope.logout = function() {
        const token = localStorage.getItem("token");
        const userId = "";
        if (!token) {
            Swal.fire({
                icon: "error",
                title: "Chưa đăng nhập",
                showConfirmButton: false,
                timer: 1500,
            });
            return;
        }
        $http
            .post(apiUser + "logout", { userId: userId, token: token })
            .then(function(response) {
                console.log("Logged out:", response.data);
                localStorage.removeItem("token");
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Đăng xuất thành công",
                    showConfirmButton: false,
                    timer: 1500,
                }).then(() => {
                    window.location.href = "/login";
                });
            })
            .catch(function(error) {
                console.error("Logout failed:", error);
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Đăng xuất thất bại",
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
    };

    // Lấy tất cả các phần tử process-item
    const processItems = document.querySelectorAll(".process-item");

    // Thêm sự kiện click vào các phần tử
    processItems.forEach((item) => {
        item.addEventListener("click", handleProcessItemClick);
    });

    // Xử lý sự kiện click trên các phần tử
    function handleProcessItemClick(event) {
        const targetElement = event.currentTarget;
        const targetStatus = targetElement.dataset.status;

        // Xóa class 'active' từ tất cả các phần tử
        processItems.forEach((item) => {
            item.classList.remove("active");
        });

        // Thêm class 'active' vào phần tử được click
        targetElement.classList.add("active");

        // Xử lý chức năng dựa trên trạng thái
        switch (targetStatus) {
            case "Tất cả":
                // Xử lý chức năng Tất cả
                $scope.getInvoiceWithUserId();
                break;
            case "Chờ xác nhận":
                // Xử lý chức năng Chờ xác nhận
                $scope.getInvoiceWithUserId(1);
                break;
            case "Chờ lấy hàng":
                // Xử lý chức năng Chờ lấy hàng
                $scope.getInvoiceWithUserId(2);
                break;
            case "Đang giao":
                // Xử lý chức năng Đang giao
                $scope.getInvoiceWithUserId(3);
                break;
            case "Đã giao":
                // Xử lý chức năng Đã giao
                $scope.getInvoiceWithUserId(4);
                break;
            case "Đã Hủy":
                // Xử lý chức năng Đã Hủy
                $scope.getInvoiceWithUserId(5);
                break;
            default:
                // Xử lý trường hợp khác
                console.log("Không có chức năng tương ứng");
        }
    }

    $scope.getInvoiceWithUserId = function(status) {
        return $http
            .get(apiInvoice + "invoiceWithUser", {
                params: { userId: $scope.userId },
            })
            .then(function(response) {
                const allInvoices = response.data.Success;
                // Nếu có trạng thái, lọc invoice theo trạng thái
                if (status) {
                    $scope.invoices = allInvoices.filter(
                        (invoice) => invoice.Status === status
                    );
                } else {
                    // Nếu không có trạng thái, lấy tất cả
                    $scope.invoices = allInvoices;
                }
                console.log("invoices", $scope.invoices);
            })
            .catch(function(error) {
                console.error("Lỗi khi lấy danh sách invoices", error);
            });
    };

    $scope.getInvoiceWithDetail = function(invoiceId) {
        return $http
            .get(apiInvoice + "invoiceWithDetail", {
                params: { invoiceId },
            })
            .then(function(response) {
                $scope.invoiceDetails = response.data.Success;
                console.log("invoiceDetails", $scope.invoiceDetails);
            })
            .catch(function(error) {
                console.error("Lỗi khi lấy danh sách invoiceĐetails", error);
            });
    };

    $scope.getStatusText = function(status) {
        const statusMap = {
            1: "Chờ xác nhận",
            2: "Chờ lấy hàng",
            3: "Đang giao",
            4: "Đã giao",
            5: "Đã hủy",
        };
        return statusMap[status] || "Không xác định";
    };

    $scope.viewDetails = function(invoice) {
        $scope.selectedInvoice = angular.copy(invoice);
        console.log("Select invoice:", $scope.selectedInvoice);
        $scope.getInvoiceWithDetail(invoice.ID);
        $("#detailsModal").modal("show"); // Đảm bảo rằng ID modal là #detailsModal
    };

    // Mở modal thêm nhân viên
    $scope.openAddModal = function() {
        resetForm(); // Gọi hàm resetForm để thiết lập lại form
        $scope.editMode = false; // Đặt chế độ chỉnh sửa là false để đảm bảo là chế độ thêm mới
        $("#detailsModal").modal("hide"); // Đảm bảo đóng modal chi tiết nếu có
        $("#editModal").modal("show"); // Mở modal thêm nhân viên
    };

    $scope.userById();
    $scope.getInvoiceWithUserId();
});