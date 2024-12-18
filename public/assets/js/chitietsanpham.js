var app = angular.module("myApp", []);

const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get("id");

app.controller("chiTietSanPhamController", function ($scope, $http, $window) {
  $scope.productPreview = []; // Khởi tạo mảng sản phẩ
  $scope.editData = {};

  $scope.loadData = function () {
    const requests = [
      $http.get("http://localhost:8080/api/brand/all"),
      $http.get("http://localhost:8080/api/category/all"),
      $http.get("http://localhost:8080/api/product/all"),
      $http.get("http://localhost:8080/api/size/all"),
      $http.get("http://localhost:8080/api/color/all"),
      $http.get("http://localhost:8080/api/material/all"),
      $http.get("http://localhost:8080/api/usageobject/all"),
    ];

    Promise.all(requests)
      .then(function (responses) {
        $scope.brands = responses[0].data.Succes;
        $scope.categorys = responses[1].data.Success;
        $scope.products = responses[2].data.Success;
        $scope.sizes = responses[3].data.Success;
        $scope.colors = responses[4].data.Success;
        $scope.materials = responses[5].data.Success;
        $scope.usageobjects = responses[6].data.Success;
        $scope.$apply(); // Cập nhật giao diện
      })
      .catch(function (error) {
        toastr.error("Lỗi khi tải dữ liệu", "Thông báo");
      });
  };

  // Lấy chi tiết sản phẩm theo ID
  $scope.loadChiTietSanPham = function () {
    $http
      .get(`http://localhost:8080/api/productdetail/${id}`)
      .then(function (response) {
        console.log(response.data); // Kiểm tra dữ liệu trả về từ API
        if (response.data && response.data.length > 0) {
          $scope.product = response.data[0].product; //
          $scope.productdetail = response.data; //
          console.log($scope.productdetail); // Kiểm tra chi tiết hóa đơn
        } else {
          toastr.error("Không có dữ liệu chi tiết sản phẩm.");
        }
      })
      .catch(function (error) {
        console.error(error);
      });
  };

  // Tạo sản phẩm mới
  $scope.taoSanPham = function () {
    $scope.sanPhamPreview = []; // Reset lại danh sách sản phẩm xem trước

    // Kiểm tra kích thước và màu sắc được chọn
    $scope.sizes.forEach((size) => {
      if (size.selected) {
        $scope.colors.forEach((color) => {
          if (color.selected) {
            $scope.productPreview.push({
              product: $scope.productdetail.product, // Thông tin sản phẩm
              size: size,
              color: color,
              quantity: $scope.productdetail.quantity, // Số lượng từ chi tiết sản phẩm
              giaBan: $scope.productdetail.price, // Giá bán từ chi tiết sản phẩm
              material: $scope.productdetail.material, // Chất liệu từ chi tiết sản phẩm
              category: $scope.productdetail.product.category, // Danh mục từ chi tiết sản phẩm
              brand: $scope.productdetail.product.brand, // Thương hiệu từ chi tiết sản phẩm
              imageURL: $scope.productdetail.imageURL, // URL ảnh từ chi tiết sản phẩm
              chonThem: false, // Biến để theo dõi sản phẩm có được chọn thêm hay không
            });
          }
        });
      }
    });

    // Kiểm tra nếu có sản phẩm đã được thêm vào danh sách xem trước
    if ($scope.productPreview.length > 0) {
      toastr.success("Các sản phẩm đã được tạo thành công!");
    } else {
      toastr.error("Vui lòng chọn kích cỡ và màu sắc để tạo sản phẩm.");
    }
  };

  $scope.themSanPham = function () {
    // Lọc các sản phẩm đã được chọn (sp.chonThem === true)
    const selectedProducts = $scope.productPreview.filter(function (sp) {
      return sp.chonThem === true; // Lọc các sản phẩm có checkbox được chọn
    });
    // Kiểm tra nếu có sản phẩm được chọn
    if (selectedProducts.length > 0) {
      // Gửi dữ liệu lên server
      $http
        .post("http://localhost:8080/api/productdetail/add", selectedProducts)
        .then(function (response) {
          console.log("Thêm sản phẩm thành công:", response.data);
          toastr.success("Sản phẩm đã được thêm vào cơ sở dữ liệu.");
        })
        .catch(function (error) {
          console.error("Lỗi khi thêm sản phẩm:", error);
          toastr.error("Có lỗi khi thêm sản phẩm.");
        });
    } else {
      toastr.warning("Chưa chọn sản phẩm nào để thêm.");
    }
  };
  // Gửi dữ liệu sản phẩm
  $scope.submitData = async function () {
    try {
      const response = await $http.post(
        "http://localhost:8080/chitietsanpham",
        $scope.chiTietSanPham
      );
      toastr.success("Thêm mới thành công!", "Thông báo");
      const sanPhamId = response.data.sanPham.id;
      if (sanPhamId) {
        $window.location.href = `/html/chitietsanpham.html?id=${sanPhamId}`;
      } else {
        toastr.error("Không có ID sản phẩm trong phản hồi.", "Thông báo");
      }
    } catch (error) {
      toastr.error("Có lỗi khi tạo sản phẩm!", "Thông báo");
    }
  };

  $scope.toggleEditMode = function (product) {
    // Tạo bản sao của sản phẩm và đảm bảo thương hiệu, danh mục và đối tượng sử dụng được sao chép đúng
    $scope.editData = {
      productName: product.productName, // Tên sản phẩm
      productCode: product.productCode, // Mã sản phẩm
      imageURL: product.imageURL, // URL hình ảnh
      product: {
        id: product.id, // ID sản phẩm
        brand: {
          id: product.brand.id, // Sao chép ID thương hiệu
        },
        category: {
          id: product.category.id, // Sao chép ID danh mục
        },
        usageObject: {
          id: product.usageObject ? product.usageObject.id : null, // Kiểm tra đối tượng sử dụng (usageobject)
        },
      },
    };
    console.log($scope.editData); // Kiểm tra dữ liệu
    $scope.loadData(); // Tải dữ liệu thương hiệu, danh mục và đối tượng sử dụng
    $("#editModal").modal("show"); // Mở modal
  };

  $scope.saveChanges = async function () {
    // Đảm bảo rằng bạn chỉ gửi dữ liệu cần thiết
    const updatedProduct = {
      productName: $scope.editData.productName,
      brand: {
        id: $scope.editData.product.brand.id, // Chỉ gửi ID của thương hiệu
      },
      category: {
        id: $scope.editData.product.category.id, // Chỉ gửi ID của danh mục
      },
      usageObject: {
        id: $scope.editData.product.usageObject.id, // Chỉ gửi ID của đối tượng sử dụng
      },
      productCode: $scope.editData.productCode,
      imageURL: $scope.editData.imageURL,
    };

    try {
      // Gửi API PUT với dữ liệu đã chỉnh sửa
      await $http.put(
        `http://localhost:8080/api/product/update/${$scope.editData.product.id}`,
        updatedProduct // Gửi đúng dữ liệu đã chỉnh sửa
      );
      toastr.success("Cập nhật thành công!", "Thông báo");
      $("#editModal").modal("hide"); // Đóng modal
      $scope.loadData(); // Tải lại dữ liệu
    } catch (error) {
      toastr.error("Có lỗi khi cập nhật sản phẩm!", "Thông báo");
    }
  };

  // Cập nhật thông tin sản phẩm
  $scope.updateData = async function (chiTietSanPham) {
    if (chiTietSanPham.isEditing) {
      try {
        await $http.put(
          `http://localhost:8080/chitietsanpham/${chiTietSanPham.id}`,
          chiTietSanPham
        );
        toastr.success("Cập nhật thành công!", "Thông báo");
        chiTietSanPham.isEditing = false;
        $scope.loadData(); // Tải lại dữ liệu
      } catch (error) {
        toastr.error("Có lỗi xảy ra khi cập nhật!", "Thông báo");
      }
    } else {
      chiTietSanPham.isEditing = true;
    }
  };

  // Xóa thông tin sản phẩm
  $scope.deleteData = async function (id) {
    if (confirm("Bạn có chắc chắn muốn xóa chi tiết sản phẩm này?")) {
      try {
        await $http.delete(`http://localhost:8080/chitietsanpham/${id}`);
        $scope.loadData(); // Tải lại dữ liệu sau khi xóa
        toastr.success("Xóa thành công!", "Thông báo");
      } catch (error) {
        toastr.error("Xóa thất bại. Vui lòng thử lại!", "Thông báo");
      }
    }
  };

  $scope.loadChiTietSanPham();
  $scope.loadData();
});
