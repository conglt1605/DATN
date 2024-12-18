const express = require("express");
const path = require("path");

const app = express();
const PORT = process.env.PORT || 3002;

// Cấu hình thư mục chứa tệp tĩnh (HTML, CSS, JS)
app.use(express.static(path.join(__dirname, "public")));

// Định nghĩa route chính (trang chủ)
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

// Đảm bảo tất cả các route khác đều trả về index.html
app.get("*", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

// Khởi động server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
