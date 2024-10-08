/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.Voucher;
import com.example.RunFlex.service.VoucherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
    @RestController
@Controller
@RequestMapping("/voucher")
public class VoucherController {
      @Autowired
    private VoucherService voucherService;
    
    @GetMapping()
    public List<Voucher> getAll(){
        return voucherService.getAll();
    }
    
    @PostMapping()
    public Voucher add(@RequestBody Voucher voucher){
        return voucherService.add(voucher);
    }
    
    @PutMapping("/{id}")
    public Voucher update(@RequestBody Voucher voucher, @PathVariable Long id){
        return voucherService.update(id, voucher);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         voucherService.delete(id);
    }
}
