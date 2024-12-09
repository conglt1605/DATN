const app = angular.module("myApp", []);

app.controller("ProductController", function ($scope, $http) {
  // Các giá trị mặc định của bộ lọc
  $scope.searchName = "";
  $scope.statusFilter = "";
  $scope.categoryFilter = "";
  $scope.brandFilter = "";

  // Lấy danh sách sản phẩm và áp dụng bộ lọc
  $scope.getAllProducts = function () {
    $http
      .get("http://localhost:8080/api/product/all")
      .then(function (response) {
        if (response.data) {
          $scope.products = response.data.Success || [];
          $scope.applyFilters(); // Áp dụng lọc sau khi nhận được dữ liệu
        } else {
          toastr.error("Không có dữ liệu sản phẩm", "Thông báo");
        }
      })
      .catch(function () {
        toastr.error("Lỗi khi lấy danh sách sản phẩm", "Thông báo");
      });
  };

  // Áp dụng các bộ lọc tìm kiếm và lọc
  $scope.applyFilters = function () {
    $scope.filteredProducts = $scope.products.filter(function (prd) {
      // Kiểm tra theo tên sản phẩm
      const matchName =
        !$scope.searchName ||
        prd.productName.toLowerCase().includes($scope.searchName.toLowerCase());

      // Kiểm tra theo trạng thái
      const matchStatus =
        !$scope.statusFilter || prd.status == $scope.statusFilter;

      // Kiểm tra theo danh mục
      const matchCategory =
        !$scope.categoryFilter || prd.category.id == $scope.categoryFilter;

      // Kiểm tra theo thương hiệu
      const matchBrand =
        !$scope.brandFilter || prd.brand.id == $scope.brandFilter;

      return matchName && matchStatus && matchCategory && matchBrand;
    });
  };

  // Quan sát thay đổi các giá trị lọc và tìm kiếm
  $scope.$watchGroup(
    ["searchName", "statusFilter", "categoryFilter", "brandFilter"],
    function () {
      $scope.applyFilters();
    }
  );

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
    if ($scope.product.imageFile) {
      var imageFile = $scope.product.imageFile;
      var imageFormData = new FormData();
      imageFormData.append("file", imageFile);

      $http
        .post("http://localhost:8080/api/images/upload", imageFormData, {
          transformRequest: angular.identity,
          headers: { "Content-Type": undefined },
        })
        .then(function (response) {
          var imageURL = response.data.imageUrl;
          var productData = {
            productName: $scope.product.productName,
            category: { id: $scope.product.category.id },
            brand: { id: $scope.product.brand.id },
            usageObject: { id: $scope.product.usageObject.id },
            status: $scope.product.status,
            imageURL: imageURL,
          };
          $http
            .post("http://localhost:8080/api/product/add", productData)
            .then(function (response) {
              toastr.success("Sản phẩm đã được thêm thành công", "Thông báo");

              // Đóng modal
              var modal = bootstrap.Modal.getInstance(
                document.getElementById("detailsModal")
              );
              modal.hide();

              // Reset form
              $scope.resetForm();

              // Load lại danh sách sản phẩm
              $scope.getAllProducts();
            })
            .catch(function (error) {
              toastr.error("Lỗi khi thêm sản phẩm", "Thông báo");
            });
        })
        .catch(function (error) {
          toastr.error("Lỗi khi upload ảnh", "Thông báo");
          console.log(error);
        });
    } else {
      var productData = {
        productName: $scope.product.productName,
        category: { id: $scope.product.category.id },
        brand: { id: $scope.product.brand.id },
        usageObject: { id: $scope.product.usageObject.id },
        status: $scope.product.status,
      };

      $http
        .post("http://localhost:8080/api/product/add", productData)
        .then(function (response) {
          toastr.success("Sản phẩm đã được thêm thành công", "Thông báo");

          // Đóng modal
          var modal = bootstrap.Modal.getInstance(
            document.getElementById("detailsModal")
          );
          modal.hide();

          // Reset form
          $scope.resetForm();

          // Load lại danh sách sản phẩm
          $scope.getAllProducts();
        })
        .catch(function (error) {
          toastr.error("Lỗi khi thêm sản phẩm", "Thông báo");
        });
    }
  };

  $scope.fileChanged = function (input) {
    var file = input.files[0]; // Lấy file từ input
    $scope.product.imageFile = file; // Cập nhật imageFile trong scope
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
      imageFile: null,
    };
    document.querySelector("input[type='file']").value = ""; // Xóa file đã chọn
  };

  // Thêm mới danh mục
  $scope.addCategory = function () {
    $http.post("http://localhost:8080/api/category/add", $scope.category).then(
      function (response) {
        console.log("Tạo thành công");
        toastr.success("Danh mục đã được thêm thành công", "Thông báo");
        $scope.categories.push(response.data);
        $scope.resetForm();
      },
      function (error) {
        toastr.error("Lỗi khi thêm danh mục", "Thông báo");
        console.error("Lỗi khi tạo:", error);
      }
    );
  };

  // Thêm mới thương hiệu
  $scope.addBrand = function () {
    $http.post("http://localhost:8080/api/brand/add", $scope.brand).then(
      function (response) {
        console.log("Tạo thành công");
        toastr.success("Danh mục đã được thêm thành công", "Thông báo");
        $scope.brands.push(response.data);
        $scope.resetForm();
      },
      function (error) {
        toastr.error("Lỗi khi thêm thương hiệu", "Thông báo");
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
