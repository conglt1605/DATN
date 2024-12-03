const app = angular.module("myApp", []);

app.controller("ProductController", function ($scope, $http) {
  // Lấy danh sách sản phẩm
  $scope.getAllProducts = function () {
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

  $http
    .get("http://localhost:8080/api/product/active")
    .then(function (response) {
      if (response.data) {
        $scope.productactive = response.data.Success;
        console.log($scope.productactive);
      } else {
        toastr.error("Không có dữ liệu sản phẩm", "Thông báo");
      }
    })
    .catch(function () {
      toastr.error("Lỗi khi lấy danh sách sản phẩm", "Thông báo");
    });

  // Lấy danh mục
  $http
    .get("http://localhost:8080/api/category/all")
    .then(function (response) {
      if (response.data) {
        $scope.categories = response.data.Success;
      } else {
        toastr.error("Không có dữ liệu danh mục", "Thông báo");
      }
    })
    .catch(function () {
      toastr.error("Lỗi khi lấy danh sách danh mục", "Thông báo");
    });

  // Lấy thương hiệu
  $http
    .get("http://localhost:8080/api/brand/all")
    .then(function (response) {
      if (response.data) {
        $scope.brands = response.data.Succes;
        console.log($scope.brands);
      } else {
        toastr.error("Không có dữ liệu thương hiệu", "Thông báo");
      }
    })
    .catch(function () {
      toastr.error("Lỗi khi lấy danh sách thương hiệu", "Thông báo");
    });

  // Gọi API để lấy số lượng theo id
  $http.get("http://localhost:8080/api/productdetail/total").then(
    function (response) {
      $scope.QuantityData = {}; // Đặt tên đúng
      console.log(response.data); // Kiểm tra dữ liệu trả về từ API
      response.data.forEach(function (item) {
        const Productid = item.Product; // Nếu API trả về key là "Product"
        const TotalQuantity = item.TotalQuantity; // Nếu API trả về key là "TotalQuantity"
        $scope.QuantityData[Productid] = TotalQuantity;
      });
    },
    function (error) {
      console.error("Lỗi khi lấy dữ liệu số lượng:", error);
    }
  );

  // Lấy đối tượng sử dụng
  $http
    .get("http://localhost:8080/api/usageobject/all")
    .then(function (response) {
      if (response.data) {
        $scope.usageObjects = response.data.Success;
        console.log($scope.usageObjects);
      } else {
        toastr.error("Không có dữ liệu đối tượng sử dụng", "Thông báo");
      }
    })
    .catch(function () {
      toastr.error("Lỗi khi lấy danh sách đối tượng sử dụng", "Thông báo");
    });
  $scope.submitProduct = function (event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form
    var formData = new FormData();

    // Dữ liệu sản phẩm
    var productData = {
      productName: $scope.product.productName,
      category: { id: $scope.product.category.id },
      brand: { id: $scope.product.brand.id },
      usageObject: { id: $scope.product.usageObject.id },
      status: $scope.product.status,
    };

    // Thêm dữ liệu sản phẩm vào FormData
    formData.append(
      "product",
      new Blob([JSON.stringify(productData)], { type: "application/json" })
    );

    // Thêm file ảnh vào FormData
    if ($scope.product.imageFile) {
      formData.append("image", $scope.product.imageFile);
    }

    // Gửi yêu cầu POST
    $http
      .post("http://localhost:8080/api/product/add", formData, {
        transformRequest: angular.identity,
        headers: { "Content-Type": undefined },
      })
      .then(
        function (response) {
          toastr.success("Sản phẩm đã được thêm thành công", "Thông báo");
        },
        function (error) {
          toastr.error("Lỗi khi thêm sản phẩm", "Thông báo");
        }
      );
  };

  // Phương thức xử lý khi người dùng chọn file
  $scope.fileChanged = function (element) {
    var file = element.files[0];
    if (file) {
      if (file.size > 10 * 1024 * 1024) {
        // Giới hạn 10MB
        toastr.error(
          "File quá lớn! Vui lòng chọn file nhỏ hơn 10MB",
          "Thông báo"
        );
        $scope.product.imageFile = null;
      } else {
        $scope.product.imageFile = file;
      }
    }
  };

  // Reset form
  $scope.resetForm = function () {
    $scope.product = {
      id: null,
      productCode: "",
      productName: "",
      status: 1, // Mặc định là 1
      brand: { id: null },
      category: { id: null },
      usageObject: { id: null },
    };
  };

  // Thêm mới danh mục
  $scope.addCategory = function () {
    $http.post("http://localhost:8080/danhmuc", $scope.category).then(
      function (response) {
        console.log("Tạo thành công");
        $scope.categories.push(response.data);
        $scope.resetForm();
      },
      function (error) {
        console.error("Lỗi khi tạo:", error);
      }
    );
  };

  // Thêm mới thương hiệu
  $scope.addBrand = function () {
    $http.post("http://localhost:8080/thuonghieu", $scope.brand).then(
      function (response) {
        console.log("Tạo thành công");
        $scope.brands.push(response.data);
        $scope.resetForm();
      },
      function (error) {
        console.error("Lỗi khi tạo:", error);
      }
    );
  };

  $scope.showAddForm = false;

  // Hiện/ẩn form thêm sản phẩm
  $scope.toggleAddProductForm = function () {
    $scope.showAddForm = !$scope.showAddForm;
  };

  $scope.getAllProducts();
});
