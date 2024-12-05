app.controller("ProductController", function ($scope, $http) {
  // Thêm $http vào đây
  const apiCategory = "http://localhost:8080/api/category/";
  const apiBrand = "http://localhost:8080/api/brand/";
  const apiusageobject = "http://localhost:8080/api/usageobject/";
  const apiProduct = "http://localhost:8080/api/product/";
  const apiSize = "http://localhost:8080/api/size/";
  $scope.categorys = null;
  $scope.brands = null;
  $scope.usageobjects = null;
  $scope.products;
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

  // Gọi các hàm để lấy dữ liệu
  $scope.getCategorys();
  $scope.getBrands();
  $scope.getUsageObjects();
  $scope.getProducts(0, 12);
  $scope.getSizes();
});
