app.service("AuthService", function ($q, $location) {
  this.checkLogin = function () {
    const token = localStorage.getItem("token");
    if (token) {
      // Nếu token tồn tại, cho phép truy cập
      return $q.resolve();
    } else {
      // Nếu không, chuyển hướng về trang đăng nhập
      Swal.fire({
        icon: "warning",
        title: "Vui lòng đăng nhập để tiếp tục!",
        showConfirmButton: false,
        timer: 1500,
      });
      $location.path("/signin");
      return $q.reject("Not logged in");
    }
  };
});
