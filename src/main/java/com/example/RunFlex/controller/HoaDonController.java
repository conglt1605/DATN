/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.HoaDon;
import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.service.HoaDonService;
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
@RequestMapping("/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    
    @GetMapping()
    public List<HoaDon> getAll(){
        return hoaDonService.getAll();
    }
    
    @PostMapping()
    public HoaDon add(@RequestBody HoaDon hoaDon){
        return hoaDonService.add(hoaDon);
    }
}