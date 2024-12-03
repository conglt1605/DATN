// Tìm các phần tử có chứa class .sidebar-link và thêm sự kiện click
document.querySelectorAll(".sidebar-link").forEach((link) => {
  link.addEventListener("click", function () {
    // Tìm mũi tên bên trong link được nhấn
    const arrowIcon = this.querySelector(".arrow-icon");
    // Kiểm tra trạng thái của collapse (đã mở hoặc đóng)
    const collapseMenu = document.querySelector(
      this.getAttribute("data-bs-target")
    );

    // Sự kiện khi menu mở
    collapseMenu.addEventListener("shown.bs.collapse", () => {
      arrowIcon.style.transform = "rotate(90deg)";
    });

    // Sự kiện khi menu đóng
    collapseMenu.addEventListener("hidden.bs.collapse", () => {
      arrowIcon.style.transform = "rotate(0deg)";
    });
  });
});

Swal.fire({
  title: "Xác nhận cập nhật trạng thái",
  text: `Trạng thái hiện tại: ${getStatus(
    invoice.status
  )}. Chuyển sang: ${getStatus(invoice.status + 1)}?`,
  icon: "warning",
  showCancelButton: true,
  confirmButtonText: "Đồng ý",
  cancelButtonText: "Hủy",
}).then((result) => {
  if (result.isConfirmed) {
    // Gọi API nếu người dùng đồng ý
    updateInvoiceStatus(invoice, newStatus);
  } else {
    toastr.info("Bạn đã hủy cập nhật trạng thái.");
  }
});

app.config(function () {
  toastr.options = {
    closeButton: true,
    debug: false,
    newestOnTop: false,
    progressBar: true,
    positionClass: "toast-top-right",
    preventDuplicates: false,
    onclick: null,
    showDuration: "300",
    hideDuration: "1000",
    timeOut: "5000",
    extendedTimeOut: "2000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut",
  };
});
