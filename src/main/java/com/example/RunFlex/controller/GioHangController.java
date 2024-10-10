/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.DeGiay;
import com.example.RunFlex.model.GioHang;
import com.example.RunFlex.service.DeGiayService;
import com.example.RunFlex.service.GioHangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/giohang")
public class GioHangController {

    @Autowired
    private GioHangService gioHangService;

    @GetMapping()
    public List<GioHang> getAll() {
        return gioHangService.getAll();
    }

    @PostMapping()
    public GioHang add(@RequestBody GioHang gioHang) {
        return gioHangService.add(gioHang);
    }
}
