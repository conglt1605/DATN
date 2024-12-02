app.controller("ImageUploadController", function ($scope, $http) {
  $scope.uploadImage = function () {
    const formData = new FormData();
    const fileInput = document.getElementById("fileInput");

    if (!fileInput.files[0]) {
      alert("Vui lòng chọn ảnh!");
      return;
    }

    formData.append("file", fileInput.files[0]);

    // Gửi yêu cầu POST đến API backend
    $http
      .post("http://localhost:8080/api/images/upload", formData, {
        transformRequest: angular.identity,
        headers: { "Content-Type": undefined },
      })
      .then(function (response) {
        console.log("Upload thành công:", response.data);
        // $scope.uploadedImageUrl = response.data.secure_url; // URL trả về từ Cloudinary
      })
      .catch(function (error) {
        console.error("Upload thất bại:", error);
      });
  };
});
