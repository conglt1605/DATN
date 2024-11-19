/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.service.AnhGiayService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/anhgiay")
public class AnhGiayController {
    @Autowired
    private AnhGiayService anhGiayService;

    // Lấy tất cả ảnh
    @GetMapping
    public List<AnhGiay> getAll() {
        List<AnhGiay> images = anhGiayService.getAll();
        // Đảm bảo URL không bị lặp
        for (AnhGiay anhGiay : images) {
            anhGiay.setTenURL("/images" + anhGiay.getTenURL().replace("/images", "")); // Loại bỏ phần /images nếu có
        }
        return images;
    }

    // Upload ảnh
   @PostMapping("/upload")
    public AnhGiay addWithFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("trangThai") int trangThai) throws IOException {
        return anhGiayService.addWithFile(file, trangThai);
    }

    // Xóa ảnh
   @DeleteMapping
public void deleteMultiple(@RequestBody List<Long> ids) {
    anhGiayService.deleteMultiple(ids);
}


  @GetMapping("/images/{filename}")
public ResponseEntity<Resource> getImage(@PathVariable String filename) throws MalformedURLException {
    // Đường dẫn đến thư mục chứa ảnh
    Path path = Paths.get("D:\\DATN\\RunFlex_DATN\\assets\\images\\Kho_Anh").resolve(filename).normalize();
    Resource resource = new org.springframework.core.io.UrlResource(path.toUri());

    if (resource.exists() || resource.isReadable()) {
        try {
            String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8.toString());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFilename)
                    .body(resource);
        } catch (UnsupportedEncodingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
