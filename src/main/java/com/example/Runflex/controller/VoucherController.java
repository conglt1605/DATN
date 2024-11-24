/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.Voucher;
import com.example.Runflex.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voucher")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return voucherService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveVouchers() {
        return voucherService.getActiveVouchers();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Voucher voucher) {
        return voucherService.saveVoucher(voucher);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Voucher voucher) {
        return voucherService.updateVoucher(id, voucher);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return voucherService.deleteVoucher(id);
    }
}

