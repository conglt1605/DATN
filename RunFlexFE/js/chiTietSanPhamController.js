// Lấy ID từ URL
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get("id");

// Dùng `id` để gọi API trong controller
app.controller("chiTietSanPhamController", function($scope, $http) {
    $http
        .get(`http://localhost:8080/chitietsanpham/${id}`)
        .then(function(response) {
            $scope.chiTietSanPhamByID = response.data;
            console.log(response.data);
        });
    $http
        .get(`http://localhost:8080/chitietsanpham`)
        .then(function(response) {
            $scope.chiTietSanPhams = response.data;
            console.log(response.data);
        })
        .catch(function(error) {
            console.error("Lỗi khi lấy chi tiết sản phẩm:", error);
            $scope.chiTietSanPhams = [];
            alert("Không tìm thấy chi tiết sản phẩm với ID này.");
        });

    $scope.submitData = function() {
        $http
            .post("http://localhost:8080/chitietsanpham", $scope.chiTietSanPham)
            .then(
                function(response) {
                    console.log("Tạo thành công");

                    $scope.resetForm(); // Reset form sau khi thêm mới
                },
                function(error) {
                    console.error("Lỗi khi tạo:", error);
                }
            );
    };
});