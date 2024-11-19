/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.HoaDon;
import com.example.RunFlex.service.HoaDonService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/doanhthu")
    public List<Map<String,Object>> getDoanhThu(){
        return hoaDonService.getDoanhThu();
    }
    
    
    @GetMapping("/hoadontrong")
    public HoaDon taoHoaDonTrong(){
        return hoaDonService.taoHoaDonTrong();
    }
    
    @PostMapping("/{id}")
    public HoaDon update(@PathVariable("id") Long id,@RequestBody HoaDon hoaDon){
        return hoaDonService.updateHoaDon(id, hoaDon);
    }
}
