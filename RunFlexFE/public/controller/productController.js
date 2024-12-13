app.controller("ProductController", function ($scope, $http, $window) {
  // Thêm $http vào đây
  const apiCategory = "http://localhost:8080/api/category/";
  const apiBrand = "http://localhost:8080/api/brand/";
  const apiusageobject = "http://localhost:8080/api/usageobject/";
  const apiProduct = "http://localhost:8080/api/product/";
  const apiSize = "http://localhost:8080/api/size/";
  const apiProductDetail = "http://localhost:8080/api/productdetail/";
  const apiColor = "http://localhost:8080/api/color/";
  const apiMaterial = "http://localhost:8080/api/material/";

  $scope.selectedBrands = {}; // Thương hiệu đã chọn
  $scope.selectedCategories = {}; // Danh mục đã chọn
  $scope.selectedUsageObjects = {}; // Đối tượng sử dụng đã chọn
  $scope.selectedSizes = {}; // Kích cỡ đã chọn
  $scope.selectedColors = {}; // Màu sắc đã chọn
  $scope.selectedMaterials = {}; // Chất liệu đã chọn
  $scope.categorys = null;
  $scope.brands = null;
  $scope.usageobjects = null;
  $scope.products;
  $scope.number = 0; // Trang hiện tại

  $scope.selectProduct = function (product) {
    localStorage.setItem("selectedProduct", JSON.stringify(product));
    window.location.href = "/detail";
  };
  $scope.getProducts = function (page, pageSize) {
    // Tạo đối tượng params để truyền tham số vào request
    const params = {
      page: page,
      size: pageSize,
    };
    $http
      .get(apiProduct + "page", { params: params })
      .then(function (response) {
        $scope.products = response.data.Success.content;
        console.log("products", $scope.products);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu sản phẩm:", error);
      });
  };

  // //Hàm lấy màu sắc
  $scope.getcolors = function () {
    $http
      .get(apiColor + "active")
      .then(function (response) {
        $scope.colors = response.data.Success;
        console.log("colors", $scope.colors);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu màu sắc:", error);
      });
  };

  // //Hàm lấy màu sắc
  $scope.getMaterial = function () {
    $http
      .get(apiMaterial + "active")
      .then(function (response) {
        $scope.materials = response.data.Success;
        console.log("materials", $scope.materials);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu chất liệu:", error);
      });
  };

  // //Hàm lấy kích cỡ
  $scope.getSizes = function () {
    $http
      .get(apiSize + "active")
      .then(function (response) {
        $scope.sizes = response.data.Success;
        console.log("Sizes", $scope.sizes);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu kích cỡ:", error);
      });
  };

  // Hàm lấy danh mục
  $scope.getCategorys = function () {
    $http
      .get(apiCategory + "active")
      .then(function (response) {
        $scope.categorys = response.data.Success;
        console.log("categorys", $scope.categorys);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu danh mục:", error);
      });
  };

  // Hàm lấy thương hiệu
  $scope.getBrands = function () {
    $http
      .get(apiBrand + "active")
      .then(function (response) {
        $scope.brands = response.data.Succes;
        console.log("brands", $scope.brands);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu thương hiệu:", error);
      });
  };

  // Hàm lấy đối tượng sử dụng
  $scope.getUsageObjects = function () {
    $http
      .get(apiusageobject + "active")
      .then(function (response) {
        $scope.usageobjects = response.data.Success;
        console.log("usageobjects", $scope.usageobjects);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu đối tượng sử dụng:", error);
      });
  };

  // Hàm lấy giá min max
  $scope.getPriceMinMax = function (product) {
    $http
      .get(apiProductDetail + "priceMinMax", {
        params: { productID: product.id },
      })
      .then(function (response) {
        product.priceMinMax = response.data.Success;
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu giá :", error);
      });
  };

  $scope.findProducts = function (page) {
    // if (page < 0 || page >= $scope.totalPages) {
    //   return; // Không thực hiện nếu trang không hợp lệ
    // }
    // Lấy danh sách các brandIds đã chọn (chỉ chọn những thương hiệu có giá trị true)
    var brandIds = Object.keys($scope.selectedBrands).filter(function (key) {
      return $scope.selectedBrands[key];
    });

    // Lấy danh sách các categoryIds, usageObjectIds, sizeIds, colorIds, materialIds đã chọn
    var categoryIds = Object.keys($scope.selectedCategories).filter(function (
      key
    ) {
      return $scope.selectedCategories[key];
    });

    var usageObjectIds = Object.keys($scope.selectedUsageObjects).filter(
      function (key) {
        return $scope.selectedUsageObjects[key];
      }
    );

    var sizeIds = Object.keys($scope.selectedSizes).filter(function (key) {
      return $scope.selectedSizes[key];
    });

    var colorIds = Object.keys($scope.selectedColors).filter(function (key) {
      return $scope.selectedColors[key];
    });

    var materialIds = Object.keys($scope.selectedMaterials).filter(function (
      key
    ) {
      return $scope.selectedMaterials[key];
    });

    // Gọi API với các tham số đã được lọc
    $http
      .get(apiProduct + "filter", {
        params: {
          brandIds: brandIds.join(","), // Chuyển mảng thành chuỗi
          categoryIds: categoryIds.join(","),
          usageObjectIds: usageObjectIds.join(","),
          sizeIds: sizeIds.join(","),
          colorIds: colorIds.join(","),
          materialIds: materialIds.join(","),
          productName: $scope.productName, // Tên sản phẩm tìm kiếm
          page: page, // Trang hiện tại
        },
      })
      .then(function (response) {
        $scope.productsFilters = response.data.productsFilterDto.content; // Lưu kết quả trả về
        $scope.errorFilter = response.data.error;
        console.log("ProductFilter: ", $scope.productsFilters);
        console.log($scope.errorFilter);
        $scope.page = response.data.productsFilterDto.page;
        console.log("page:", $scope.page);
        $scope.totalPages = response.data.productsFilterDto.page.totalPages; // Tổng số trang
        $scope.number = response.data.productsFilterDto.page.number;
        $scope.size = response.data.productsFilterDto.page.size;
      });
    // Cuộn lên đầu trang
    // window.scrollTo(0, 0);
  };

  $scope.updateFilter = function () {
    $scope.findProducts();
  };

  // Gọi các hàm để lấy dữ liệu
  $scope.findProducts();
  $scope.getCategorys();
  $scope.getBrands();
  $scope.getUsageObjects();
  $scope.getProducts(0, 12);
  $scope.getSizes();
  $scope.getcolors();
  $scope.getMaterial();
});
