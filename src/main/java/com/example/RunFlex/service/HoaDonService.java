/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.HoaDon;
import com.example.RunFlex.model.NhanVien;
import com.example.RunFlex.repository.HoaDonRepository;
import com.example.RunFlex.repository.NhanVienRepository;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class HoaDonService {
     @Autowired 
    private HoaDonRepository hoaDonRepository;
   
   public List<HoaDon> getAll(){
       return hoaDonRepository.findAll();
   }
   
   public HoaDon add(HoaDon hoaDon){
       hoaDon.setTrangThai(1);
       hoaDon.setNgayTao(new Date());
       return hoaDonRepository.save(hoaDon);
   }
   
}
