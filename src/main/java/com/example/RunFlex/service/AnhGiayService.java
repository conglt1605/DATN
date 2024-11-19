/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.repository.AnhGiayRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cong
 */
@Service
public class AnhGiayService {
    @Autowired
    private AnhGiayRepository anhGiayRepository;

    // Đường dẫn đến thư mục images trên máy tính của bạn
    private final String uploadDir = "D:\\DATN\\RunFlex_DATN\\assets\\images\\Kho_Anh\\";


    public List<AnhGiay> getAll() {
        return anhGiayRepository.findAll();
    }

    public AnhGiay addWithFile(MultipartFile file, int trangThai) throws IOException {
        // Tạo tên file và đường dẫn lưu ảnh
        String fileName = file.getOriginalFilename();
        String filePath = uploadDir + fileName;

        // Đảm bảo thư mục lưu ảnh tồn tại
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Tạo thư mục nếu chưa có
        }

        // Lưu file vào thư mục
        File dest = new File(filePath);
        file.transferTo(dest);

        // Tạo đối tượng AnhGiay và lưu vào DB
        AnhGiay anhGiay = new AnhGiay();
        anhGiay.setTenURL("/images/" + fileName); // Đường dẫn ảnh lưu trong DB (URL public)
        anhGiay.setTrangThai(trangThai);
        return anhGiayRepository.save(anhGiay);
    }

   public void deleteMultiple(List<Long> ids) {
    // Logic xóa nhiều ảnh theo ID
    for (Long id : ids) {
        anhGiayRepository.deleteById(id);  // Giả sử bạn có phương thức deleteById
    }
}
}
