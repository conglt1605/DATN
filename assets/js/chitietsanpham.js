var app = angular.module("myApp", []);

const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get("id");

app.controller("chiTietSanPhamController", function ($scope, $http, $window) {
  $scope.sanPhamPreview = []; // Khởi tạo mảng sản phẩ

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
          toastr.error("Không có dữ liệu chi tiết hóa đơn.");
        }
      })
      .catch(function (error) {
        toastr.error("Lỗi khi tải chi tiết hóa đơn.");
        console.error(error);
      });
  };

  // Tạo sản phẩm mới
  $scope.taoSanPham = function () {
    $scope.sanPhamPreview = [];

    $scope.kichCos.forEach((kichCo) => {
      if (kichCo.selected) {
        $scope.mauSacs.forEach((mauSac) => {
          if (mauSac.selected) {
            $scope.sanPhamPreview.push({
              sanPham: $scope.chiTietSanPham.sanPham,
              kichCo: kichCo,
              mauSac: mauSac,
              soLuong: $scope.chiTietSanPham.soLuong,
              giaBan: $scope.chiTietSanPham.giaBan,
              deGiay: $scope.chiTietSanPham.deGiay,
              chatLieu: $scope.chiTietSanPham.chatLieu,
              danhMuc: $scope.chiTietSanPham.sanPham.danhMuc,
              thuongHieu: $scope.chiTietSanPham.sanPham.thuongHieu,
              selectedImages: $scope.chiTietSanPham.anhGiay, // Ảnh sẽ được liên kết ở đây
              chonThem: false,
            });
          }
        });
      }
    });
  };

  $scope.themSanPham = async function () {
    const selectedProducts = $scope.sanPhamPreview.filter(
      (sp) => sp.chonThem === true
    );

    if (selectedProducts.length > 0) {
      try {
        // Duyệt qua từng sản phẩm đã chọn và thêm ảnh cho mỗi sản phẩm
        selectedProducts.forEach((product) => {
          // Kiểm tra nếu sản phẩm có ảnh được chọn
          if (product.selectedImages && product.selectedImages.length > 0) {
            // Chỉ lấy ảnh đầu tiên trong danh sách selectedImages (bạn có thể thay đổi logic nếu cần)
            product.anhGiay = product.selectedImages[0];
          } else {
            toastr.warning(
              "Không có ảnh cho sản phẩm: " + product.sanPham.tenSanPham
            );
          }
        });

        // Gửi dữ liệu sản phẩm đã chọn, bao gồm ảnh
        const response = await $http.post(
          "http://localhost:8080/chitietsanpham",
          selectedProducts
        );

        toastr.success("Sản phẩm đã được thêm vào cơ sở dữ liệu.");
      } catch (error) {
        toastr.error("Có lỗi khi thêm sản phẩm.");
      }
    } else {
      toastr.warning("Chưa chọn sản phẩm nào để thêm.");
    }
  };

  // Mở modal chọn ảnh cho sản phẩm
  $scope.openImageModal = async function (product) {
    $scope.currentProduct = product;

    // Đặt lại trạng thái chọn cho tất cả các ảnh
    $scope.availableImages.forEach((image) => (image.selected = false));

    try {
      const response = await $http.get("http://localhost:8080/anhgiay");
      $scope.availableImages = response.data;
      $("#imageModal").modal("show");
    } catch (error) {
      toastr.error("Lỗi khi tải danh sách ảnh.", "Thông báo");
    }
  };

  // Lấy đường dẫn ảnh
  $scope.getImageUrl = function (image) {
    return (
      "http://localhost:8080/anhgiay/images/" +
      image.tenURL.replace(/^\/images\//, "")
    );
  };

  // Xóa sản phẩm
  $scope.xoaSanPham = function (sp) {
    const index = $scope.sanPhamPreview.indexOf(sp);
    if (index > -1) {
      $scope.sanPhamPreview.splice(index, 1);
      toastr.success("Sản phẩm đã được xóa thành công!");
    } else {
      toastr.error("Không tìm thấy sản phẩm cần xóa.");
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
});
