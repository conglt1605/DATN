app.controller("ProductDetailController", function ($scope, $http) {
  $scope.product = JSON.parse(localStorage.getItem("selectedProduct"));
  console.log(product);
  $scope.lstOrderProduct =
    JSON.parse(localStorage.getItem("orderProduct")) || [];
  const apiSize = "http://localhost:8080/api/size/";
  const apiColer = "http://localhost:8080/api/color/";
  const apiMaterial = "http://localhost:8080/api/material/";
  const apiProducDetail = "http://localhost:8080/api/productdetail/";
  const apiProducDetailImage = "http://localhost:8080/api/ProductDetailImage/";

  $scope.sizes = null;
  $scope.colors = null;
  $scope.materials = null;
  $scope.productDetai = null;
  $scope.statusProduct = "Hết Hàng";
  $scope.quantityOder = 1;
  $scope.selected = false;

  // Hàm mua ngay
  $scope.buyNow = function (productDetai) {
    productDetai.quantityOder = $scope.quantityOder;
    // Kiểm tra xem có dữ liệu cũ trong localStorage không
    if (localStorage.getItem("producBuyNow")) {
      // Nếu có, thay thế dữ liệu cũ bằng dữ liệu mới
      localStorage.setItem("producBuyNow", JSON.stringify(productDetai));
    } else {
      // Nếu chưa có, lưu dữ liệu mới vào localStorage
      localStorage.setItem("producBuyNow", JSON.stringify(productDetai));
    }
    // Sau khi lưu vào localStorage, bạn có thể chuyển hướng người dùng đến trang chi tiết sản phẩm (nếu cần)
    window.location.href = "/buynow";
  };

  $scope.oderProduct = function (productDetai) {
    if ($scope.quantityOder === 0) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Vui lòng nhập số lượng",
        showConfirmButton: true,
        timer: 2000,
      });
      return; // Ngừng hàm nếu số lượng là 0
    }
    Swal.fire({
      position: "center",
      icon: "success",
      title: "Đã thêm vào giỏ hàng",
      showConfirmButton: false,
      timer: 1500,
    });
    let existingProduct = $scope.lstOrderProduct.find(
      (order) => order.productDetai.id === productDetai.id
    );
    if (existingProduct) {
      // Nếu sản phẩm đã có, cộng thêm số lượng
      const maxQuantity = existingProduct.productDetai.quantity; // Lấy giá trị tối đa
      const newQuantity = existingProduct.quantity + ($scope.quantityOder || 1);

      // Giới hạn số lượng không vượt quá maxQuantity
      existingProduct.quantity =
        newQuantity > maxQuantity ? maxQuantity : newQuantity;
    } else {
      // Nếu sản phẩm chưa có, tạo mới đối tượng và thêm vào giỏ hàng
      let order = {
        id: `order-${productDetai.id}`, // Tạo id riêng biệt cho mỗi sản phẩm
        productDetai: productDetai,
        quantity: $scope.quantityOder || 0, // Mặc định quantity là 1 nếu không có giá trị
        selected: $scope.selected, // Mặc định là không được chọn
      };
      $scope.lstOrderProduct.push(order);
    }
    localStorage.setItem(
      "orderProduct",
      JSON.stringify($scope.lstOrderProduct)
    );
    console.log($scope.lstOrderProduct);
  };
  $scope.removeProduct = function (productDetai) {
    // Tìm chỉ số của sản phẩm trong giỏ hàng dựa trên id
    let index = $scope.lstOrderProduct.findIndex(
      (order) => order.productDetai.id === productDetai.id
    );

    // Nếu tìm thấy sản phẩm, xóa nó khỏi giỏ hàng
    if (index !== -1) {
      $scope.lstOrderProduct.splice(index, 1); // Xóa 1 phần tử tại vị trí index
    }

    // Cập nhật lại giỏ hàng vào localStorage
    localStorage.setItem(
      "orderProduct",
      JSON.stringify($scope.lstOrderProduct)
    );

    // In ra giỏ hàng để kiểm tra
    console.log($scope.lstOrderProduct);
  };
  // Fetch product details after the other data is ready
  $scope.getProductDetail = function () {
    const params = {
      sizeId: $scope.selectedSize,
      productId: $scope.product.id,
      colorId: $scope.selectedColor,
      materialId: $scope.selectedMaterial,
    };
    $http
      .get(apiProducDetail + "getProducDetail", { params: params })
      .then(function (response) {
        $scope.productDetai = response.data.Success;
        $scope.quantityDetail = response.data.Success.quantity;
        $scope.imageURL = response.data.Success.imageURL;
        console.log("productdetail", $scope.productDetai);
        if ($scope.quantityDetail > 0) {
          $scope.statusProduct = "Còn Hàng";
        } else {
          $scope.statusProduct = "Hết Hàng";
        }
        $scope.productDetailImage();
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu sản phẩm:", error);
        $scope.statusProduct = "Hết Hàng";
        $scope.quantityDetail = 0;
        $scope.images = [];
        return;
      });
  };

  // Get Sizes
  $scope.getSizes = function () {
    return $http
      .get(apiProducDetail + "getSizeByProductID", {
        params: { productID: $scope.product.id },
      })
      .then(function (response) {
        $scope.sizes = response.data.Success;
        $scope.selectedSize = $scope.sizes[0].sizeID;
        console.log("sizesbyPD", $scope.sizes);
        console.log("$scope.product:", $scope.product);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu kích cỡ:", error);
      });
  };

  // Get Colors
  $scope.getColers = function () {
    return $http
      .get(apiProducDetail + "getColorByProductID", {
        params: { productID: $scope.product.id },
      })
      .then(function (response) {
        $scope.colors = response.data.Success;
        $scope.selectedColor = $scope.colors[0].colorID;
        console.log("colorsByPD", $scope.colors);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu màu sắc:", error);
      });
  };

  // Get Materials
  $scope.getMaterials = function () {
    return $http
      .get(apiProducDetail + "getMaterialByProductID", {
        params: { productID: $scope.product.id },
      })
      .then(function (response) {
        $scope.materials = response.data.Success;
        $scope.selectedMaterial = $scope.materials[0].materialID;
        console.log("materialsByPD", $scope.materials);
      })
      .catch(function (error) {
        console.error("Lỗi khi lấy dữ liệu chất liệu:", error);
      });
  };

  // Wait for all data to load before calling getProductDetail
  Promise.all([$scope.getSizes(), $scope.getColers(), $scope.getMaterials()])
    .then(function () {
      // Once all promises are resolved, fetch the product details
      $scope.getProductDetail();
    })
    .catch(function (error) {
      console.error("Lỗi khi tải dữ liệu ban đầu:", error);
    });

  $scope.selectColor = function (colorId) {
    $scope.selectedColor = colorId;
    console.log("Selected color:", colorId);
    $scope.getProductDetail();
  };

  $scope.selectSize = function (sizeId) {
    $scope.selectedSize = sizeId;
    console.log("Selected size:", sizeId);
    $scope.getProductDetail();
  };

  $scope.selectMaterial = function (materialId) {
    $scope.selectedMaterial = materialId;
    console.log("Selected material:", materialId);
    $scope.getProductDetail();
  };

  $scope.checkStock = function (statusProduct) {
    if (statusProduct === "Hết Hàng") {
      // Nếu sản phẩm hết hàng, không cho thay đổi số lượng
      $scope.quantityOder = 0; // Hoặc bất kỳ giá trị nào mà bạn muốn mặc định khi hết hàng
      Swal.fire({
        position: "center",
        icon: "error",
        title: "Sản phẩm đã hết hàng!",
        showConfirmButton: true,
        timer: 2000,
      });
    } else if ($scope.quantityOder > $scope.quantityDetail) {
      // Nếu số lượng vượt quá số lượng tối đa, chỉnh lại về số lượng tối đa
      $scope.quantityOder = $scope.quantityDetail;
    } else if ($scope.quantityOder < 0) {
      // Nếu số lượng vượt quá số lượng tối đa, chỉnh lại về số lượng tối đa
      $scope.quantityOder = 1;
    }
  };

  $scope.productDetailImage = function () {
    $http
      .get(apiProducDetailImage + "imageWithID", {
        params: { id: $scope.productDetai.id },
      })
      .then(function (response) {
        $scope.images = response.data.Success || [];
        console.log("images", $scope.images);
      })
      .catch(function (error) {
        console.log("Lỗi khi lấy ảnh :", error);
      });
  };
});