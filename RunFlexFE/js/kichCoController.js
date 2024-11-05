app.controller("kichCoController", function($scope) {
    // Để lưu kích cỡ đã chọn
    $scope.selectedSizes = [];

    // Hàm để thêm hoặc loại bỏ kích cỡ vào/danh sách đã chọn
    $scope.toggleSize = function(sizeId) {
        const index = $scope.selectedSizes.indexOf(sizeId);
        if (index === -1) {
            $scope.selectedSizes.push(sizeId); // Thêm vào nếu chưa chọn
        } else {
            $scope.selectedSizes.splice(index, 1); // Loại bỏ nếu đã chọn
        }
    };
});